package com.megatravel.admin.dto;



import java.util.ArrayList;
import java.util.List;

public class SmestajDTO {

    private String naziv;

    private Long tipSmestaja;


    private String opis;

    private int periodOtkaza;

    private Long id;

    private List<Long> additionalServices = new ArrayList<>();

    public SmestajDTO(){}


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getTipSmestaja() {
        return tipSmestaja;
    }

    public void setTipSmestaja(Long tipSmestaja) {
        this.tipSmestaja = tipSmestaja;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<Long> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
