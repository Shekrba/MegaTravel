
package com.example.demo.soapxml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for smestajXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="smestajXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sJedinice" type="{http://service.agent.megatravel.com/}sJedinicaXMLDTO" maxOccurs="unbounded"/>
 *         &lt;element name="accomodationType" type="{http://service.agent.megatravel.com/}accomodationTypeXMLDTO"/>
 *         &lt;element name="adresa" type="{http://service.agent.megatravel.com/}adresaXMLDTO"/>
 *         &lt;element name="opis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uslugaList" type="{http://service.agent.megatravel.com/}uslugaXMLDTO" maxOccurs="unbounded"/>
 *         &lt;element name="periodOtkaza" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://service.agent.megatravel.com/}categoryXMLDTO"/>
 *         &lt;element name="comments" type="{http://service.agent.megatravel.com/}komentarXMLDTO" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "smestajXMLDTO", propOrder = {
    "naziv",
    "sJedinice",
    "accomodationType",
    "adresa",
    "opis",
    "uslugaList",
    "periodOtkaza",
    "username",
    "category",
    "comments"
})
public class SmestajXMLDTO {

    protected String naziv;
    @XmlElement(required = true)
    protected List<SJedinicaXMLDTO> sJedinice;
    @XmlElement(required = true)
    protected AccomodationTypeXMLDTO accomodationType;
    @XmlElement(required = true)
    protected AdresaXMLDTO adresa;
    protected String opis;
    @XmlElement(required = true)
    protected List<UslugaXMLDTO> uslugaList;
    protected int periodOtkaza;
    protected String username;
    @XmlElement(required = true)
    protected CategoryXMLDTO category;
    @XmlElement(required = true)
    protected List<KomentarXMLDTO> comments;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

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
     * Gets the value of the sJedinice property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sJedinice property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSJedinice().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SJedinicaXMLDTO }
     * 
     * 
     */
    public List<SJedinicaXMLDTO> getSJedinice() {
        if (sJedinice == null) {
            sJedinice = new ArrayList<SJedinicaXMLDTO>();
        }
        return this.sJedinice;
    }

    /**
     * Gets the value of the accomodationType property.
     * 
     * @return
     *     possible object is
     *     {@link AccomodationTypeXMLDTO }
     *     
     */
    public AccomodationTypeXMLDTO getAccomodationType() {
        return accomodationType;
    }

    /**
     * Sets the value of the accomodationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccomodationTypeXMLDTO }
     *     
     */
    public void setAccomodationType(AccomodationTypeXMLDTO value) {
        this.accomodationType = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link AdresaXMLDTO }
     *     
     */
    public AdresaXMLDTO getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdresaXMLDTO }
     *     
     */
    public void setAdresa(AdresaXMLDTO value) {
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
     * Gets the value of the uslugaList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uslugaList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUslugaList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UslugaXMLDTO }
     * 
     * 
     */
    public List<UslugaXMLDTO> getUslugaList() {
        if (uslugaList == null) {
            uslugaList = new ArrayList<UslugaXMLDTO>();
        }
        return this.uslugaList;
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
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryXMLDTO }
     *     
     */
    public CategoryXMLDTO getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryXMLDTO }
     *     
     */
    public void setCategory(CategoryXMLDTO value) {
        this.category = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KomentarXMLDTO }
     * 
     * 
     */
    public List<KomentarXMLDTO> getComments() {
        if (comments == null) {
            comments = new ArrayList<KomentarXMLDTO>();
        }
        return this.comments;
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

}
