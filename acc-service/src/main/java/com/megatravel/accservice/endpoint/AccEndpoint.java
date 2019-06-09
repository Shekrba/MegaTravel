package com.megatravel.accservice.endpoint;

import generated.GetTestRequest;
import generated.GetTestResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AccEndpoint {

    private static final String NAMESPACE_URI = "http://ftn.com/agentSoap/xsd";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTestRequest")
    @ResponsePayload
    public GetTestResponse getTest(@RequestPayload GetTestRequest request)
    {
        GetTestResponse response = new GetTestResponse();
        response.setCountry(request.getTest());
        return response;
    }

}
