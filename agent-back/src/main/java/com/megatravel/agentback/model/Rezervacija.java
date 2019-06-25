package com.megatravel.agentback.model;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.23 at 02:20:55 PM CEST
//


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.time.LocalDate;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}SJedinica"/>
 *         &lt;element name="DatumRez" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Od" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Korisnik}Korisnik"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "sJedinica",
        "datumRez",
        "od",

})
@XmlRootElement(name = "Rezervacija", namespace = "https://github.com/Shekrba/MegaTravel")
@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @XmlElement(name = "SJedinica", required = true)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected SJedinica sJedinica;

    @XmlElement(name = "DatumRez", namespace = "https://github.com/Shekrba/MegaTravel", required = true)
    @XmlSchemaType(name = "date")
    @Column(name = "datumRez", unique = false, nullable = false)
    protected LocalDate datumRez;

    @XmlElement(name = "Od", namespace = "https://github.com/Shekrba/MegaTravel", required = true)
    @XmlSchemaType(name = "date")
    @Column(name = "od", unique = false, nullable = false)
    protected LocalDate od;

    @XmlElement(name = "Do", namespace = "https://github.com/Shekrba/MegaTravel", required = true)
    @XmlSchemaType(name = "date")
    @Column(name = "do", unique = false, nullable = false)
    protected LocalDate _do;

    @XmlElement(name = "UCena", namespace = "https://github.com/Shekrba/MegaTravel")
    @Column(name = "ukupnaCena", unique = false, nullable = false)
    protected int uCena;

    //KORISTICEMO SAMO USER OD KORISNIKA TO NAM JE DOVOLJNO NA AGENTU
    @Column(name="korisnik", nullable = false)
    private String korisnik;

    @XmlElement(name = "StatusRezervacije", required = true, defaultValue = "rezervisano")
    @XmlSchemaType(name = "string")
    @Column(name = "status", unique = false, nullable = false)
    @Enumerated(EnumType.STRING)
    protected StatusRezervacije statusRezervacije;

    public void setStatusRezervacije(StatusRezervacije statusRezervacije) {
        this.statusRezervacije = statusRezervacije;
    }

    public StatusRezervacije getStatusRezervacije() {
        return statusRezervacije;
    }

    public void setDatumRez(LocalDate datumRez) {
        this.datumRez = datumRez;
    }

    public void setOd(LocalDate od) {
        this.od = od;
    }



    public LocalDate getDatumRez() {
        return datumRez;
    }

    public LocalDate getOd() {
        return od;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SJedinica getsJedinica() {
        return sJedinica;
    }

    @JsonIgnore
    public void setsJedinica(SJedinica sJedinica) {
        this.sJedinica = sJedinica;
    }

    public LocalDate get_do() {
        return _do;
    }

    public void set_do(LocalDate _do) {
        this._do = _do;
    }

    public int getuCena() {
        return uCena;
    }

    public void setuCena(int uCena) {
        this.uCena = uCena;
    }


    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }
}