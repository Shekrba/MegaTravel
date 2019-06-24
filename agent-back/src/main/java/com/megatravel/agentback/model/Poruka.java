package com.megatravel.agentback.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Poruka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "naslov", unique = false, nullable = false)
    protected String naslov;

    @Column(name = "primalac", unique = false, nullable = false)
    protected String primalac;

    @Column(name = "datumSlanja", unique = false, nullable = false)
    protected LocalDate datumSlanja;

    @Column(name = "posaljilac", unique = false, nullable = false)
    protected String posaljilac;

    @Column(name = "sadrzaj", unique = false, nullable = false)
    protected String sadrzaj;

    @Column(name = "status", unique = false, nullable = false)
    @Enumerated(EnumType.STRING)
    protected StatusPoruke statusPoruke;

    @Column(name = "idOdgovor", unique = true, nullable = true)
    protected Long idOdgovor;

    public Poruka() {
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getPrimalac() {
        return primalac;
    }

    public Poruka(LocalDate datumSlanja, String posaljilac, String sadrzaj, StatusPoruke statusPoruke, Long idOdgovor) {
        this.datumSlanja = datumSlanja;
        this.posaljilac = posaljilac;
        this.sadrzaj = sadrzaj;
        this.statusPoruke = statusPoruke;
        this.idOdgovor = idOdgovor;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatumSlanja(LocalDate datumSlanja) {
        this.datumSlanja = datumSlanja;
    }

    public void setPosaljilac(String posaljilac) {
        this.posaljilac = posaljilac;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public void setStatusPoruke(StatusPoruke statusPoruke) {
        this.statusPoruke = statusPoruke;
    }

    public void setIdOdgovor(Long idOdgovor) {
        this.idOdgovor = idOdgovor;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatumSlanja() {
        return datumSlanja;
    }

    public String getPosaljilac() {
        return posaljilac;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public StatusPoruke getStatusPoruke() {
        return statusPoruke;
    }

    public Long getIdOdgovor() {
        return idOdgovor;
    }
}
