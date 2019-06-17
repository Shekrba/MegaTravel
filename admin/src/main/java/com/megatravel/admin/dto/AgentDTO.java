package com.megatravel.admin.dto;

public class AgentDTO {

    private Long id;

    private String posMatBroj;

    private String ime;

    private String prezime;

    private String adresa;

    public AgentDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosMatBroj() {
        return posMatBroj;
    }

    public void setPosMatBroj(String posMatBroj) {
        this.posMatBroj = posMatBroj;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

}
