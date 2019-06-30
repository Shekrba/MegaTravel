package com.megatravel.agentback.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.megatravel.agentback.model.Category;
import com.megatravel.agentback.model.User;
import com.megatravel.agentback.repository.UserRepository;
import com.megatravel.agentback.xml.dto.*;
import generated.GetTestRequest;
import generated.GetTestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;

import javax.xml.bind.JAXBElement;
import java.io.IOException;


public class AgentClient extends  WebServiceGatewaySupport{

    UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(AgentClient.class);
    private String token="token";


    public AddAccommodationResponse addSmestaj(SmestajXMLDTO accommodation) throws SoapFaultClientException {

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

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

    public AddAccommodationUnitResponse addSJedinica(SJedinicaXMLDTO accommodation) throws SoapFaultClientException {

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        AddAccommodationUnit request = new AddAccommodationUnit();
        request.setAccommodationUnit(accommodation);


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<AddAccommodationUnit> jerequest=objectFactory.createAddAccommodationUnit(request);
        JAXBElement<AddAccommodationUnitResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<AddAccommodationUnitResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","addAccommodationUnit");
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

    public EditAccommodationResponse editSmestaj(SmestajXMLDTO accommodation) throws SoapFaultClientException {

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        EditAccommodation request = new EditAccommodation();
        request.setAccommodation(accommodation);


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<EditAccommodation> jerequest=objectFactory.createEditAccommodation(request);
        JAXBElement<EditAccommodationResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<EditAccommodationResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","editAccommodation");
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


    public EditAccommodationUnitResponse editSJedinica(SJedinicaXMLDTO accommodation) throws SoapFaultClientException {

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        EditAccommodationUnit request = new EditAccommodationUnit();
        request.setAccommodationUnit(accommodation);


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<EditAccommodationUnit> jerequest=objectFactory.createEditAccommodationUnit(request);
        JAXBElement<EditAccommodationUnitResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<EditAccommodationUnitResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","editAccommodationUnit");
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


    public MakeReservationResponse napraviRezervaciju(RezervacijaMakeXMLDTO reservation) throws SoapFaultClientException{

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        MakeReservation request = new MakeReservation();
        request.setReservation(reservation);


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<MakeReservation> jerequest=objectFactory.createMakeReservation(request);
        JAXBElement<MakeReservationResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<MakeReservationResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","makeReservation");
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


    public PollingPorukeResponse pokupiPoruke() throws SoapFaultClientException{

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        PollingPoruke request = new PollingPoruke();


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<PollingPoruke> jerequest=objectFactory.createPollingPoruke(request);
        JAXBElement<PollingPorukeResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<PollingPorukeResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","pollingPoruke");
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

    public SendPorukaResponse posaljiPoruku(PorukaXMLDTO poruka) throws SoapFaultClientException{

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        SendPoruka request = new SendPoruka();
        request.setPoruka(poruka);


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<SendPoruka> jerequest=objectFactory.createSendPoruka(request);
        JAXBElement<SendPorukaResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<SendPorukaResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","sendPoruka");
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

    public SyncUslugeResponse dopuniUsluge(UslugaXMLDTO usluga) throws SoapFaultClientException{

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        SyncUsluge request = new SyncUsluge();


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<SyncUsluge> jerequest=objectFactory.createSyncUsluge(request);
        JAXBElement<SyncUslugeResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<SyncUslugeResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","syncUsluge");
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


    public SyncCategoriesResponse dopuniKategorije(CategoryXMLDTO kategodija) throws SoapFaultClientException{

        String s = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userRepository.findByUsername(s);
        token = u.getToken();

        SyncCategories request = new SyncCategories();


        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<SyncCategories> jerequest=objectFactory.createSyncCategories(request);
        JAXBElement<SyncCategoriesResponse> response=null;

        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        try {
            response = (JAXBElement<SyncCategoriesResponse>) getWebServiceTemplate()
                    .marshalSendAndReceive("http://localhost:8762/agent-service/api", jerequest,
                            new WebServiceMessageCallback() {
                                public void doWithMessage(WebServiceMessage message) {
                                    TransportContext context = TransportContextHolder.getTransportContext();
                                    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

                                    try {
                                        connection.addRequestHeader("SOAPAction","syncCategories");
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

        String s = credentials.getUsername();
        User u = userRepository.findByUsername(s);
        u.setToken(response.getValue().getSuccess());
            userRepository.save(u);



        return  response.getValue();
    }

}



