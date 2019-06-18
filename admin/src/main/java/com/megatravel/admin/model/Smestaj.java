//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package com.megatravel.admin.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}SJedinica" maxOccurs="unbounded"/>
 *         &lt;element name="TipSmestaja" type="{https://github.com/Shekrba/MegaTravel/Smestaj}TTipSmestaja"/>
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}Adresa"/>
 *         &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DodatneUsluge">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}Usluga" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PeriodOtkaza">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Slika" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="src" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
        "sJedinica",
        "adresa",
        "opis",
        "periodOtkaza"
})
@XmlRootElement(name = "Smestaj")
@Entity
public class Smestaj {

    @Column(name = "naziv", unique = false, nullable = false)
    protected String naziv;

    @XmlElement(name = "SJedinica", required = true)
    @OneToMany(mappedBy = "smestaj")
    protected List<SJedinica> sJedinica;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private AccomodationType accomodationType;

    @XmlElement(name = "Adresa", required = true)
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, optional=true)
    protected Adresa adresa;

    @XmlElement(name = "Opis", required = true)
    @Column(name = "opis", unique = false, nullable = true)
    protected String opis;

    @XmlElement(name = "DodatneUsluge", required = true)
    @ManyToMany
    @JoinTable(
            name = "services_smestaj",
            joinColumns = @JoinColumn(name = "smestaj_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    @JsonIgnore
    private List<Usluga> uslugaList = new ArrayList<>();

    @XmlElement(name = "PeriodOtkaza")
    @Column(name = "periodOtkaza", unique = false, nullable = false)
    protected int periodOtkaza;

    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;


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



    /**
     * Gets the value of the sJedinica property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sJedinica property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSJedinica().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SJedinica }
     *
     *
     */
    public List<SJedinica> getSJedinica() {
        if (sJedinica == null) {
            sJedinica = new ArrayList<SJedinica>();
        }
        return this.sJedinica;
    }


    /**
     * Gets the value of the adresa property.
     *
     * @return
     *     possible object is
     *     {@link Adresa }
     *
     */
    public Adresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     *
     * @param value
     *     allowed object is
     *     {@link Adresa }
     *
     */
    public void setAdresa(Adresa value) {
        this.adresa = value;
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
     * Gets the value of the periodOtkaza property.
     *
     */
    public int getPeriodOtkaza() {
        return periodOtkaza;
    }

    /**
     * Sets the value of the periodOtkaza property.
     *
     */
    public void setPeriodOtkaza(int value) {
        this.periodOtkaza = value;
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
     *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}Usluga" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="src" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */



}
