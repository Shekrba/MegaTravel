package com.megatravel.login.controller;

import com.megatravel.login.dto.UserDTO;
import com.megatravel.login.model.User;
import com.megatravel.login.security.TokenUtils;
import com.megatravel.login.security.auth.JwtAuthenticationRequest;

import com.megatravel.login.service.LoginServiceImpl;
import com.megatravel.login.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

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



		User user=loginService.checkCredentials(authenticationRequest);
		if(user!=null){
			String jwt = tokenUtils.generateToken(authenticationRequest.getUsername());
			int expiresIn = tokenUtils.getExpiredIn();
			UserDTO userDTO= ObjectMapperUtils.map(user,UserDTO.class);
			userDTO.setExpiresIn(expiresIn);
			userDTO.setToken(jwt);
			// Vrati user-a sa tokenom kao odgovor na uspesno autentifikaciju
			return ResponseEntity.ok(userDTO);
		}else{
			return new ResponseEntity<>("Incorrect username or password", HttpStatus.UNAUTHORIZED);
		}

	}


}