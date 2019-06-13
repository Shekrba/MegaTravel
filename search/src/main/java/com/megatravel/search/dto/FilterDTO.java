package com.megatravel.search.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilterDTO {
    private String mesto;
    private int brojKreveta;
    private Date dateFrom;
    private Date dateTo;
    private String tip;
    private String kategorija;
    private List<String> usluge = new ArrayList<>();

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public List<String> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<String> usluge) {
        this.usluge = usluge;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
