package com.megatravel.agent.service;






import com.megatravel.agent.model.Rezervacija;
import com.megatravel.agent.xml.dto.*;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;


import javax.xml.soap.SOAPException;

import javax.xml.ws.soap.SOAPFaultException;
import java.util.List;

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


	@WebMethod(action = "syncUsluge")
	@WebResult(name = "Usluge")
	public List<UslugaXMLDTO> syncUsluge() throws SOAPFaultException, SOAPException;

	@WebMethod(action = "syncUsluge")
	@WebResult(name = "Categories")
	public List<CategoryXMLDTO> syncCategories() throws SOAPFaultException, SOAPException;


	@WebMethod(action = "pollingPoruke")
	@WebResult(name = "Poruke")
	public List<PorukaXMLDTO> pollingPoruke() throws SOAPFaultException, SOAPException;


	@WebMethod(action = "sendPoruka")
	@WebResult(name = "Successful")
	public boolean sendPoruka(@WebParam(name="Poruka") PorukaXMLDTO poruka) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "makeReservation")
	@WebResult(name = "Reservation")
	public RezervacijaMakeXMLDTO makeReservation(@WebParam(name="Reservation") RezervacijaMakeXMLDTO reservation) throws SOAPFaultException, SOAPException;


	@WebMethod(action = "syncReservations")
	@WebResult(name = "Reservations")
	public List<RezervacijaXMLDTO> syncReservations() throws SOAPFaultException, SOAPException;

	@WebMethod(action = "addImages")
	@WebResult(name = "Successful")
	public boolean addImages(@WebParam(name="Images") ImageXMLDTO images) throws SOAPFaultException, SOAPException;

	@WebMethod(action = "changePassword")
	@WebResult(name = "Successful")
	public boolean changePassword(@WebParam(name="UserCredentials") UserCredentialsXMLDTO credentials) throws SOAPFaultException, SOAPException;

}
