package com.megatravel.login.controller;

import com.megatravel.login.model.TKorisnik;
import com.megatravel.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api", produces="application/json;charset=UTF-8")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test(){
        return "OK";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public TKorisnik registracija(@RequestBody TKorisnik korisnik){
        return loginService.registracija(korisnik);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public TKorisnik login(@RequestBody TKorisnik korisnik){
        return loginService.login(korisnik);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public TKorisnik logout(@RequestBody TKorisnik korisnik){
        return loginService.logout(korisnik);
    }
}
