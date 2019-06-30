
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for rezervacijaXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacijaXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datumRez" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="_do" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="uCena" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="korisnik" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="canBeRated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="canceled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="sJedinicaID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacijaXMLDTO", propOrder = {
    "datumRez",
    "od",
    "_do",
    "uCena",
    "korisnik",
    "canBeRated",
    "rated",
    "canceled"
})
public class RezervacijaXMLDTO {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumRez;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar od;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar _do;
    protected double uCena;
    protected String korisnik;
    protected boolean canBeRated;
    protected boolean rated;
    protected boolean canceled;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "sJedinicaID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String sJedinicaID;

    /**
     * Gets the value of the datumRez property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumRez() {
        return datumRez;
    }

    /**
     * Sets the value of the datumRez property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRez(XMLGregorianCalendar value) {
        this.datumRez = value;
    }

    /**
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOd(XMLGregorianCalendar value) {
        this.od = value;
    }

    /**
     * Gets the value of the do property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDo() {
        return _do;
    }

    /**
     * Sets the value of the do property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDo(XMLGregorianCalendar value) {
        this._do = value;
    }

    /**
     * Gets the value of the uCena property.
     * 
     */
    public double getUCena() {
        return uCena;
    }

    /**
     * Sets the value of the uCena property.
     * 
     */
    public void setUCena(double value) {
        this.uCena = value;
    }

    /**
     * Gets the value of the korisnik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKorisnik() {
        return korisnik;
    }

    /**
     * Sets the value of the korisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKorisnik(String value) {
        this.korisnik = value;
    }

    /**
     * Gets the value of the canBeRated property.
     * 
     */
    public boolean isCanBeRated() {
        return canBeRated;
    }

    /**
     * Sets the value of the canBeRated property.
     * 
     */
    public void setCanBeRated(boolean value) {
        this.canBeRated = value;
    }

    /**
     * Gets the value of the rated property.
     * 
     */
    public boolean isRated() {
        return rated;
    }

    /**
     * Sets the value of the rated property.
     * 
     */
    public void setRated(boolean value) {
        this.rated = value;
    }

    /**
     * Gets the value of the canceled property.
     * 
     */
    public boolean isCanceled() {
        return canceled;
    }

    /**
     * Sets the value of the canceled property.
     * 
     */
    public void setCanceled(boolean value) {
        this.canceled = value;
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
     * Gets the value of the sJedinicaID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSJedinicaID() {
        return sJedinicaID;
    }

    /**
     * Sets the value of the sJedinicaID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSJedinicaID(String value) {
        this.sJedinicaID = value;
    }

}
