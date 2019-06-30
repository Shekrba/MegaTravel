package com.megatravel.agentback.dto;

import com.megatravel.agentback.model.StatusPoruke;

import java.util.Date;

public class PorukaDTO {

    private Long id;
    private String posaljilac;
    private String primalac;
    private String naslov;
    private String sadrzaj;
    private Date datumSlanja;
    private StatusPoruke statusPoruke;
    private Long idOdgovora;
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

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public void setPosaljilac(String posaljilac) {
        this.posaljilac = posaljilac;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public void setDatumSlanja(Date datumSlanja) {
        this.datumSlanja = datumSlanja;
    }

    public void setStatusPoruke(StatusPoruke statusPoruke) {
        this.statusPoruke = statusPoruke;
    }

    public void setIdOdgovora(Long idOdgovora) {
        this.idOdgovora = idOdgovora;
    }

    public Long getId() {
        return id;
    }

    public String getPosaljilac() {
        return posaljilac;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public Date getDatumSlanja() {
        return datumSlanja;
    }

    public StatusPoruke getStatusPoruke() {
        return statusPoruke;
    }

    public Long getIdOdgovora() {
        return idOdgovora;
    }

    public PorukaDTO() {
    }
}
