
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editAccommodation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editAccommodation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Accommodation" type="{http://service.agent.megatravel.com/}smestajXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editAccommodation", propOrder = {
    "accommodation"
})
public class EditAccommodation {

    @XmlElement(name = "Accommodation")
    protected SmestajXMLDTO accommodation;

    /**
     * Gets the value of the accommodation property.
     * 
     * @return
     *     possible object is
     *     {@link SmestajXMLDTO }
     *     
     */
    public SmestajXMLDTO getAccommodation() {
        return accommodation;
    }

    /**
     * Sets the value of the accommodation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmestajXMLDTO }
     *     
     */
    public void setAccommodation(SmestajXMLDTO value) {
        this.accommodation = value;
    }

}
