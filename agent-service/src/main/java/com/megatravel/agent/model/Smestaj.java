//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megatravel.agent.xml.dto.SmestajXMLDTO;
import com.megatravel.agent.xml.dto.UslugaXMLDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Smestaj {

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;

    @OneToMany(mappedBy = "smestaj",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<SJedinica> sJedinica=new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    private AccomodationType accomodationType;


    @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
    private Adresa adresa;


    @Column(name = "opis", unique = false, nullable = true)
    private String opis;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "services_smestaj",
            joinColumns = @JoinColumn(name = "smestaj_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonIgnore
    private Set<Usluga> uslugaList = new HashSet<>();


    @Column(name = "periodOtkaza", unique = false, nullable = false)
    private int periodOtkaza;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;


    @ManyToOne(fetch = FetchType.EAGER)
    private User agent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "smestaj")
    private Set<Image> slike = new HashSet<>();

    public Smestaj(){

    }


    public Set<Image> getSlike() {
        return slike;
    }

    public void setSlike(Set<Image> slike) {
        this.slike = slike;
    }

    public User getAgent() {
        return agent;
    }

    public void setAgent(User agent) {
        this.agent = agent;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Set<SJedinica> getsJedinica() {
        return sJedinica;
    }

    public void setsJedinica(Set<SJedinica> sJedinica) {
        this.sJedinica = sJedinica;
    }

    public Set<Usluga> getUsluge() {
        return getUslugaList();
    }

    @JsonIgnore
    public void setUsluge(Set<Usluga> usluge) {
        this.setUslugaList(usluge);
    }




    public Set<SJedinica> getSJedinica() {
        if (getsJedinica() == null) {
            setsJedinica(new HashSet<>());
        }
        return this.getsJedinica();
    }


    public Adresa getAdresa() {
        return adresa;
    }


    public void setAdresa(Adresa value) {
        this.adresa = value;
    }


    public String getOpis() {
        return opis;
    }


    public void setOpis(String value) {
        this.opis = value;
    }


    public int getPeriodOtkaza() {
        return periodOtkaza;
    }


    public void setPeriodOtkaza(int value) {
        this.periodOtkaza = value;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public AccomodationType getAccomodationType() {
        return accomodationType;
    }

    public void setAccomodationType(AccomodationType accomodationType) {
        this.accomodationType = accomodationType;
    }

    public Set<Usluga> getUslugaList() {
        return uslugaList;
    }

    @JsonIgnore
    public void setUslugaList(Set<Usluga> uslugaList) {
        this.uslugaList = uslugaList;
    }




    public Smestaj(SmestajXMLDTO sXML){
        this.setsJedinica(new HashSet<SJedinica>());
        HashSet<Usluga> ul=new HashSet<>();
        this.setUslugaList(ul);
        this.id=sXML.getId();
        this.naziv=sXML.getNaziv();
        this.opis= sXML.getOpis();
        this.periodOtkaza=sXML.getPeriodOtkaza();
    }

}
