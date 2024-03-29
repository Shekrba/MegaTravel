//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.rezervacija.model;

import javax.persistence.*;


@Entity
public class Adresa {

    @Column(name = "latitude", unique = false, nullable = false)
    protected double latitude;

    @Column(name = "longitude", unique = false, nullable = false)
    protected double longitude;

    @Column(name = "mesto", unique = false, nullable = false)
    protected String mesto;

    @Column(name = "posBroj", unique = false, nullable = false)
    protected String posBroj;

    @Column(name = "ulica", unique = false, nullable = false)
    protected String ulica;

    @Column(name = "broj", unique = false, nullable = false)
    protected int broj;

    @Column(name = "brojStana", unique = false, nullable = true)
    protected Integer brojStana;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @OneToOne(mappedBy="adresa",fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
    protected Smestaj smestaj;

   public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double value) {
        this.latitude = value;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double value) {
        this.longitude = value;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String value) {
        this.mesto = value;
    }

    public String getPosBroj() {
        return posBroj;
    }

    public void setPosBroj(String value) {
        this.posBroj = value;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String value) {
        this.ulica = value;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int value) {
        this.broj = value;
    }

    public Integer getBrojStana() {
        return brojStana;
    }

    public void setBrojStana(Integer value) {
        this.brojStana = value;
    }

}
