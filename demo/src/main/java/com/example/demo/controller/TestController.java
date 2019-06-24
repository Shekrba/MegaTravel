package com.example.demo.controller;

import com.example.demo.soap.AgentClient;
import com.example.demo.soapxml.AddAccommodationResponse;
import com.example.demo.soapxml.SmestajXMLDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.soap.client.SoapFaultClientException;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    AgentClient agentClient;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity createAuthenticationToken() {
        SmestajXMLDTO sXML=new SmestajXMLDTO();
        sXML.setNaziv("Hotel Fontana");
        sXML.setOpis("Bzvye");
        sXML.setPeriodOtkaza(100);
        sXML.setUsername("agent");
        AddAccommodationResponse ret=null;
        try{
           ret=agentClient.addSmestaj(sXML);
        } catch (SoapFaultClientException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(ret, HttpStatus.OK);
    }
}
