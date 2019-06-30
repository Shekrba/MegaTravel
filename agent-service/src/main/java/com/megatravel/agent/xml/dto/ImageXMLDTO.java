package com.megatravel.agent.xml.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ImageXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class ImageXMLDTO {

    @XmlAttribute(name = "smestajID", required = true)
    @XmlSchemaType(name = "anySimpleType")
    @XmlJavaTypeAdapter(type=Long.class, value= WSLongAdapter.class)
    private Long smestajID;

    @XmlJavaTypeAdapter(value= Base64Adapter.class)
    private List<byte[]> slike;
}
