//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.05.23 at 02:20:55 PM CEST 
//


package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TAgent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TAgent">
 *   &lt;complexContent>
 *     &lt;extension base="{https://github.com/Shekrba/MegaTravel/Korisnik}TKorisnik">
 *       &lt;sequence>
 *         &lt;element name="PosMatBroj">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="([0-9]{13})"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TAgent", namespace = "https://github.com/Shekrba/MegaTravel/Korisnik", propOrder = {
    "posMatBroj"
})
public class TAgent
    extends TKorisnik
{

    @XmlElement(name = "PosMatBroj", required = true, defaultValue = "0000000000000")
    protected String posMatBroj;

    /**
     * Gets the value of the posMatBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosMatBroj() {
        return posMatBroj;
    }

    /**
     * Sets the value of the posMatBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosMatBroj(String value) {
        this.posMatBroj = value;
    }

}
