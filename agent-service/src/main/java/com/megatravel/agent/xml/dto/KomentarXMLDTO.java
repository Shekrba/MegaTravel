package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "KomentarXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class KomentarXMLDTO {

    private String username;

    private Long smestajID;

    private boolean odobren;

    private String tekst;

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    private Long id;

}
