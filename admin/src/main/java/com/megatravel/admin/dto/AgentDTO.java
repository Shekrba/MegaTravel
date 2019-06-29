package com.megatravel.admin.dto;

public class AgentDTO {

    private Long id;

    private String posMatBroj;

    private String ime;

    private String prezime;

    private String adresa;

    private String email;

    private String username;

    private String password;

    public AgentDTO() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
