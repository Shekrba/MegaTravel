package com.megatravel.agent.service;






import com.megatravel.agent.xml.dto.SJedinicaXMLDTO;
import com.megatravel.agent.xml.dto.SmestajXMLDTO;
import com.megatravel.agent.xml.dto.UserCredentialsXMLDTO;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.soap.SOAPException;
import javax.xml.ws.soap.SOAPFaultException;

@WebService(serviceName = "AgentService")
public interface AgentService {

	@WebMethod(action = "firstLogin")
	@WebResult(name = "Success")
	public String firstLogin(@WebParam(name = "LoginRequest") UserCredentialsXMLDTO credentials) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "addAccommodation")
	@WebResult(name = "Accommodation")
	public SmestajXMLDTO addAccommodation(@WebParam(name = "AccommodationRequest") SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "editAccommodation")
	@WebResult(name = "Accommodation")
	public SmestajXMLDTO editAccommodation(@WebParam(name = "AccommodationRequest") SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "addAccommodationUnit")
	@WebResult(name = "AccommodationUnit")
	public SJedinicaXMLDTO addAccommodationUnit(@WebParam(name = "AccommodationUnitRequest") SJedinicaXMLDTO accommodationUnit) throws SOAPFaultException, SOAPException;



}
