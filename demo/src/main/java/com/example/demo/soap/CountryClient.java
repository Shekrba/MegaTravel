
package com.example.demo.soap;


import com.example.demo.soapxml.Login;
import com.example.demo.soapxml.LoginResponse;
import com.example.demo.soapxml.ObjectFactory;
import com.example.demo.soapxml.UserCredentials;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;


public class CountryClient extends WebServiceGatewaySupport {


	public LoginResponse getCountry(UserCredentials name) {


		Login request = new Login();
		request.setLoginRequest(name);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<Login> jerequest=objectFactory.createLogin(request);


		JAXBElement<LoginResponse> response = (JAXBElement<LoginResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8081/api", jerequest,
						new SoapActionCallback(
								"sayHowAreYou"));

		return response.getValue();
	}

}
