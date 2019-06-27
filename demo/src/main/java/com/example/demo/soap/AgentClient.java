
package com.example.demo.soap;


import com.example.demo.soapxml.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.CommonsHttpConnection;
import org.springframework.ws.transport.http.HttpComponentsConnection;
import org.springframework.ws.transport.http.HttpUrlConnection;

import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPException;
import java.io.IOException;


public class AgentClient extends WebServiceGatewaySupport{


	private String token="";

	public AddAccommodationResponse addSmestaj(SmestajXMLDTO accommodation) throws SoapFaultClientException{


		AddAccommodation request = new AddAccommodation();
		request.setAccommodation(accommodation);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<AddAccommodation> jerequest=objectFactory.createAddAccommodation(request);
		JAXBElement<AddAccommodationResponse> response=null;

		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

		try {
			response = (JAXBElement<AddAccommodationResponse>) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
							new WebServiceMessageCallback() {
								public void doWithMessage(WebServiceMessage message) {
										TransportContext context = TransportContextHolder.getTransportContext();
										HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

									try {
										connection.addRequestHeader("SOAPAction","addAccommodation");
										connection.addRequestHeader("Authorization","Bearer "+token);
									} catch (IOException e) {
										e.printStackTrace();
									}
									//postMethod.addHeader("Authorization", "Bearer ");
									}
								});
		}catch (SoapFaultClientException e){
			throw e;
		}



		return  response.getValue();
	}

	public FirstLoginResponse login(UserCredentialsXMLDTO credentials) throws SoapFaultClientException {


		FirstLogin request = new FirstLogin();
		request.setLoginRequest(credentials);


		ObjectFactory objectFactory = new ObjectFactory();
		JAXBElement<FirstLogin> jerequest=objectFactory.createFirstLogin(request);
		JAXBElement<FirstLoginResponse> response=null;

		try {
			response = (JAXBElement<FirstLoginResponse>) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8762/agent-service/api/login", jerequest,
							new SoapActionCallback("firstLogin"));
		}catch (SoapFaultClientException e){
			throw e;
		}

		ObjectMapper om = new ObjectMapper();
		JSONObject jsonObject= null;
		try {
			jsonObject = new JSONObject(response.getValue().getSuccess());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		String tokenza= null;
		try {
			tokenza = jsonObject.getString("token");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		this.token=tokenza;
		return  response.getValue();
	}

}
