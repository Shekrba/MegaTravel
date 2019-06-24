
package com.example.demo.soapxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for firstLogin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="firstLogin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LoginRequest" type="{http://service.agent.megatravel.com/}userCredentialsXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "firstLogin", propOrder = {
    "loginRequest"
})
public class FirstLogin {

    @XmlElement(name = "LoginRequest")
    protected UserCredentialsXMLDTO loginRequest;

    /**
     * Gets the value of the loginRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UserCredentialsXMLDTO }
     *     
     */
    public UserCredentialsXMLDTO getLoginRequest() {
        return loginRequest;
    }

    /**
     * Sets the value of the loginRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserCredentialsXMLDTO }
     *     
     */
    public void setLoginRequest(UserCredentialsXMLDTO value) {
        this.loginRequest = value;
    }

}
