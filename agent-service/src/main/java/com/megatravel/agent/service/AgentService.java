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


	@WebMethod(action = "addAccommodation")
	@WebResult(name = "Accommodation")
	public SmestajXMLDTO addAccommodation(@WebParam(name = "Accommodation") SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "editAccommodation")
	@WebResult(name = "ResultIsSuccessful")
	public boolean editAccommodation(@WebParam(name = "Accommodation") SmestajXMLDTO accommodation) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "addAccommodationUnit")
	@WebResult(name = "AccommodationUnit")
	public SJedinicaXMLDTO addAccommodationUnit(@WebParam(name = "AccommodationUnit") SJedinicaXMLDTO accommodationUnit) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "editAccommodationUnit")
	@WebResult(name = "ResultIsSuccessful")
	public boolean editAccommodationUnit(@WebParam(name = "AccommodationUnit") SJedinicaXMLDTO accommodationUnit) throws SOAPFaultException, SOAPException;


}
