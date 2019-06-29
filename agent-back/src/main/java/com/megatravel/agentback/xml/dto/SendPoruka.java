
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendPoruka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendPoruka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Poruka" type="{http://service.agent.megatravel.com/}porukaXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendPoruka", propOrder = {
    "poruka"
})
public class SendPoruka {

    @XmlElement(name = "Poruka")
    protected PorukaXMLDTO poruka;

    /**
     * Gets the value of the poruka property.
     * 
     * @return
     *     possible object is
     *     {@link PorukaXMLDTO }
     *     
     */
    public PorukaXMLDTO getPoruka() {
        return poruka;
    }

    /**
     * Sets the value of the poruka property.
     * 
     * @param value
     *     allowed object is
     *     {@link PorukaXMLDTO }
     *     
     */
    public void setPoruka(PorukaXMLDTO value) {
        this.poruka = value;
    }

}
