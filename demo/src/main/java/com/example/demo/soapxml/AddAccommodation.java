
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addAccommodation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addAccommodation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccommodationRequest" type="{http://service.agent.megatravel.com/}smestajXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAccommodation", propOrder = {
    "accommodationRequest"
})
public class AddAccommodation {

    @XmlElement(name = "AccommodationRequest")
    protected SmestajXMLDTO accommodationRequest;

    /**
     * Gets the value of the accommodationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SmestajXMLDTO }
     *     
     */
    public SmestajXMLDTO getAccommodationRequest() {
        return accommodationRequest;
    }

    /**
     * Sets the value of the accommodationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmestajXMLDTO }
     *     
     */
    public void setAccommodationRequest(SmestajXMLDTO value) {
        this.accommodationRequest = value;
    }

}
