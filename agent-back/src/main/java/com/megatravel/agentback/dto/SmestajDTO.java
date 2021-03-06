package com.megatravel.agentback.dto;

import java.util.ArrayList;
import java.util.List;

public class SmestajDTO {
    private Long id;
    private String naziv;
    private Long tip;
    private String opis;
    private int periodOtkaza;
    private String mesto;
    private String ulica;
    private double longitude;
    private double latitude;
    private String posBroj;


    private int broj;
    private List<String> slike = new ArrayList<String>();
    private List<UslugaDTO> usluge = new ArrayList<UslugaDTO>();
    private List<SJedinicaDTO> sjedinice = new ArrayList<SJedinicaDTO>();

    private List<Long> additionalServices = new ArrayList<>();
    private Long idGlBaza;

    public void setIdGlBaza(Long idGlBaza) {
        this.idGlBaza = idGlBaza;
    }

    public Long getIdGlBaza() {
        return idGlBaza;
    }

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

    public Long getTip() {
        return tip;
    }

    public void setTip(Long tip) {
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


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getPosBroj() {
        return posBroj;
    }

    public void setPosBroj(String posBroj) {
        this.posBroj = posBroj;
    }


    public List<Long> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<Long> services) {
        this.additionalServices = services;
    }
}
