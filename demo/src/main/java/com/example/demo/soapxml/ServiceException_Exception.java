
package com.example.demo.soapxml;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.2
 * 2019-06-23T04:59:00.320+02:00
 * Generated source version: 2.7.2
 */

@WebFault(name = "ServiceException", targetNamespace = "http://service.agent.megatravel.com/")
public class ServiceException_Exception extends Exception {
    
    private ServiceException serviceException;

    public ServiceException_Exception() {
        super();
    }
    
    public ServiceException_Exception(String message) {
        super(message);
    }
    
    public ServiceException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException_Exception(String message, ServiceException serviceException) {
        super(message);
        this.serviceException = serviceException;
    }

    public ServiceException_Exception(String message, ServiceException serviceException, Throwable cause) {
        super(message, cause);
        this.serviceException = serviceException;
    }

    public ServiceException getFaultInfo() {
        return this.serviceException;
    }
}
