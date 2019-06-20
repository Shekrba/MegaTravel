
package com.example.demo.soap;


import com.example.demo.soapxml.ObjectFactory;
import com.example.demo.soapxml.SayHowAreYou;
import com.example.demo.soapxml.SayHowAreYouResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;


public class CountryClient extends WebServiceGatewaySupport {


	public SayHowAreYouResponse getCountry(String name) {


		SayHowAreYou request = new SayHowAreYou();
		request.setGreetingsRequest(name);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<SayHowAreYou> jerequest=objectFactory.createSayHowAreYou(request);


		JAXBElement<SayHowAreYouResponse> response = (JAXBElement<SayHowAreYouResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8081/services/AgentService", jerequest,
						new SoapActionCallback(
								"sayHowAreYou"));

		return response.getValue();
	}

}
