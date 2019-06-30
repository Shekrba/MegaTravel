package com.megatravel.agentback.dto;

public class SJedinicaDTO {
    private Long id;
    private int broj;
    private int brojKreveta;
    private double cena;
    private Boolean dostupnost;
    private String naziv;
    private Long idGlBaza;
    private Long idSmestaj;

    public Long getIdSmestaj() {
        return idSmestaj;
    }

    public void setIdSmestaj(Long idSmestaj) {
        this.idSmestaj = idSmestaj;
    }

    public void setIdGlBaza(Long idGlBaza) {
        this.idGlBaza = idGlBaza;
    }

    public Long getIdGlBaza() {
        return idGlBaza;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int brojKreveta) {
        this.brojKreveta = brojKreveta;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Boolean getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Boolean dostupnost) {
        this.dostupnost = dostupnost;
    }
}
