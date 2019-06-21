//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:19:59 PM CEST 
//


package com.megatravel.rezervacija.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


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
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Korisnik}Korisnik"/>
 *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Smestaj}SJedinica"/>
 *         &lt;element name="Odobren" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Tekst" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "korisnik",
    "odobren",
    "tekst"
})
@XmlRootElement(name = "Komentar", namespace = "https://github.com/Shekrba/MegaTravel/Komentar")
@Entity
public class Komentar {

    @XmlElement(name = "Korisnik", namespace = "https://github.com/Shekrba/MegaTravel/Korisnik", required = true)
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private User korisnik;


    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Smestaj smestaj;

    @XmlElement(name = "Odobren", namespace = "https://github.com/Shekrba/MegaTravel/Komentar", defaultValue = "false")
    @Column(name = "odobren")
    private boolean odobren;

    @XmlElement(name = "Tekst", namespace = "https://github.com/Shekrba/MegaTravel/Komentar", required = true)
    @Column(name = "tekst", nullable = false)
    private String tekst;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * Gets the value of the odobren property.
     * 
     */
    public boolean isOdobren() {
        return odobren;
    }

    /**
     * Sets the value of the odobren property.
     * 
     */
    public void setOdobren(boolean value) {
        this.odobren = value;
    }

    /**
     * Gets the value of the tekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekst() {
        return tekst;
    }

    /**
     * Sets the value of the tekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekst(String value) {
        this.tekst = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(User korisnik) {
        this.korisnik = korisnik;
    }


    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }
}
