
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editAccommodationUnit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editAccommodationUnit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccommodationUnit" type="{http://service.agent.megatravel.com/}sJedinicaXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editAccommodationUnit", propOrder = {
    "accommodationUnit"
})
public class EditAccommodationUnit {

    @XmlElement(name = "AccommodationUnit")
    protected SJedinicaXMLDTO accommodationUnit;

    /**
     * Gets the value of the accommodationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link SJedinicaXMLDTO }
     *     
     */
    public SJedinicaXMLDTO getAccommodationUnit() {
        return accommodationUnit;
    }

    /**
     * Sets the value of the accommodationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link SJedinicaXMLDTO }
     *     
     */
    public void setAccommodationUnit(SJedinicaXMLDTO value) {
        this.accommodationUnit = value;
    }

}
