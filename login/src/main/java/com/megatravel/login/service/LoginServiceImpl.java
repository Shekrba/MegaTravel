package com.megatravel.login.service;


import com.megatravel.login.model.TRegKorisnik;
import com.megatravel.login.repository.TRegKorisnikRepository;
import com.megatravel.login.security.auth.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{


    @Autowired
    TRegKorisnikRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public boolean checkCredentials(JwtAuthenticationRequest request) {
        TRegKorisnik user=userRepository.findByUsername(request.getUsername());
        if(user!=null){
            return passwordEncoder().matches(request.getPassword(),user.getPassword());
        }
        return false;
    }
}
