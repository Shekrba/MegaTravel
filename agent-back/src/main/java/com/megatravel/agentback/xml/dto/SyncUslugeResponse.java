
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for syncUslugeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="syncUslugeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Usluge" type="{http://service.agent.megatravel.com/}uslugaXMLDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "syncUslugeResponse", propOrder = {
    "usluge"
})
public class SyncUslugeResponse {

    @XmlElement(name = "Usluge")
    protected List<UslugaXMLDTO> usluge;

    /**
     * Gets the value of the usluge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usluge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsluge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UslugaXMLDTO }
     * 
     * 
     */
    public List<UslugaXMLDTO> getUsluge() {
        if (usluge == null) {
            usluge = new ArrayList<UslugaXMLDTO>();
        }
        return this.usluge;
    }

}
