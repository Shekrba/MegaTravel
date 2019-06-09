package com.megatravel.login.service;

import com.megatravel.login.model.TKorisnik;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements  LoginService{

    @Override
    public TKorisnik registracija(TKorisnik korisnik){
        return korisnik;
    }

    @Override
    public TKorisnik login(TKorisnik korisnik){
        return korisnik;
    }

    @Override
    public TKorisnik logout(TKorisnik korisnik){
        return korisnik;
    }
}
