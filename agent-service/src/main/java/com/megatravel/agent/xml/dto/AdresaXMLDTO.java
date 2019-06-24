package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AdresaXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class AdresaXMLDTO {


    private double latitude;


    private double longitude;


    private String mesto;


    private String posBroj;


    private String ulica;


    private int broj;


    private Integer brojStana;

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    private Long id;
}
