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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;


import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;

import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
					Usluga usluga = uslugaRepository.getOne(uXML.getId());
					usluga.getSmestaj().add(s);
					s.getUslugaList().add(usluga);
					uslugaRepository.save(usluga);
				}
			}

			//postavi AccomodationType i sacuvaj ga
			if(accommodation.getAccomodationType()!=null) {
				AccomodationType accomodationType = accomodationRepository.getOne(accommodation.getAccomodationType().getId());
				accomodationType.getSmestajList().add(s);
				s.setAccomodationType(accomodationType);
			}
			/*
				Dodaj izracunavanje kategorije - pitaj Mandica
			 */
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
			Smestaj s=smestajRepository.getOne(accommodation.getId());
			s.getUslugaList().clear();
			//postavi usluge i sacuvaj ga
			if(accommodation.getUslugaList()!=null) {
				for (UslugaXMLDTO uXML : accommodation.getUslugaList()) {
					Usluga usluga = uslugaRepository.getOne(uXML.getId());
					usluga.getSmestaj().add(s);
					s.getUslugaList().add(usluga);
					uslugaRepository.save(usluga);
				}
			}

			//postavi AccomodationType i sacuvaj ga
			if(accommodation.getAccomodationType()!=null) {
				AccomodationType accomodationType = accomodationRepository.getOne(accommodation.getAccomodationType().getId());
				accomodationType.getSmestajList().add(s);
				s.setAccomodationType(accomodationType);
			}
			/*
				Dodaj izracunavanje kategorije - pitaj Mandica
			 */

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
			sj.setBroj(accommodationUnit.getBroj());
			sj.setBrojKreveta(accommodationUnit.getBrojKreveta());
			sj.setCena(accommodationUnit.getCena());
			sj.setDostupnost(accommodationUnit.getDostupnost());
			sJedinicaRepository.save(sj);

			return true;
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
		List<UslugaXMLDTO> ret=ObjectMapperUtils.mapAll(uslugaRepository.findAll(),UslugaXMLDTO.class);
		return ret;
	}

	@Override
	public List<PorukaXMLDTO> pollingPoruke() throws SOAPFaultException, SOAPException {
		Message message=PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request=(HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String username=request.getHeader("Username:");
		List<PorukaXMLDTO> ret=new ArrayList<>();
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
		System.out.println(username);
		User u = userRepository.findByUsername(username);

		//send request for reservation to reservation-service
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper om = new ObjectMapper();
		String json = "";
		MakeResDTO makeRes=new MakeResDTO();
		makeRes.setCost(reservation.getCost());
		makeRes.setFrom(reservation.getFrom());
		makeRes.setKorisnikId(u.getId());
		makeRes.setSjedinicaId(reservation.getSjedinicaId());
		makeRes.setTo(reservation.getTo());
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

		if(true){
			System.out.println(response.getBody());
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


}
