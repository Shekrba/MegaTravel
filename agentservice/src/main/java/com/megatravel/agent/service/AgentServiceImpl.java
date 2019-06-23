package com.megatravel.agent.service;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.megatravel.agent.dto.UserCredentials;
import com.megatravel.agent.exception.ServiceException;
import com.megatravel.agent.exception.ServiceExceptionDetails;
import com.megatravel.agent.model.User;
import com.megatravel.agent.repository.AuthorityRepository;
import com.megatravel.agent.repository.UserRepository;
import org.apache.cxf.binding.soap.SoapFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.soap.SoapFaultException;

import javax.sql.rowset.serial.SerialException;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.Arrays;


@Service
public class AgentServiceImpl implements AgentService {



	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityRepository authorityRepository;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String login(UserCredentials credentials) throws SOAPFaultException {
		User u=userRepository.findByUsername(credentials.getUsername());
		if(u.getAuthorities().contains(authorityRepository.findByName("ROLE_AGENT"))) {
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
		}else{
			String faultString = "Bad credentials";
			String faultCodeValue = "401";
			QName faultCode = new QName("http://service.agent.megatravel.com/", faultCodeValue);
			SOAPFault soapFault = null;
			try {
				soapFault = SOAPFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL).createFault(faultString, faultCode);
				throw new javax.xml.ws.soap.SOAPFaultException(soapFault);
			} catch (SOAPException e1) {
				e1.printStackTrace();
			}
		}
		return "";
	}
}
