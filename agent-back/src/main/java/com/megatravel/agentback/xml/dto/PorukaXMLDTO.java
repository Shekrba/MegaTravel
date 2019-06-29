
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for porukaXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="porukaXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="posiljalac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primalac" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "porukaXMLDTO", propOrder = {
    "sadrzaj",
    "posiljalac",
    "primalac"
})
public class PorukaXMLDTO {

    @XmlElement(required = true)
    protected String sadrzaj;
    protected String posiljalac;
    @XmlElement(required = true)
    protected String primalac;
    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the posiljalac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosiljalac() {
        return posiljalac;
    }

    /**
     * Sets the value of the posiljalac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosiljalac(String value) {
        this.posiljalac = value;
    }

    /**
     * Gets the value of the primalac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimalac() {
        return primalac;
    }

    /**
     * Sets the value of the primalac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimalac(String value) {
        this.primalac = value;
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
