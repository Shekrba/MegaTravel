
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addAccommodationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addAccommodationResponse">
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
@XmlType(name = "addAccommodationResponse", propOrder = {
    "accommodation"
})
public class AddAccommodationResponse {

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
