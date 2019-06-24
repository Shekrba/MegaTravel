
package com.example.demo.soap;


import com.example.demo.soapxml.*;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPException;


public class AgentClient extends WebServiceGatewaySupport{


	public AddAccommodationResponse addSmestaj(SmestajXMLDTO accommodation) throws SoapFaultClientException{


		AddAccommodation request = new AddAccommodation();
		request.setAccommodationRequest(accommodation);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<AddAccommodation> jerequest=objectFactory.createAddAccommodation(request);
		JAXBElement<AddAccommodationResponse> response=null;
		try {
			response = (JAXBElement<AddAccommodationResponse>) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8762/agent-service/api/api", jerequest,
							new SoapActionCallback(
									"addAccommodation"));
		}catch (SoapFaultClientException e){
			throw e;
		}
		return  response.getValue();
	}

}
