//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:19:59 PM CEST 
//


package com.megatravel.agent.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;



@Entity
public class Komentar {


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private User korisnik;


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Smestaj smestaj;

    @Column(name = "odobren")
    private boolean odobren;


    @Column(name = "tekst", nullable = false)
    private String tekst;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    public boolean isOdobren() {
        return odobren;
    }


    public void setOdobren(boolean value) {
        this.odobren = value;
    }


    public String getTekst() {
        return tekst;
    }


    public void setTekst(String value) {
        this.tekst = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }


    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }
}