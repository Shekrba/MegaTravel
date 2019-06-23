package com.megatravel.agent.exception;

import java.io.Serializable;

public class ServiceExceptionDetails implements Serializable {

    private String faultCode;
    private String faultMessage;

    public ServiceExceptionDetails() {
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultMessage() {
        return faultMessage;
    }

    public void setFaultMessage(String faultMessage) {
        this.faultMessage = faultMessage;
    }

}
