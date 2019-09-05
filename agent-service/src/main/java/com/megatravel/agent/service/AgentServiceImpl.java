package com.megatravel.agent.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megatravel.agent.dto.MakeResDTO;
import com.megatravel.agent.dto.UslugaDTO;
import com.megatravel.agent.model.*;
import com.megatravel.agent.repository.*;
import com.megatravel.agent.utils.ObjectMapperUtils;
import com.megatravel.agent.xml.dto.*;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;
import java.util.*;


@Service
public class AgentServiceImpl implements AgentService {



	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	SmestajRepository smestajRepository;

	@Autowired
	UslugaRepository uslugaRepository;

	@Autowired
	AccomodationRepository accomodationRepository;

	@Autowired
	SJedinicaRepository sJedinicaRepository;

	@Autowired
	PorukaRepository porukaRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	RezervacijaRepository rezervacijaRepository;

	@Autowired
    ImageRepository imageRepository;

	@Autowired
	AccommodationTypeRepository accomodationTypeRepository;

	@Autowired
	AdresaRepository adresaRepository;

	@Override
	public SmestajXMLDTO addAccommodation(SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		User u=userRepository.findByUsername(username);
		if(u!=null){
			Smestaj s=new Smestaj(accommodation);
			smestajRepository.save(s);

			//postavi usluge i sacuvaj ga
			if(accommodation.getUslugaList()!=null) {
				for (UslugaXMLDTO uXML : accommodation.getUslugaList()) {
					Usluga usluga = uslugaRepository.findById(uXML.getId()).orElse(null);
					usluga.getSmestaj().add(s);
					s.getUslugaList().add(usluga);
					uslugaRepository.save(usluga);
				}
			}

			//postavi AccomodationType i sacuvaj ga
			if(accommodation.getAccomodationType()!=null) {
				AccomodationType accomodationType = accomodationRepository.findById(accommodation.getAccomodationType().getId()).orElse(null);
				accomodationType.getSmestajList().add(s);
				s.setAccomodationType(accomodationType);
			}
			Adresa addr=new Adresa(accommodation.getAdresa());
			adresaRepository.save(addr);
			addr.setSmestaj(s);
			s.setAdresa(addr);

			setCategoryForAccomodation(s);

			//postavi Agenta i sacuvaj ga
			u.getSmestaji().add(s);
			userRepository.save(u);
			s.setAgent(u);

			smestajRepository.save(s);

			SmestajXMLDTO ret=accommodation;
			ret.setId(s.getId());
			return ret;
		}
		String faultString = "Bad username";
		String faultCodeValue = "401";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}

	@Override
	public boolean editAccommodation(SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		User u=userRepository.findByUsername(username);
		if(u!=null){
			Smestaj s=smestajRepository.findById(accommodation.getId()).orElse(null);
			s.getUslugaList().clear();
			//postavi usluge i sacuvaj ga
			if(accommodation.getUslugaList()!=null) {
				for (UslugaXMLDTO uXML : accommodation.getUslugaList()) {
					Usluga usluga = uslugaRepository.findById(uXML.getId()).orElse(null);
					usluga.getSmestaj().add(s);
					s.getUslugaList().add(usluga);
					uslugaRepository.save(usluga);
				}
			}

			//postavi AccomodationType i sacuvaj ga
			if(accommodation.getAccomodationType()!=null) {
				AccomodationType accomodationType = accomodationRepository.findById(accommodation.getAccomodationType().getId()).orElse(null);
				accomodationType.getSmestajList().add(s);
				s.setAccomodationType(accomodationType);
			}
			Adresa addr=new Adresa(accommodation.getAdresa());
			adresaRepository.save(addr);
			addr.setSmestaj(s);
			s.setAdresa(addr);

			setCategoryForAccomodation(s);

			smestajRepository.save(s);


			return true;
		}
		String faultString = "Bad username";
		String faultCodeValue = "401";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}

	@Override
	public SJedinicaXMLDTO addAccommodationUnit(SJedinicaXMLDTO accommodationUnit) throws SOAPFaultException, SOAPException {
		Smestaj s=smestajRepository.findById(accommodationUnit.getSmestajID()).orElse(null);
		//proveri da li je validan user poslao zahtev
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		if(!s.getAgent().getUsername().equals(username)){
			s=null;
		}
		if(s!=null){
			SJedinica sj=new SJedinica(accommodationUnit);
			sJedinicaRepository.save(sj);
			sj.setSmestaj(s);
			s.getSJedinica().add(sj);
			smestajRepository.save(s);


			SJedinicaXMLDTO ret=accommodationUnit;
			ret.setId(sj.getId());
			return ret;
		}
		String faultString = "Unprocessable Entity";
		String faultCodeValue = "422";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}


