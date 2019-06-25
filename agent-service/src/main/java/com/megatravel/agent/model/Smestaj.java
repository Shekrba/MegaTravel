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
import java.util.List;



@Entity
public class Smestaj {

    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;


    @OneToMany(mappedBy = "smestaj")
    private List<SJedinica> sJedinica;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AccomodationType accomodationType;





    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
    private Adresa adresa;


    @Column(name = "opis", unique = false, nullable = true)
    private String opis;


    @ManyToMany
    @JoinTable(
            name = "services_smestaj",
            joinColumns = @JoinColumn(name = "smestaj_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonIgnore
    private List<Usluga> uslugaList = new ArrayList<>();


    @Column(name = "periodOtkaza", unique = false, nullable = false)
    private int periodOtkaza;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @OneToMany(
            mappedBy = "smestaj",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Komentar> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private User agent;

    public Smestaj(){

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

    public List<SJedinica> getsJedinica() {
        return sJedinica;
    }

    public void setsJedinica(List<SJedinica> sJedinica) {
        this.sJedinica = sJedinica;
    }

    public List<Usluga> getUsluge() {
        return getUslugaList();
    }

    @JsonIgnore
    public void setUsluge(List<Usluga> usluge) {
        this.setUslugaList(usluge);
    }




    public List<SJedinica> getSJedinica() {
        if (getsJedinica() == null) {
            setsJedinica(new ArrayList<SJedinica>());
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

    public List<Usluga> getUslugaList() {
        return uslugaList;
    }

    @JsonIgnore
    public void setUslugaList(List<Usluga> uslugaList) {
        this.uslugaList = uslugaList;
    }

    public List<Komentar> getComments() {
        return comments;
    }

    @JsonIgnore
    public void setComments(List<Komentar> comments) {
        this.comments = comments;
    }


    public Smestaj(SmestajXMLDTO sXML){
        this.setsJedinica(new ArrayList<SJedinica>());
        ArrayList<Usluga> ul=new ArrayList<>();
        this.setUslugaList(ul);
        this.setComments(new ArrayList<>());
        this.id=sXML.getId();
        this.naziv=sXML.getNaziv();
        this.opis= sXML.getOpis();
        this.periodOtkaza=sXML.getPeriodOtkaza();
    }

}