
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for rezervacijaMakeXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacijaMakeXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sjedinicaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="services" type="{http://service.agent.megatravel.com/}uslugaXMLDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacijaMakeXMLDTO", propOrder = {
    "from",
    "to",
    "cost",
    "sjedinicaId",
    "services"
})
public class RezervacijaMakeXMLDTO {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar from;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar to;
    protected double cost;
    protected Long sjedinicaId;
    @XmlElement(nillable = true)
    protected List<UslugaXMLDTO> services;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     */
    public void setCost(double value) {
        this.cost = value;
    }

    /**
     * Gets the value of the sjedinicaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSjedinicaId() {
        return sjedinicaId;
    }

    /**
     * Sets the value of the sjedinicaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSjedinicaId(Long value) {
        this.sjedinicaId = value;
    }

    /**
     * Gets the value of the services property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the services property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServices().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UslugaXMLDTO }
     * 
     * 
     */
    public List<UslugaXMLDTO> getServices() {
        if (services == null) {
            services = new ArrayList<UslugaXMLDTO>();
        }
        return this.services;
    }

}
