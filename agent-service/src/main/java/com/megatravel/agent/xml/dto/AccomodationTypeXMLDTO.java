package com.megatravel.agent.xml.dto;

import com.megatravel.agent.model.AccomodationType;
import com.megatravel.agent.utils.ObjectMapperUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AccomodationTypeXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class AccomodationTypeXMLDTO {

    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    private Long id;

    private String naziv;

}
