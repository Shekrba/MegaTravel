
package com.example.demo.soapxml;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for sJedinicaXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sJedinicaXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BrojKreveta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Dostupnost" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="smestajID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sJedinicaXMLDTO", propOrder = {
    "cena",
    "brojKreveta",
    "dostupnost",
    "broj"
})
public class SJedinicaXMLDTO {

    @XmlElement(name = "Cena")
    protected double cena;
    @XmlElement(name = "BrojKreveta")
    protected int brojKreveta;
    @XmlElement(name = "Dostupnost", defaultValue = "true")
    protected Boolean dostupnost;
    protected int broj;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "smestajID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String smestajID;

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
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDostupnost() {
        return dostupnost;
    }

    /**
     * Sets the value of the dostupnost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDostupnost(Boolean value) {
        this.dostupnost = value;
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
     * Gets the value of the smestajID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmestajID() {
        return smestajID;
    }

    /**
     * Sets the value of the smestajID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmestajID(String value) {
        this.smestajID = value;
    }

}
