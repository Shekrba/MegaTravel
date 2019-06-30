package com.megatravel.agentback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Zauzetost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "datumOd", unique = false, nullable = false)
    protected Date datumOd;

    @Column(name = "datumDo", unique = false, nullable = false)
    protected Date datumDo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected SJedinica sJedinica;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    @JsonIgnore
    public void setsJedinica(SJedinica sJedinica) {
        this.sJedinica = sJedinica;
    }

    public Long getId() {
        return id;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public SJedinica getsJedinica() {
        return sJedinica;
    }

    public Zauzetost(Date datumOd, Date datumDo, SJedinica sJedinica) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.sJedinica = sJedinica;
    }

    public Zauzetost() {
    }
}