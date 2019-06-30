
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for syncAccommodationTypeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="syncAccommodationTypeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccommodationTypes" type="{http://service.agent.megatravel.com/}accomodationTypeXMLDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "syncAccommodationTypeResponse", propOrder = {
    "accommodationTypes"
})
public class SyncAccommodationTypeResponse {

    @XmlElement(name = "AccommodationTypes")
    protected List<AccomodationTypeXMLDTO> accommodationTypes;

    /**
     * Gets the value of the accommodationTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccomodationTypeXMLDTO }
     * 
     * 
     */
    public List<AccomodationTypeXMLDTO> getAccommodationTypes() {
        if (accommodationTypes == null) {
            accommodationTypes = new ArrayList<AccomodationTypeXMLDTO>();
        }
        return this.accommodationTypes;
    }

}
