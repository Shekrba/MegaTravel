
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for categoryXMLDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="categoryXMLDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vrednost" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usluge" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "categoryXMLDTO", propOrder = {
    "naziv",
    "vrednost",
    "usluge"
})
public class CategoryXMLDTO {

    protected String naziv;
    protected int vrednost;
    @XmlElement(nillable = true)
    protected List<Long> usluge;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     */
    public int getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     */
    public void setVrednost(int value) {
        this.vrednost = value;
    }

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
     * {@link Long }
     * 
     * 
     */
    public List<Long> getUsluge() {
        if (usluge == null) {
            usluge = new ArrayList<Long>();
        }
        return this.usluge;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
