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
			dto.setPassword("12345");
			dto.setUsername(authenticationRequest.getUsername());
			try {
				FirstLoginResponse loginResponse = agentClient.login(dto);
			} catch (Exception e2) {
				return new ResponseEntity(HttpStatus.UNAUTHORIZED);
			}

			SyncUslugeResponse usluge = agentClient.dopuniUsluge();
			SyncCategoriesResponse kategorije = agentClient.dopuniKategorije();

			List<UslugaXMLDTO> listaUsluga = usluge.getUsluge();
			List<CategoryXMLDTO> listaKategorija = kategorije.getCategories();

			for (int i = 0; i < listaUsluga.size(); i++) {
				UslugaXMLDTO u = listaUsluga.get(i);
				Usluga us = new Usluga();
				us.setCena(u.getCena());
				us.setNaziv(u.getNaziv());
				us.setOpis(u.getOpis());
				us.setIdGlBaza(Long.parseLong(u.getId()));

				uslugaRepository.save(us);
			}

			for (int i = 0; i < listaKategorija.size(); i++) {
				CategoryXMLDTO c = listaKategorija.get(i);
				Category ca = new Category();
				ca.setNaziv(c.getNaziv());
				ca.setVrednost(c.getVrednost());
				ca.setIdGlBaza(Long.parseLong(c.getId()));

				categoryRepository.save(ca);
			}

			for (int i = 0; i < listaUsluga.size(); i++) {
				UslugaXMLDTO u = listaUsluga.get(i);
				Usluga us = uslugaRepository.findUslugaSaIdGlBaze(Long.parseLong(u.getId()));
				for(int j = 0; j < listaKategorija.size(); j++) {
					if(u.getCategories().contains(Long.parseLong(listaKategorija.get(j).getId()))) {
						Category c = categoryRepository.findCathegorySaIdGlBaze(Long.parseLong(listaKategorija.get(j).getId()));
						u.getCategories().add(c.getId());
					}
				}

				uslugaRepository.save(us);
			}

			for (int i = 0; i < listaKategorija.size(); i++) {
				CategoryXMLDTO c = listaKategorija.get(i);
				Category ca = categoryRepository.findCathegorySaIdGlBaze(Long.parseLong(c.getId()));
				for(int j = 0; j < listaUsluga.size(); j++) {
					if(c.getUsluge().contains(Long.parseLong(listaUsluga.get(j).getId()))) {
						Usluga u = uslugaRepository.findUslugaSaIdGlBaze(Long.parseLong(listaUsluga.get(j).getId()));
						c.getUsluge().add(u.getId());
					}
				}

				categoryRepository.save(ca);
			}



		userDTO.setFirstLogin(true);
			String jwt = tokenUtils.generateToken(authenticationRequest.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();

			userDTO.setExpiresIn(expiresIn);
			userDTO.setToken(jwt);
			userDTO.setUsername(authenticationRequest.getUsername());
		return new ResponseEntity(userDTO, HttpStatus.OK);
	}

		SyncUslugeResponse usluge = agentClient.dopuniUsluge();
		SyncCategoriesResponse kategorije = agentClient.dopuniKategorije();
		SyncReservationsResponse rezervacije = agentClient.dopuniRezervacije();

		List<UslugaXMLDTO> listaUsluga = usluge.getUsluge();
		List<CategoryXMLDTO> listaKategorija = kategorije.getCategories();
		List<RezervacijaXMLDTO> listaRezervacija = rezervacije.getReservations();

		for (int i = 0; i < listaUsluga.size(); i++) {
			UslugaXMLDTO u = listaUsluga.get(i);
			Usluga us = new Usluga();
			us.setCena(u.getCena());
			us.setNaziv(u.getNaziv());
			us.setOpis(u.getOpis());
			us.setIdGlBaza(Long.parseLong(u.getId()));

			uslugaRepository.save(us);
		}

		for (int i = 0; i < listaKategorija.size(); i++) {
			CategoryXMLDTO c = listaKategorija.get(i);
			Category ca = new Category();
			ca.setNaziv(c.getNaziv());
			ca.setVrednost(c.getVrednost());
			ca.setIdGlBaza(Long.parseLong(c.getId()));

			categoryRepository.save(ca);
		}

		for(int i = 0; i < listaRezervacija.size(); i++) {
			RezervacijaXMLDTO r = listaRezervacija.get(i);
			Rezervacija re = new Rezervacija();
			re.setIdGlBaza(Long.parseLong(r.getId()));
			re.setuCena(r.getUCena());
			SJedinica sj = sJedinicaRepository.findOneById(Long.parseLong(r.getSJedinicaID()));
			re.setsJedinica(sj);
			int y = r.getDatumRez().getYear();
			int m = r.getDatumRez().getMonth();
			int d = r.getDatumRez().getDay();
			Date reee = new Date(y, m, d);
			re.setDatumRez(reee);

			int y1 = r.getDo().getYear();
			int m1 = r.getDo().getMonth();
			int d1 = r.getDo().getDay();
			Date reee1 = new Date(y1, m1, d1);
			re.set_do(reee1);

			int y2 = r.getOd().getYear();
			int m2 = r.getOd().getMonth();
			int d2 = r.getOd().getDay();
			Date reee2 = new Date(y2, m2, d2);
			re.setOd(reee2);
			re.setKorisnik(r.getKorisnik());

		}

		for (int i = 0; i < listaUsluga.size(); i++) {
			UslugaXMLDTO u = listaUsluga.get(i);
			Usluga us = uslugaRepository.findUslugaSaIdGlBaze(Long.parseLong(u.getId()));
			for(int j = 0; j < listaKategorija.size(); j++) {
				if(u.getCategories().contains(Long.parseLong(listaKategorija.get(j).getId()))) {
					Category c = categoryRepository.findCathegorySaIdGlBaze(Long.parseLong(listaKategorija.get(j).getId()));
					u.getCategories().add(c.getId());
				}
			}

			uslugaRepository.save(us);
		}

		for (int i = 0; i < listaKategorija.size(); i++) {
			CategoryXMLDTO c = listaKategorija.get(i);
			Category ca = categoryRepository.findCathegorySaIdGlBaze(Long.parseLong(c.getId()));
			for(int j = 0; j < listaUsluga.size(); j++) {
				if(c.getUsluge().contains(Long.parseLong(listaUsluga.get(j).getId()))) {
					Usluga u = uslugaRepository.findUslugaSaIdGlBaze(Long.parseLong(listaUsluga.get(j).getId()));
					c.getUsluge().add(u.getId());
				}
			}

			categoryRepository.save(ca);
		}



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
		User u=new User();
		u.setUsername(user.getUsername());
		u.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(u);
		return new ResponseEntity(HttpStatus.OK);
	}
}