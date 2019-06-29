package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RezervacijaMakeXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class RezervacijaMakeXMLDTO {

    private Date from;
    private Date to;
    private double cost;
    private Long sjedinicaId;
    private List<UslugaXMLDTO> services;

}
