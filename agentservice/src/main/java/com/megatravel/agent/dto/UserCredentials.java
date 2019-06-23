package com.megatravel.agent.dto;



import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UserCredentials")
@Getter
@Setter
public class UserCredentials {

    private String username;
    private String password;


}
