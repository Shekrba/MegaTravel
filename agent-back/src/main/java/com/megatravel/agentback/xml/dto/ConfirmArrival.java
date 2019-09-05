
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for confirmArrival complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="confirmArrival">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReservationID" type="{http://service.agent.megatravel.com/}confirmArrivalXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmArrival", propOrder = {
    "reservationID"
})
public class ConfirmArrival {

    @XmlElement(name = "ReservationID")
    protected ConfirmArrivalXMLDTO reservationID;

    /**
     * Gets the value of the reservationID property.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmArrivalXMLDTO }
     *     
     */
    public ConfirmArrivalXMLDTO getReservationID() {
        return reservationID;
    }

    /**
     * Sets the value of the reservationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmArrivalXMLDTO }
     *     
     */
    public void setReservationID(ConfirmArrivalXMLDTO value) {
        this.reservationID = value;
    }

}
