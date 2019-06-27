
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editAccommodationResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editAccommodationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultIsSuccessful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editAccommodationResponse", propOrder = {
    "resultIsSuccessful"
})
public class EditAccommodationResponse {

    @XmlElement(name = "ResultIsSuccessful")
    protected boolean resultIsSuccessful;

    /**
     * Gets the value of the resultIsSuccessful property.
     * 
     */
    public boolean isResultIsSuccessful() {
        return resultIsSuccessful;
    }

    /**
     * Sets the value of the resultIsSuccessful property.
     * 
     */
    public void setResultIsSuccessful(boolean value) {
        this.resultIsSuccessful = value;
    }

}
