package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RezervacijaMakeXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class RezervacijaMakeXMLDTO {

    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long id;

    private Date from;
    private Date to;
    private double cost;
    private Long sjedinicaId;
    private List<UslugaXMLDTO> services;

}
