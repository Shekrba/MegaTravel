package com.megatravel.agent.service;

import com.megatravel.agent.xml.dto.UserCredentialsXMLDTO;
import com.megatravel.agent.xml.dto.UslugaXMLDTO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

@WebService(serviceName = "LoginService")
public interface LoginService {

    @WebMethod(action = "firstLogin")
    @WebResult(name = "Success")
    public String firstLogin(@WebParam(name = "LoginRequest") UserCredentialsXMLDTO credentials) throws SOAPFaultException, SOAPException;




}
