package com.megatravel.agentback.controller;

import com.megatravel.agentback.client.AgentClient;
import com.megatravel.agentback.dto.UserDTO;
import com.megatravel.agentback.dto.UslugaDTO;
import com.megatravel.agentback.model.*;
import com.megatravel.agentback.repository.*;
import com.megatravel.agentback.security.TokenUtils;
import com.megatravel.agentback.security.auth.JwtAuthenticationRequest;
import com.megatravel.agentback.service.CustomUserDetailsService;

import com.megatravel.agentback.xml.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Kontroler zaduzen za autentifikaciju Usera
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	AgentClient agentClient;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private UslugaRepository uslugaRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Autowired
	private SJedinicaRepository sJedinicaRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AccomodationTypeRepository accomodationTypeRepository;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
													   HttpServletResponse response) throws AuthenticationException, IOException {

		UserDTO userDTO = new UserDTO();

		Authentication authentication = null;
		try {
			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {

			UserCredentialsXMLDTO dto = new UserCredentialsXMLDTO();
			dto.setPassword("123");
			dto.setUsername(authenticationRequest.getUsername());
			try {
				FirstLoginResponse loginResponse = agentClient.login(dto);
			} catch (Exception e2) {
				e2.printStackTrace();
				return new ResponseEntity(HttpStatus.UNAUTHORIZED);
			}

			SyncUslugeResponse usluge = agentClient.dopuniUsluge(authenticationRequest.getUsername());
			SyncCategoriesResponse kategorije = agentClient.dopuniKategorije(authenticationRequest.getUsername());
			SyncAccommodationTypeResponse ats=agentClient.dopuniAccomType(authenticationRequest.getUsername());

			List<UslugaXMLDTO> listaUsluga = usluge.getUsluge();
			List<CategoryXMLDTO> listaKategorija = kategorije.getCategories();
			List<AccomodationTypeXMLDTO> listAT=ats.getAccommodationTypes();

			for (int i = 0; i < listaUsluga.size(); i++) {
				UslugaXMLDTO u = listaUsluga.get(i);
				Usluga us = uslugaRepository.findById(Long.parseLong(u.getId())).orElse(null);
				if(us==null){
					Usluga usl=new Usluga();
					usl.setCena(u.getCena());
					usl.setNaziv(u.getNaziv());
					usl.setOpis(u.getOpis());

					uslugaRepository.save(usl);
				}else{
					us.setCena(u.getCena());
					us.setNaziv(u.getNaziv());
					us.setOpis(u.getOpis());

					uslugaRepository.save(us);
				}

			}

			for (int i = 0; i < listaKategorija.size(); i++) {
				CategoryXMLDTO c = listaKategorija.get(i);
				Category ca = categoryRepository.findOneById(Long.parseLong(c.getId()));
				if(ca==null){
					Category cat=new Category();
					cat.setNaziv(c.getNaziv());
					cat.setVrednost(c.getVrednost());
					categoryRepository.save(cat);
				}else{
					ca.setNaziv(c.getNaziv());
					ca.setVrednost(c.getVrednost());
					categoryRepository.save(ca);
				}
			}

			for (int i = 0; i < listAT.size(); i++) {
				AccomodationTypeXMLDTO at = listAT.get(i);
				AccomodationType att = accomodationTypeRepository.findOneById(Long.parseLong(at.getId()));
				if(att==null){
					AccomodationType aat=new AccomodationType();
					aat.setNaziv(at.getNaziv());
					accomodationTypeRepository.save(aat);
				}else{
					att.setNaziv(at.getNaziv());
					accomodationTypeRepository.save(att);
				}
			}



			for (int i = 0; i < listaUsluga.size(); i++) {
				UslugaXMLDTO u = listaUsluga.get(i);
				Usluga us = uslugaRepository.findById(Long.parseLong(u.getId())).orElse(null);
				for(int j = 0; j < listaKategorija.size(); j++) {
					if(u.getCategories().contains(Long.parseLong(listaKategorija.get(j).getId()))) {
						Category c = categoryRepository.findById(Long.parseLong(listaKategorija.get(j).getId())).orElse(null);

						us.getCategoryList().add(c);
						c.getUslugaList().add(us);
						categoryRepository.save(c);
					}
				}

				//uslugaRepository.save(us);
			}



			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);

		userDTO.setFirstLogin(true);
			String jwt = tokenUtils.generateToken(authenticationRequest.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();

			userDTO.setExpiresIn(expiresIn);
			userDTO.setToken(jwt);
			userDTO.setUsername(authenticationRequest.getUsername());
		return new ResponseEntity(userDTO, HttpStatus.OK);
	}
		UserCredentialsXMLDTO dto=new UserCredentialsXMLDTO();
		dto.setPassword(authenticationRequest.getPassword());
		dto.setUsername(authenticationRequest.getUsername());
		agentClient.login(dto);

		SyncUslugeResponse usluge = agentClient.dopuniUsluge(authenticationRequest.getUsername());
		SyncCategoriesResponse kategorije = agentClient.dopuniKategorije(authenticationRequest.getUsername());
		SyncReservationsResponse rezervacije = agentClient.dopuniRezervacije(authenticationRequest.getUsername());
		SyncAccommodationTypeResponse ats=agentClient.dopuniAccomType(authenticationRequest.getUsername());

		List<UslugaXMLDTO> listaUsluga = usluge.getUsluge();
		List<CategoryXMLDTO> listaKategorija = kategorije.getCategories();
		List<RezervacijaXMLDTO> listaRezervacija = rezervacije.getReservations();
		List<AccomodationTypeXMLDTO> listAT=ats.getAccommodationTypes();

		for (int i = 0; i < listaUsluga.size(); i++) {
			UslugaXMLDTO u = listaUsluga.get(i);
			Usluga us = uslugaRepository.findById(Long.parseLong(u.getId())).orElse(null);
			if(us==null){
				Usluga usl=new Usluga();
				usl.setCena(u.getCena());
				usl.setNaziv(u.getNaziv());
				usl.setOpis(u.getOpis());

				uslugaRepository.save(usl);
			}else{
				us.setCena(u.getCena());
				us.setNaziv(u.getNaziv());
				us.setOpis(u.getOpis());

				uslugaRepository.save(us);
			}

		}

		for (int i = 0; i < listaKategorija.size(); i++) {
			CategoryXMLDTO c = listaKategorija.get(i);
			Category ca = categoryRepository.findOneById(Long.parseLong(c.getId()));
			if(ca==null){
				Category cat=new Category();
				cat.setNaziv(c.getNaziv());
				cat.setVrednost(c.getVrednost());
				categoryRepository.save(cat);
			}else{
				ca.setNaziv(c.getNaziv());
				ca.setVrednost(c.getVrednost());
				categoryRepository.save(ca);
			}
		}

		for (int i = 0; i < listAT.size(); i++) {
			AccomodationTypeXMLDTO at = listAT.get(i);
			AccomodationType att = accomodationTypeRepository.findOneById(Long.parseLong(at.getId()));
			if(att==null){
				AccomodationType aat=new AccomodationType();
				aat.setNaziv(at.getNaziv());
				accomodationTypeRepository.save(aat);
			}else{
				att.setNaziv(at.getNaziv());
				accomodationTypeRepository.save(att);
			}
		}

		for(int i = 0; i < listaRezervacija.size(); i++) {
			RezervacijaXMLDTO r = listaRezervacija.get(i);
			Rezervacija re = new Rezervacija();
			re.setIdGlBaza(Long.parseLong(r.getId()));
			re.setuCena(r.getUCena());

			Date reee = r.getDatumRez().toGregorianCalendar().getTime();
			re.setDatumRez(reee);


			Date reee1 = r.getDo().toGregorianCalendar().getTime();
			re.set_do(reee1);

			Date reee2 = r.getOd().toGregorianCalendar().getTime();
			re.setOd(reee2);
			re.setKorisnik(r.getKorisnik());

			if(r.isCanBeRated())
				re.setStatusRezervacije(StatusRezervacije.REALIZOVANA);
			if(r.isCanceled())
				re.setStatusRezervacije(StatusRezervacije.OTKAZANO);
			if(!r.isCanBeRated())
				re.setStatusRezervacije(StatusRezervacije.REZERVISANO);

			if(rezervacijaRepository.findByIdGlBaza(re.getIdGlBaza())==null) {
				rezervacijaRepository.save(re);

				SJedinica sj = sJedinicaRepository.findOneByIdGlBaza(Long.parseLong(r.getSJedinicaID()));
				re.setsJedinica(sj);
				sj.getRezervacije().add(re);

				rezervacijaRepository.save(re);
			}
		}

		for (int i = 0; i < listaUsluga.size(); i++) {
			UslugaXMLDTO u = listaUsluga.get(i);
			Usluga us = uslugaRepository.findById(Long.parseLong(u.getId())).orElse(null);
			for(int j = 0; j < listaKategorija.size(); j++) {
				if(u.getCategories().contains(Long.parseLong(listaKategorija.get(j).getId()))) {
					Category c = categoryRepository.findById(Long.parseLong(listaKategorija.get(j).getId())).orElse(null);

					us.getCategoryList().add(c);
					c.getUslugaList().add(us);
					categoryRepository.save(c);
				}
			}

			//uslugaRepository.save(us);
		}

		/*for (int i = 0; i < listaKategorija.size(); i++) {
			CategoryXMLDTO c = listaKategorija.get(i);
			Category ca = categoryRepository.findCathegorySaIdGlBaze(Long.parseLong(c.getId()));
			for(int j = 0; j < listaUsluga.size(); j++) {
				if(c.getUsluge().contains(Long.parseLong(listaUsluga.get(j).getId()))) {
					Usluga u = uslugaRepository.findUslugaSaIdGlBaze(Long.parseLong(listaUsluga.get(j).getId()));
					c.getUsluge().add(u.getId());
				}
			}

			categoryRepository.save(ca);
		}*/



		// Ubaci username + password u kontext
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		userDTO.setExpiresIn(expiresIn);
		userDTO.setId(user.getId());
		userDTO.setIme(user.getIme());
		userDTO.setPrezime(user.getPrezime());
		userDTO.setUsername(user.getUsername());
		userDTO.setToken(jwt);
		userDTO.setFirstLogin(false);


		// Vrati token kao odgovor na uspesno autentifikaciju
		return ResponseEntity.ok(userDTO);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
	    User user = (User) this.userDetailsService.loadUserByUsername(username);



		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}

	@RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
	public ResponseEntity<?> changePassword(@RequestBody UserDTO user) {
		UserCredentialsXMLDTO crendetials=new UserCredentialsXMLDTO();
		crendetials.setPassword(user.getPassword());
		crendetials.setUsername(user.getUsername());
		try {
			agentClient.promeniSifru(crendetials);
		}catch (Exception e){
			e.printStackTrace();
		}

		userDetailsService.changePassword("123", user.getPassword());

		return new ResponseEntity(HttpStatus.OK);
	}
}