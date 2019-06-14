package com.megatravel.login.service;

import com.megatravel.login.security.auth.JwtAuthenticationRequest;
import org.springframework.stereotype.Service;


public interface LoginService {

    public boolean checkCredentials(JwtAuthenticationRequest request);

}
