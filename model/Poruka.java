//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:20:45 PM CEST 
//


package model;

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
 *         &lt;element name="From">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{https://github.com/Shekrba/MegaTravel/Korisnik}Korisnik"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="To">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{https://github.com/Shekrba/MegaTravel/Korisnik}Korisnik"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "from",
    "to",
    "tekst"
})
@XmlRootElement(name = "Poruka", namespace = "https://github.com/Shekrba/MegaTravel/Poruka")
public class Poruka {

    @XmlElement(name = "From", namespace = "https://github.com/Shekrba/MegaTravel/Poruka", required = true)
    protected Poruka.From from;
    @XmlElement(name = "To", namespace = "https://github.com/Shekrba/MegaTravel/Poruka", required = true)
    protected Poruka.To to;
    @XmlElement(name = "Tekst", namespace = "https://github.com/Shekrba/MegaTravel/Poruka", required = true)
    protected String tekst;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link Poruka.From }
     *     
     */
    public Poruka.From getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poruka.From }
     *     
     */
    public void setFrom(Poruka.From value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link Poruka.To }
     *     
     */
    public Poruka.To getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link Poruka.To }
     *     
     */
    public void setTo(Poruka.To value) {
        this.to = value;
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
        "korisnik"
    })
    public static class From {

        @XmlElement(name = "Korisnik", required = true)
        protected TKorisnik korisnik;

        /**
         * Gets the value of the korisnik property.
         * 
         * @return
         *     possible object is
         *     {@link TKorisnik }
         *     
         */
        public TKorisnik getKorisnik() {
            return korisnik;
        }

        /**
         * Sets the value of the korisnik property.
         * 
         * @param value
         *     allowed object is
         *     {@link TKorisnik }
         *     
         */
        public void setKorisnik(TKorisnik value) {
            this.korisnik = value;
        }

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
     *         &lt;element ref="{https://github.com/Shekrba/MegaTravel/Korisnik}Korisnik"/>
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
        "korisnik"
    })
    public static class To {

        @XmlElement(name = "Korisnik", required = true)
        protected TKorisnik korisnik;

        /**
         * Gets the value of the korisnik property.
         * 
         * @return
         *     possible object is
         *     {@link TKorisnik }
         *     
         */
        public TKorisnik getKorisnik() {
            return korisnik;
        }

        /**
         * Sets the value of the korisnik property.
         * 
         * @param value
         *     allowed object is
         *     {@link TKorisnik }
         *     
         */
        public void setKorisnik(TKorisnik value) {
            this.korisnik = value;
        }

    }

}
