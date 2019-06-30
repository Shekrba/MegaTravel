
package com.megatravel.agentback.xml.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addImages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addImages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Images" type="{http://service.agent.megatravel.com/}imageXMLDTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addImages", propOrder = {
    "images"
})
public class AddImages {

    @XmlElement(name = "Images")
    protected ImageXMLDTO images;

    /**
     * Gets the value of the images property.
     * 
     * @return
     *     possible object is
     *     {@link ImageXMLDTO }
     *     
     */
    public ImageXMLDTO getImages() {
        return images;
    }

    /**
     * Sets the value of the images property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageXMLDTO }
     *     
     */
    public void setImages(ImageXMLDTO value) {
        this.images = value;
    }

}
