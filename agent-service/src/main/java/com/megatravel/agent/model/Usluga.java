//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.agent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.megatravel.agent.utils.ObjectMapperUtils;
import com.megatravel.agent.xml.dto.UslugaXMLDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Usluga {


    @Column(name = "naziv", unique = false, nullable = false)
    private String naziv;


    @Column(name = "opis", unique = false, nullable = true)
    private String opis;


    @Column(name = "cena", unique = false, nullable = false)
    private double cena;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "uslugaList",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Smestaj> smestajList = new HashSet<>();



    @ManyToMany(mappedBy = "uslugaList",fetch = FetchType.EAGER)
    private Set<Category> categoryList = new HashSet<>();

    public Usluga(){

    }

    public Set<Smestaj> getSmestajList() {
        return smestajList;
    }

    public void setSmestajList(Set<Smestaj> smestajList) {
        this.smestajList = smestajList;
    }

    public Set<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(Set<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Set<Smestaj> getSmestaj() {
        return smestajList;
    }

    public void setSmestaj(Set<Smestaj> smestaj) {
        this.smestajList = smestaj;
    }


    public String getNaziv() {
        return naziv;
    }


    public void setNaziv(String value) {
        this.naziv = value;
    }


    public String getOpis() {
        return opis;
    }


    public void setOpis(String value) {
        this.opis = value;
    }


    public double getCena() {
        return cena;
    }


    public void setCena(double value) {
        this.cena = value;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long value) {
        this.id = value;
    }


    public Usluga(UslugaXMLDTO uXML){
        this.cena=uXML.getCena();
        this.id=uXML.getId();
        this.naziv=uXML.getNaziv();
        this.smestajList=new HashSet<>();
    }
}
