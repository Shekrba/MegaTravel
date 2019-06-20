package com.megatravel.agentservice.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@Entity
public class Slika {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @XmlAttribute(name = "src")
    @XmlSchemaType(name = "anySimpleType")
    @Column(name = "src", unique = false, nullable = false)
    protected String src;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Smestaj smestaj;

    public Smestaj getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(Smestaj smestaj) {
        this.smestaj = smestaj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the value of the src property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSrc() {
        return src;
    }

    /**
     * Sets the value of the src property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSrc(String value) {
        this.src = value;
    }

}
