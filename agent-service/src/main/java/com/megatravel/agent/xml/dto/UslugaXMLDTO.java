package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UslugaXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class UslugaXMLDTO {

    private String naziv;

    private String opis;

    private double cena;

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long id;

    List<Long> categories;

}
