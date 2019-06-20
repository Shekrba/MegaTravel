
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sayHowAreYou complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sayHowAreYou">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GreetingsRequest" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sayHowAreYou", propOrder = {
    "greetingsRequest"
})
public class SayHowAreYou {

    @XmlElement(name = "GreetingsRequest")
    protected String greetingsRequest;

    /**
     * Gets the value of the greetingsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGreetingsRequest() {
        return greetingsRequest;
    }

    /**
     * Sets the value of the greetingsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGreetingsRequest(String value) {
        this.greetingsRequest = value;
    }

}
