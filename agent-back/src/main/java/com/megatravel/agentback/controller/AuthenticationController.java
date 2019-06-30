package com.megatravel.agentback.controller;

import com.megatravel.agentback.client.AgentClient;
import com.megatravel.agentback.dto.UserDTO;
import com.megatravel.agentback.model.User;
import com.megatravel.agentback.model.UserTokenState;
import com.megatravel.agentback.security.TokenUtils;
import com.megatravel.agentback.security.auth.JwtAuthenticationRequest;
import com.megatravel.agentback.service.CustomUserDetailsService;

import com.megatravel.agentback.xml.dto.FirstLoginResponse;
import com.megatravel.agentback.xml.dto.UserCredentialsXMLDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//Kontroler zaduzen za autentifikaciju Usera
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	TokenUtils tokenUtils;

	@Autowired
	AgentClient agentClient;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                       HttpServletResponse response) throws AuthenticationException, IOException {

		UserDTO userDTO=new UserDTO();

		Authentication authentication = null;
		try {
			 authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							authenticationRequest.getUsername(),
							authenticationRequest.getPassword()));
		} catch (AuthenticationException e) {

				UserCredentialsXMLDTO dto = new UserCredentialsXMLDTO();
				dto.setPassword("12345");
				dto.setUsername(authenticationRequest.getUsername());
				try {
					FirstLoginResponse loginResponse = agentClient.login(dto);
				}catch (Exception e2) {
					return new ResponseEntity(HttpStatus.UNAUTHORIZED);
				}

				userDTO.setFirstLogin(true);
		}

		// Ubaci username + password u kontext
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername());
		int expiresIn = tokenUtils.getExpiredIn();

		userDTO.setExpiresIn(expiresIn);
		userDTO.setId(user.getId());
		userDTO.setIme(user.getIme());
		userDTO.setPrezime(user.getPrezime());
		userDTO.setUsername(user.getUsername());
		userDTO.setToken(jwt);


		// Vrati token kao odgovor na uspesno autentifikaciju
		return ResponseEntity.ok(userDTO);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.POST)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request) {

		String token = tokenUtils.getToken(request);
		String username = this.tokenUtils.getUsernameFromToken(token);
	    User user = (User) this.userDetailsService.loadUserByUsername(username);



		if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = tokenUtils.refreshToken(token);
			int expiresIn = tokenUtils.getExpiredIn();

			return ResponseEntity.ok(new UserTokenState(refreshedToken, expiresIn));
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.badRequest().body(userTokenState);
		}
	}

	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) {
		userDetailsService.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		return ResponseEntity.accepted().body(result);
	}

	static class PasswordChanger {
		public String oldPassword;
		public String newPassword;
	}
}