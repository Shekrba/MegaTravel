//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.rezervacija.model;

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
 *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Cena">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}double">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
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
        "naziv",
        "opis",
        "cena"
})
@XmlRootElement(name = "Usluga")
@Entity
public class Usluga {

    @XmlElement(name = "Naziv", required = true)
    @Column(name = "naziv", unique = false, nullable = false)
    protected String naziv;

    @XmlElement(name = "Opis", required = true)
    @Column(name = "opis", unique = false, nullable = true)
    protected String opis;

    @XmlElement(name = "Cena")
    @Column(name = "cena", unique = false, nullable = false)
    protected double cena;

    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToMany(mappedBy = "uslugaList")
    @JsonIgnore
    protected List<Smestaj> smestajList = new ArrayList<>();

    @ManyToMany(mappedBy = "uslugaList")
    private
    List<Category> categoryList = new ArrayList<>();


    public List<Smestaj> getSmestaj() {
        return smestajList;
    }

    public void setSmestaj(List<Smestaj> smestaj) {
        this.smestajList = smestaj;
    }

    /**
     * Gets the value of the naziv property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the opis property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOpis(String value) {
        this.opis = value;
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
     *     {@link String }
     *
     */
    public void setId(Long value) {
        this.id = value;
    }


    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
