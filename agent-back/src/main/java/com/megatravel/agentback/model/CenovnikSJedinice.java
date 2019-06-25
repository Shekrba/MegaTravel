package com.megatravel.agentback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CenovnikSJedinice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "cena", unique = false, nullable = false)
    protected double cena;

    @Column(name = "datumOd", unique = false, nullable = false)
    protected LocalDate datumOd;

    @Column(name = "datumDo", unique = false, nullable = false)
    protected LocalDate datumDo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected SJedinica sJedinica;


    @JsonIgnore
    public void setsJedinica(SJedinica sJedinica) {
        this.sJedinica = sJedinica;
    }

    public SJedinica getsJedinica() {
        return sJedinica;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public Long getId() {
        return id;
    }

    public double getCena() {
        return cena;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public CenovnikSJedinice() {
    }

    public CenovnikSJedinice(double cena, LocalDate datumOd, LocalDate datumDo) {
        this.cena = cena;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
    }
}
