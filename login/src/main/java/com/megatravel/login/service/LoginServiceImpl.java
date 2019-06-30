package com.megatravel.login.service;


import com.megatravel.login.dto.UserDTO;
import com.megatravel.login.model.Authority;
import com.megatravel.login.model.User;
import com.megatravel.login.model.UserStatus;
import com.megatravel.login.repository.AuthorityRepository;
import com.megatravel.login.repository.TRegKorisnikRepository;
import com.megatravel.login.security.auth.JwtAuthenticationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServiceImpl implements  LoginService{


    @Autowired
    TRegKorisnikRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public User checkCredentials(JwtAuthenticationRequest request) {
        User user=userRepository.findByUsername(request.getUsername());
        if(user!=null){
            if(passwordEncoder().matches(request.getPassword(),user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public UserDTO register(UserDTO userDTO){
        User user = new User();

        if(userRepository.findByUsername(userDTO.getUsername()) != null){
            userDTO.setId(null);
            return userDTO;
        }

        user.setPrezime(userDTO.getPrezime());
        user.setEnabled(true);
        user.setIme(userDTO.getIme());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder().encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setStatus(UserStatus.ACTIVE);
        Authority authority = authorityRepository.findOneByName("ROLE_USER");
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authority);
        user.setAuthorities(authorities);

        user = userRepository.save(user);
        userDTO.setId(user.getId());

        return userDTO;
    }
}
