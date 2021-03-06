//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.23 at 02:21:04 PM CEST
//

package com.megatravel.agentback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="Cena">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BrojKreveta">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Dostupnost" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cena",
        "brojKreveta"
})
@XmlRootElement(name = "SJedinica")
@Entity
public class SJedinica {


    //default cena ako nema u cenovniku po datumima neke drugacije
    @XmlElement(name = "Cena")
    @Column(name = "cena", unique = false, nullable = false)
    protected double cena;

    @XmlElement(name = "BrojKreveta")
    @Column(name = "brojKreveta", unique = false, nullable = false)
    protected int brojKreveta;

    @Column(name = "naziv", unique = false, nullable = true)
    protected String naziv;

    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected Long idGlBaza;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Smestaj smestaj;

    @Column(name = "broj", unique = false, nullable = false)
    protected int broj;

    @OneToMany
    protected List<Rezervacija> rezervacije=new ArrayList<>();

    @OneToMany
    protected List<Zauzetost> listaZauzetosti=new ArrayList<>();

    @OneToMany
    protected List<Cenovnik> listaCena=new ArrayList<>();


    public void setIdGlBaza(Long idGlBaza) {
        this.idGlBaza = idGlBaza;
    }

    public Long getIdGlBaza() {
        return idGlBaza;
    }

    @JsonIgnore
    public void setListaCena(List<Cenovnik> listaCena) {
        this.listaCena = listaCena;
    }

    public List<Cenovnik> getListaCena() {
        return listaCena;
    }

    public List<Rezervacija> getRezervacije() {
        return rezervacije;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }


    @JsonIgnore
    public void setRezervacije(List<Rezervacija> rezervacije) {
        this.rezervacije = rezervacije;
    }

    @JsonIgnore
    public void setListaZauzetosti(List<Zauzetost> listaZauzetosti) {
        this.listaZauzetosti = listaZauzetosti;
    }

    public List<Zauzetost> getListaZauzetosti() {
        return listaZauzetosti;
    }

    public int getBroj() {
        return broj;
    }

    public void setBroj(int broj) {
        this.broj = broj;
    }

    public Smestaj getSmestaj() {
        return smestaj;
    }

    @JsonIgnore
    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }

    /**
     * Gets the value of the cena property.
     *
     */


    public double getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     *
     */
    public void setCena(double value) {
        this.cena = value;
    }

    /**
     * Gets the value of the brojKreveta property.
     *
     */
    public int getBrojKreveta() {
        return brojKreveta;
    }

    /**
     * Sets the value of the brojKreveta property.
     *
     */
    public void setBrojKreveta(int value) {
        this.brojKreveta = value;
    }



    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }

}
