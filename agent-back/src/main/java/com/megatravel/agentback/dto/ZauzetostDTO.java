package com.megatravel.agentback.dto;


import java.util.Date;

public class ZauzetostDTO {

    private Date odDatum;
    private Date doDatum;
    private String idGlBaza;
    private int cena;

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Long getSjedId() {
        return sjedId;
    }

    public void setSjedId(Long sjedId) {
        this.sjedId = sjedId;
    }

    private Long sjedId;

    public String getIdGlBaza() {
        return idGlBaza;
    }

    public void setIdGlBaza(String idGlBaza) {
        this.idGlBaza = idGlBaza;
    }

    public ZauzetostDTO() {}


    public Date getOdDatum() {
        return odDatum;
    }

    public void setOdDatum(Date odDatum) {
        this.odDatum = odDatum;
    }

    public Date getDoDatum() {
        return doDatum;
    }

    public void setDoDatum(Date doDatum) {
        this.doDatum = doDatum;
    }
}
