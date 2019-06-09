package com.megatravel.service;





import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(serviceName = "AgentService")
public interface AgentService {
	@WebMethod()
	@WebResult(name = "Greeting")
	public String sayHowAreYou(@WebParam(name = "GreetingsRequest") String name);
}
