//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.admin.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
    "brojKreveta",
    "dostupnost"
})
@XmlRootElement(name = "SJedinica")
@Entity
public class SJedinica {

    @XmlElement(name = "Cena")
    @Column(name = "cena", unique = false, nullable = false)
    protected double cena;

    @XmlElement(name = "BrojKreveta")
    @Column(name = "brojKreveta", unique = false, nullable = false)
    protected int brojKreveta;

    @XmlElement(name = "Dostupnost", defaultValue = "true")
    @Column(name = "dostupnost", unique = false, nullable = false)
    protected Boolean dostupnost;

    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Smestaj smestaj;

    @Column(name = "broj", unique = false, nullable = false)
    protected int broj;

    @OneToMany(
            mappedBy = "sJedinica",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    protected List<Komentar> comments;

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
     * Gets the value of the dostupnost property.
     * 
     */
    public boolean isDostupnost() {
        return dostupnost;
    }

    /**
     * Sets the value of the dostupnost property.
     * 
     */
    public void setDostupnost(boolean value) {
        this.dostupnost = value;
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

}
