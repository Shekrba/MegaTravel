
package com.megatravel.agentback.xml.dto;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.2
 * 2019-06-29T19:42:47.280+02:00
 * Generated source version: 2.7.2
 */

@WebFault(name = "SOAPFaultException", targetNamespace = "http://service.agent.megatravel.com/")
public class SOAPFaultException_Exception extends Exception {
    
    private client4.SOAPFaultException soapFaultException;

    public SOAPFaultException_Exception() {
        super();
    }
    
    public SOAPFaultException_Exception(String message) {
        super(message);
    }
    
    public SOAPFaultException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public SOAPFaultException_Exception(String message, client4.SOAPFaultException soapFaultException) {
        super(message);
        this.soapFaultException = soapFaultException;
    }

    public SOAPFaultException_Exception(String message, client4.SOAPFaultException soapFaultException, Throwable cause) {
        super(message, cause);
        this.soapFaultException = soapFaultException;
    }

    public client4.SOAPFaultException getFaultInfo() {
        return this.soapFaultException;
    }
}
