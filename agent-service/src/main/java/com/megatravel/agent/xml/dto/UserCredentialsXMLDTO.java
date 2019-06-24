package com.megatravel.agent.xml.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UserCredentialsXMLDTO")
@Getter
@Setter
@NoArgsConstructor
public class UserCredentialsXMLDTO {

    private String username;
    private String password;


}
