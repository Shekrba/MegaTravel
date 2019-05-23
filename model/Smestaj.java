//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:21:04 PM CEST 
//


package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
    "tipSmestaja",
    "adresa",
    "opis",
    "dodatneUsluge",
    "periodOtkaza",
    "slika"
})
@XmlRootElement(name = "Smestaj")
public class Smestaj {

    @XmlElement(name = "SJedinica", required = true)
    protected List<SJedinica> sJedinica;
    @XmlElement(name = "TipSmestaja", required = true, defaultValue = "hotel")
    @XmlSchemaType(name = "string")
    protected TTipSmestaja tipSmestaja;
    @XmlElement(name = "Adresa", required = true)
    protected Adresa adresa;
    @XmlElement(name = "Opis", required = true)
    protected String opis;
    @XmlElement(name = "DodatneUsluge", required = true)
    protected Smestaj.DodatneUsluge dodatneUsluge;
    @XmlElement(name = "PeriodOtkaza")
    protected int periodOtkaza;
    @XmlElement(name = "Slika", required = true)
    protected List<Smestaj.Slika> slika;
    @XmlAttribute(name = "Id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

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
     * Gets the value of the tipSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link TTipSmestaja }
     *     
     */
    public TTipSmestaja getTipSmestaja() {
        return tipSmestaja;
    }

    /**
     * Sets the value of the tipSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link TTipSmestaja }
     *     
     */
    public void setTipSmestaja(TTipSmestaja value) {
        this.tipSmestaja = value;
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
     * Gets the value of the dodatneUsluge property.
     * 
     * @return
     *     possible object is
     *     {@link Smestaj.DodatneUsluge }
     *     
     */
    public Smestaj.DodatneUsluge getDodatneUsluge() {
        return dodatneUsluge;
    }

    /**
     * Sets the value of the dodatneUsluge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smestaj.DodatneUsluge }
     *     
     */
    public void setDodatneUsluge(Smestaj.DodatneUsluge value) {
        this.dodatneUsluge = value;
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
     * Gets the value of the slika property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slika property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlika().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Smestaj.Slika }
     * 
     * 
     */
    public List<Smestaj.Slika> getSlika() {
        if (slika == null) {
            slika = new ArrayList<Smestaj.Slika>();
        }
        return this.slika;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
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
    public void setId(String value) {
        this.id = value;
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
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "usluga"
    })
    public static class DodatneUsluge {

        @XmlElement(name = "Usluga")
        protected List<Usluga> usluga;

        /**
         * Gets the value of the usluga property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the usluga property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUsluga().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Usluga }
         * 
         * 
         */
        public List<Usluga> getUsluga() {
            if (usluga == null) {
                usluga = new ArrayList<Usluga>();
            }
            return this.usluga;
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
     *       &lt;attribute name="src" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Slika {

        @XmlAttribute(name = "src")
        @XmlSchemaType(name = "anySimpleType")
        protected String src;

        /**
         * Gets the value of the src property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrc() {
            return src;
        }

        /**
         * Sets the value of the src property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrc(String value) {
            this.src = value;
        }

    }

}
