
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for imageXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="imageXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="slike" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="smestajID" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageXMLDTO", propOrder = {
    "slike"
})
public class ImageXMLDTO {

    @XmlElement(nillable = true)
    protected List<String> slike=new ArrayList<>();
    @XmlAttribute(name = "smestajID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String smestajID;

    /**
     * Gets the value of the slike property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slike property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlike().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSlike() {
        if (slike == null) {
            slike = new ArrayList<String>();
        }
        return this.slike;
    }

    /**
     * Gets the value of the smestajID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmestajID() {
        return smestajID;
    }

    /**
     * Sets the value of the smestajID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmestajID(String value) {
        this.smestajID = value;
    }

}
