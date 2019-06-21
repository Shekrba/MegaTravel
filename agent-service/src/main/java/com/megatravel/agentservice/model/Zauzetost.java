package com.megatravel.agentservice.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Zauzetost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "datumOd", unique = false, nullable = false)
    protected LocalDate datumOd;

    @Column(name = "datumDo", unique = false, nullable = false)
    protected LocalDate datumDo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected SJedinica sJedinica;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatumOd(LocalDate datumOd) {
        this.datumOd = datumOd;
    }

    public void setDatumDo(LocalDate datumDo) {
        this.datumDo = datumDo;
    }

    public void setsJedinica(SJedinica sJedinica) {
        this.sJedinica = sJedinica;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatumOd() {
        return datumOd;
    }

    public LocalDate getDatumDo() {
        return datumDo;
    }

    public SJedinica getsJedinica() {
        return sJedinica;
    }

    public Zauzetost(LocalDate datumOd, LocalDate datumDo, SJedinica sJedinica) {
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.sJedinica = sJedinica;
    }

    public Zauzetost() {
    }
}