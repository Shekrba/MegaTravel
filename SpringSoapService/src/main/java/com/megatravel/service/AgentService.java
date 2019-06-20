package com.megatravel.service;





import com.megatravel.model.UserCredentials;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "AgentService")
public interface AgentService {
	@WebMethod(action = "sayHowAreYou")
	@WebResult(name = "Token")
	public String login(@WebParam(name = "LoginRequest") UserCredentials credentials);
}