	@Override
	public boolean editAccommodationUnit(SJedinicaXMLDTO accommodationUnit) throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		System.out.println(message.toString());
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		SJedinica sj=sJedinicaRepository.findById(accommodationUnit.getId()).orElse(null);
		if(username.equals(sj.getSmestaj().getAgent().getUsername())){
		    SJedinica check=sJedinicaRepository.findIfEditable(new Date(),accommodationUnit.getId());
		    if(check==null) {
                sj.setBroj(accommodationUnit.getBroj());
                sj.setBrojKreveta(accommodationUnit.getBrojKreveta());
                sj.setCena(accommodationUnit.getCena());
                sj.setDostupnost(accommodationUnit.getDostupnost());
                sJedinicaRepository.save(sj);

                return true;
            }
		}
		String faultString = "Unprocessable Entity";
		String faultCodeValue = "422";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}

	@Override
	public List<UslugaXMLDTO> syncUsluge() throws SOAPFaultException, SOAPException {
		List<Usluga> usluge=uslugaRepository.findAll();
		List<UslugaXMLDTO> ret=new ArrayList<UslugaXMLDTO>();
		for(Usluga u : usluge){
			ArrayList<Long> kategorije=new ArrayList<>();
			for(Category c : u.getCategoryList()){
				kategorije.add(c.getId());
			}
			UslugaXMLDTO uDTO=new UslugaXMLDTO();
			uDTO.setCena(u.getCena());
			uDTO.setId(u.getId());
			uDTO.setNaziv(u.getNaziv());
			uDTO.setOpis(u.getOpis());
			uDTO.setCategories(kategorije);
			ret.add(uDTO);
		}
		return ret;
	}

	@Override
	public List<CategoryXMLDTO> syncCategories() throws SOAPFaultException, SOAPException {
		List<Category> categories=categoryRepository.findAll();
		List<CategoryXMLDTO> ret=new ArrayList<CategoryXMLDTO>();
		for(Category c : categories){
			ArrayList<Long> usluge=new ArrayList<>();
			for(Usluga u : c.getUslugaList()){
				usluge.add(u.getId());
			}
			CategoryXMLDTO cDTO=new CategoryXMLDTO();
			cDTO.setId(c.getId());
			cDTO.setNaziv(c.getNaziv());
			cDTO.setVrednost(c.getVrednost());
			cDTO.setUsluge(usluge);
			ret.add(cDTO);
		}
		return ret;
	}

	@Override
	public List<PorukaXMLDTO> pollingPoruke() throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		ArrayList<PorukaXMLDTO> ret=new ArrayList<>();
		for(Poruka p : porukaRepository.findPorukeByUsername(username)){
			ret.add(new PorukaXMLDTO(p));
		}
		return ret;
	}

	@Override
	public boolean sendPoruka(PorukaXMLDTO poruka) throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		User primalac = userRepository.findByUsername(poruka.getPrimalac());
		User posiljalac = userRepository.findByUsername(username);
		if(primalac!=null){
			Poruka p=new Poruka();
			p.setSadrzaj(poruka.getSadrzaj());
			porukaRepository.save(p);
			p.setPosiljalac(posiljalac);
			p.setPrimalac(primalac);
			porukaRepository.save(p);
			return true;
		}
		String faultString = "Bad request";
		String faultCodeValue = "400";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}

	@Override
	public RezervacijaMakeXMLDTO makeReservation(RezervacijaMakeXMLDTO reservation) throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		User u = userRepository.findByUsername(username);

		//send request for reservation to reservation-service
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.setBearerAuth(request.get);
		/*Enumeration<String> str = request.getHeaderNames();
		while(str.hasMoreElements()){
			System.out.println(str.nextElement());
		}*/
		SJedinica sjed=sJedinicaRepository.findById(reservation.getSjedinicaId()).orElse(null);
		headers.setBearerAuth(reservation.getToken());
		System.out.println(headers.get("Authorization"));
		ObjectMapper om = new ObjectMapper();
		String json = "";
		MakeResDTO makeRes=new MakeResDTO();
		makeRes.setCost(reservation.getCost());
		makeRes.setFrom(reservation.getFrom());
		makeRes.setKorisnikId(u.getId());
		makeRes.setSjedinicaId(reservation.getSjedinicaId());
		makeRes.setTo(reservation.getTo());
		makeRes.setVersion(sjed.getVersion());
		//List<UslugaDTO> uslugeDTO=ObjectMapperUtils.mapAll(reservation.getServices(), UslugaDTO.class);
		List<UslugaDTO> uslugeDTO=new ArrayList<>();
		makeRes.setServices(uslugeDTO);
		try {
			json = om.writeValueAsString(makeRes);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		HttpEntity<String> entity = new HttpEntity<String>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8762/reservation-service/api/reservations", HttpMethod.POST, entity, String.class);

		if(response.getStatusCode()!=HttpStatus.valueOf(426)){
			reservation.setId(Long.parseLong(response.getBody()));
			return reservation;
		}


		String faultString = "Bad request";
		String faultCodeValue = "400";
		QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
		SOAPFault soapFault = null;
		try {
			soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
			throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
		} catch (SOAPException e1) {
			throw e1;
		}
	}

	@Override
	public List<RezervacijaXMLDTO> syncReservations() throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username");
		List<RezervacijaXMLDTO> ret=new ArrayList<>();
		for(Rezervacija r : rezervacijaRepository.getAllByUsername(username,new Date())){
			RezervacijaXMLDTO rXML=new RezervacijaXMLDTO(r);
			ret.add(rXML);
		}
		return ret;
	}

    @Override
    public boolean addImages(ImageXMLDTO images) throws SOAPFaultException, SOAPException {
        try{
            for(byte[] bytes : images.getSlike()){
                uploadImages(images.getSmestajID(),bytes);
            }
            return true;
        }catch (Exception e){
        	e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changePassword(UserCredentialsXMLDTO credentials) throws SOAPFaultException, SOAPException {
        User u=userRepository.findByUsername(credentials.getUsername());
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        u.setPassword(passwordEncoder.encode(credentials.getPassword()));
        userRepository.save(u);
	    return true;
    }

	@Override
	public List<AccomodationTypeXMLDTO> syncAccommodationType() throws SOAPFaultException, SOAPException {
		ArrayList<AccomodationTypeXMLDTO> ret=new ArrayList<>();
		for(AccomodationType at : accomodationTypeRepository.findAll()){
			AccomodationTypeXMLDTO atXML=new AccomodationTypeXMLDTO();
			atXML.setId(at.getId());
			atXML.setNaziv(at.getNaziv());
			ret.add(atXML);
		}
		return ret;
	}

	@Override
	public boolean confirmArrival(ConfirmArrivalXMLDTO confirm) throws SOAPFaultException, SOAPException {
		Rezervacija r = rezervacijaRepository.findById(confirm.getId()).orElse(null);
		r.setCanBeRated(true);
		rezervacijaRepository.save(r);
		return true;
	}

	public boolean uploadImages(Long idSmestaj, byte[] slika) throws IOException {
        Smestaj smestaj = smestajRepository.findById(idSmestaj).orElse(null);

        Image image = new Image();
        image.setSmestaj(smestaj);
        image.setData(slika);
        imageRepository.save(image);
        return true;
    }


	public void setCategoryForAccomodation(Smestaj smestaj) {
		List<Category> categories = categoryRepository.findAll();
		List<Category> foundCategories = new ArrayList<>();
		for(Category category: categories)
		{
			Set<Usluga> categoryServices = category.getUslugaList();
			Set<Usluga> accomodationServices = smestaj.getUsluge();
			if(accomodationServices.size() >= categoryServices.size())
			{
				boolean isOk = true;
				for(Usluga categoryService : categoryServices)
				{

					boolean foundService = false;
					for(Usluga accomodationService : accomodationServices)
					{
						if(accomodationService.getId() == categoryService.getId()) {
							foundService = true;
							break;
						}
					}
					if(!foundService) {
						isOk = false;
						break;
					}
				}
				if(isOk)
					foundCategories.add(category);
			}
		}
		if(foundCategories.size() > 0){
			smestaj.setCategory(foundCategories.get(0));
			for(Category category : foundCategories){
				if(category.getVrednost() > smestaj.getCategory().getVrednost())
					smestaj.setCategory(category);
			}
		}

	}

}
