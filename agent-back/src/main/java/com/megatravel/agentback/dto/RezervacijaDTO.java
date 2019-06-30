package com.megatravel.agentback.dto;

import com.megatravel.agentback.model.StatusRezervacije;

import java.util.Date;

public class RezervacijaDTO {

    private Long id;
    private Date datumRez;
    private Date od;
    private Date _do;
    private int uCena;
    private StatusRezervacije statusRezervacije;
    private String korisnik;
    private Long idGlBaza;

    public void setIdGlBaza(Long idGlBaza) {
        this.idGlBaza = idGlBaza;
    }

    public Long getIdGlBaza() {
        return idGlBaza;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatumRez(Date datumRez) {
        this.datumRez = datumRez;
    }

    public void setOd(Date od) {
        this.od = od;
    }

    public void set_do(Date _do) {
        this._do = _do;
    }

    public void setuCena(int uCena) {
        this.uCena = uCena;
    }

    public void setStatusRezervacije(StatusRezervacije statusRezervacije) {
        this.statusRezervacije = statusRezervacije;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public Long getId() {
        return id;
    }

    public Date getDatumRez() {
        return datumRez;
    }

    public Date getOd() {
        return od;
    }

    public Date get_do() {
        return _do;
    }

    public int getuCena() {
        return uCena;
    }

    public StatusRezervacije getStatusRezervacije() {
        return statusRezervacije;
    }

    public String getKorisnik() {
        return korisnik;
    }
}