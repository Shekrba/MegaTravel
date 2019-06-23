package com.megatravel.agent.service;






import com.megatravel.agent.dto.UserCredentials;

import com.megatravel.agent.exception.ServiceException;
import org.springframework.http.ResponseEntity;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.SOAPFaultException;

@WebService(serviceName = "AgentService")
public interface AgentService {
	@WebMethod(action = "sayHowAreYou")
	public String login(@WebParam(name = "LoginRequest") UserCredentials credentials) throws SOAPFaultException;
}
