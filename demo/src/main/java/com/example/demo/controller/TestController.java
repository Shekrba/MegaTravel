package com.example.demo.controller;

import com.example.demo.soap.CountryClient;
import com.example.demo.soapxml.LoginResponse;
import com.example.demo.soapxml.ServiceException_Exception;
import com.example.demo.soapxml.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    CountryClient cc;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity createAuthenticationToken() {
        UserCredentials uc=new UserCredentials();
        uc.setPassword("123");
        uc.setUsername("user");
        LoginResponse lr=null;
        try{
            lr=cc.getCountry(uc);
        }catch (ServiceException_Exception e){
            return new ResponseEntity(e.getFaultInfo().getFaultDetails().get(0).getFaultCode(),HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(lr);
    }
}
