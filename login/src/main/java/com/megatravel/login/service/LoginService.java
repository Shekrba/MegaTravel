package com.megatravel.login.service;

import com.megatravel.login.model.TKorisnik;

public interface LoginService {
    public TKorisnik registracija(TKorisnik korisnik);
    public TKorisnik login(TKorisnik korisnik);
    public TKorisnik logout(TKorisnik korisnik);

}
