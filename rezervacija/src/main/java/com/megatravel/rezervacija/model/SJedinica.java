//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.rezervacija.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SJedinica {

    @Column(name = "cena", unique = false, nullable = false)
    protected double cena;

    @Column(name = "brojKreveta", unique = false, nullable = false)
    protected int brojKreveta;

    @Column(name = "dostupnost", unique = false, nullable = false)
    protected Boolean dostupnost;

    @OneToMany(mappedBy = "sJedinica")
    protected Set<Rezervacija> rezervacije;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Smestaj smestaj;

    @Column(name = "broj", unique = false, nullable = false)
    protected int broj;

    @Version
    private Long version;

    public SJedinica(){

    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Boolean getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Set<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setRezervacije(Set<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double value) {
        this.cena = value;
    }

    public int getBrojKreveta() {
        return brojKreveta;
    }

    public void setBrojKreveta(int value) {
        this.brojKreveta = value;
    }

    public boolean isDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(boolean value) {
        this.dostupnost = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long value) {
        this.id = value;
    }

}
