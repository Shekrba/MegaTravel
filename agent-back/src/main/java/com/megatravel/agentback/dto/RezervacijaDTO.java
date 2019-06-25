package com.megatravel.agentback.dto;

import com.megatravel.agentback.model.StatusRezervacije;

import java.time.LocalDate;

public class RezervacijaDTO {

    private Long id;
    private LocalDate datumRez;
    private LocalDate od;
    private LocalDate _do;
    private int uCena;
    private StatusRezervacije statusRezervacije;
    private String korisnik;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatumRez(LocalDate datumRez) {
        this.datumRez = datumRez;
    }

    public void setOd(LocalDate od) {
        this.od = od;
    }

    public void set_do(LocalDate _do) {
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

    public LocalDate getDatumRez() {
        return datumRez;
    }

    public LocalDate getOd() {
        return od;
    }

    public LocalDate get_do() {
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