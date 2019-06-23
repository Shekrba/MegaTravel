
package com.example.demo.soap;


import com.example.demo.soapxml.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPException;


public class CountryClient extends WebServiceGatewaySupport{


	public LoginResponse getCountry(UserCredentials name)throws ServiceException_Exception{


		Login request = new Login();
		request.setLoginRequest(name);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Login> jerequest=objectFactory.createLogin(request);
		JAXBElement<LoginResponse> response=null;
		try {
			response = (JAXBElement<LoginResponse>) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
							new SoapActionCallback(
									"sayHowAreYou"));
		}catch (SoapFaultClientException e){
			System.out.println(e.getFaultCode().getLocalPart());
		}
		return  response.getValue();
	}

}
