package com.megatravel.login.controller;

import com.megatravel.login.model.UserTokenState;
import com.megatravel.login.security.TokenUtils;
import com.megatravel.login.security.auth.JwtAuthenticationRequest;

import com.megatravel.login.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	LoginServiceImpl loginService;



	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                       HttpServletResponse response) throws AuthenticationException, IOException {



		if(loginService.checkCredentials(authenticationRequest)){
			String jwt = tokenUtils.generateToken(authenticationRequest.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();

			// Vrati token kao odgovor na uspesno autentifikaciju
			return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
		}else{
			return new ResponseEntity<>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
		}

	}


}