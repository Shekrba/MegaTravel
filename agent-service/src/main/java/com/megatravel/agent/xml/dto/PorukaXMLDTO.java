package com.megatravel.agent.xml.dto;

import com.megatravel.agent.model.Poruka;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PorukaXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class PorukaXMLDTO {

    @XmlElement(required = true)
    private String sadrzaj;

    private String posiljalac;

    @XmlElement(required = true)
    private String primalac;

    @XmlAttribute(name = "id")
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long id;

    public PorukaXMLDTO(Poruka poruka){
        this.sadrzaj=poruka.getSadrzaj();
        this.posiljalac=poruka.getPosiljalac().getUsername();
        this.primalac=poruka.getPrimalac().getUsername();
        this.id=poruka.getId();
    }
}
