package com.megatravel.agentservice.model;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.23 at 02:21:04 PM CEST
//

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Mesto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PosBroj">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{5,5}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Ulica" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Broj">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BrojStana" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="10000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
        "latitude",
        "longitude",
        "mesto",
        "posBroj",
        "ulica",
        "broj",
        "brojStana"
})
@XmlRootElement(name = "Adresa")
@Entity
public class Adresa {

    @XmlElement(name = "Latitude")
    @Column(name = "latitude", unique = false, nullable = false)
    protected double latitude;

    @XmlElement(name = "Longitude")
    @Column(name = "longitude", unique = false, nullable = false)
    protected double longitude;

    @XmlElement(name = "Mesto", required = true)
    @Column(name = "mesto", unique = false, nullable = false)
    protected String mesto;

    @XmlElement(name = "PosBroj", required = true)
    @Column(name = "posBroj", unique = false, nullable = false)
    protected String posBroj;

    @XmlElement(name = "Ulica", required = true)
    @Column(name = "ulica", unique = false, nullable = false)
    protected String ulica;

    @XmlElement(name = "Broj")
    @Column(name = "broj", unique = false, nullable = false)
    protected int broj;

    @XmlElement(name = "BrojStana")
    @Column(name = "brojStana", unique = false, nullable = true)
    protected Integer brojStana;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy="adresa",fetch=FetchType.EAGER, cascade=CascadeType.ALL, optional=true)
    private Smestaj smestaj;

    public Adresa(String mesto, String ulica, int broj) {
        this.mesto = mesto;
        this.ulica = ulica;
        this.broj = broj;
    }

    public Adresa() {
    }

    /**
     * Gets the value of the latitude property.
     *
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     */
    public void setLatitude(double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the longitude property.
     *
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     */
    public void setLongitude(double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the mesto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMesto() {
        return mesto;
    }

    /**
     * Sets the value of the mesto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMesto(String value) {
        this.mesto = value;
    }

    /**
     * Gets the value of the posBroj property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPosBroj() {
        return posBroj;
    }

    /**
     * Sets the value of the posBroj property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPosBroj(String value) {
        this.posBroj = value;
    }

    /**
     * Gets the value of the ulica property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUlica() {
        return ulica;
    }

    /**
     * Sets the value of the ulica property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUlica(String value) {
        this.ulica = value;
    }

    /**
     * Gets the value of the broj property.
     *
     */
    public int getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     *
     */
    public void setBroj(int value) {
        this.broj = value;
    }

    /**
     * Gets the value of the brojStana property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getBrojStana() {
        return brojStana;
    }

    /**
     * Sets the value of the brojStana property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setBrojStana(Integer value) {
        this.brojStana = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }
}