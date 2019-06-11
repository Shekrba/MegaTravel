package com.megatravel.search.dto;

import com.megatravel.search.model.TTipSmestaja;
import com.megatravel.search.model.Usluga;

import java.util.ArrayList;
import java.util.List;

public class SmestajDTO {
    private Long id;
    private String naziv;
    private TTipSmestaja tip;
    private String opis;
    private int periodOtkaza;
    private String mesto;
    private String ulica;
    private int broj;
    private List<String> slike = new ArrayList<String>();
    private List<UslugaDTO> usluge = new ArrayList<UslugaDTO>();
    private List<SJedinicaDTO> sjedinice = new ArrayList<SJedinicaDTO>();

    public List<SJedinicaDTO> getSjedinice() {
        return sjedinice;
    }

    public void setSjedinice(List<SJedinicaDTO> sjedinice) {
        this.sjedinice = sjedinice;
    }

    public List<UslugaDTO> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<UslugaDTO> usluge) {
        this.usluge = usluge;
    }

    public List<String> getSlike() {
        return slike;
    }

    public void setSlike(List<String> slike) {
        this.slike = slike;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public TTipSmestaja getTip() {
        return tip;
    }

    public void setTip(TTipSmestaja tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPeriodOtkaza() {
        return periodOtkaza;
    }

    public void setPeriodOtkaza(int periodOtkaza) {
        this.periodOtkaza = periodOtkaza;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }
}
