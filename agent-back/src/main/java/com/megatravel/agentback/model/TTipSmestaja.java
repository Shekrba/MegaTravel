//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.23 at 02:21:04 PM CEST
//

package com.megatravel.agentback.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TTipSmestaja.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TTipSmestaja">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hotel"/>
 *     &lt;enumeration value="bed&amp;breakfast"/>
 *     &lt;enumeration value="apartman"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "TTipSmestaja")
@XmlEnum
public enum TTipSmestaja {

    @XmlEnumValue("hotel")
    HOTEL("hotel"),
    @XmlEnumValue("bed&breakfast")
    BED_BREAKFAST("bed&breakfast"),
    @XmlEnumValue("apartman")
    APARTMAN("apartman");
    private final String value;

    TTipSmestaja(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TTipSmestaja fromValue(String v) {
        for (TTipSmestaja c: TTipSmestaja.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
