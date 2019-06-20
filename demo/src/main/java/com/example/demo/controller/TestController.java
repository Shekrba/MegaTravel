package com.example.demo.controller;

import com.example.demo.soap.CountryClient;
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
    public ResponseEntity<?> createAuthenticationToken() {
        return new ResponseEntity<>(cc.getCountry("aaa"), HttpStatus.OK);
    }
}
