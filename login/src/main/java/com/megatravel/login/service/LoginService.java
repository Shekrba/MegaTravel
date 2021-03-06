package com.megatravel.login.service;

import com.megatravel.login.dto.UserDTO;
import com.megatravel.login.model.User;
import com.megatravel.login.security.auth.JwtAuthenticationRequest;


public interface LoginService {

    public User checkCredentials(JwtAuthenticationRequest request);
    public UserDTO register(UserDTO userDTO);
}
