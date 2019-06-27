package com.megatravel.agent.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megatravel.agent.model.*;
import com.megatravel.agent.repository.*;
import com.megatravel.agent.utils.ObjectMapperUtils;
import com.megatravel.agent.xml.dto.SJedinicaXMLDTO;
import com.megatravel.agent.xml.dto.SmestajXMLDTO;
import com.megatravel.agent.xml.dto.UserCredentialsXMLDTO;
import com.megatravel.agent.xml.dto.UslugaXMLDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.ArrayList;
import java.util.Arrays;


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

	@Override
	public String firstLogin(UserCredentialsXMLDTO credentials) throws SOAPFaultException,SOAPException {
		User u=userRepository.findByUsername(credentials.getUsername());
		if(u!=null) {
			if (u.getAuthorities().contains(authorityRepository.findByName("ROLE_AGENT"))) {
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.setContentType(MediaType.APPLICATION_JSON);
				ObjectMapper om = new ObjectMapper();
				String json = "";
				try {
					json = om.writeValueAsString(credentials);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
				HttpEntity<String> entity = new HttpEntity<String>(json, headers);

				ResponseEntity<String> response = restTemplate.exchange(
						"http://localhost:8762/login-service/auth/login", HttpMethod.POST, entity, String.class);
				return response.getBody();
			}
		}
		String faultString = "Bad credentials";
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
	public SmestajXMLDTO addAccommodation(SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException {
		User u=userRepository.fetchAccommodations(accommodation.getUsername());
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
		User u=userRepository.fetchAccommodations(accommodation.getUsername());
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
		if(!s.getAgent().getUsername().equals(accommodationUnit.getUsername())){
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
		SJedinica sj=sJedinicaRepository.findById(accommodationUnit.getId()).orElse(null);
		if(accommodationUnit.getUsername().equals(sj.getSmestaj().getAgent().getUsername())){
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
}
