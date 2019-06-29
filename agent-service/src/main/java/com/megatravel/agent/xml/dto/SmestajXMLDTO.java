package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SmestajXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class SmestajXMLDTO {

    private String naziv;

    @XmlElement(name = "sJedinice", required = true)
    private List<SJedinicaXMLDTO> sJedinice;

    @XmlElement(name = "accomodationType", required = true)
    private AccomodationTypeXMLDTO accomodationType;

    @XmlElement(name = "adresa", required = true)
    private AdresaXMLDTO adresa;

    private String opis;

    @XmlElement(name = "uslugaList", required = true)
    private List<UslugaXMLDTO> uslugaList;

    private int periodOtkaza;

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long id;


    @XmlElement(name = "category", required = true)
    private CategoryXMLDTO category;

    @XmlElement(name = "comments", required = true)
    private List<KomentarXMLDTO> comments;


}
