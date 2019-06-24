package com.megatravel.agentback.client;

import generated.GetTestRequest;
import generated.GetTestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class AgentClient extends  WebServiceGatewaySupport{

    private static final Logger log = LoggerFactory.getLogger(AgentClient.class);

    public GetTestResponse test(String test)
    {
        GetTestRequest request = new GetTestRequest();

        request.setTest(test);

        GetTestResponse response = (GetTestResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8762/agent-service/ws/acc", request,
                        new SoapActionCallback(
                                "http://ftn.com/agentSoap/xsd"));

        return response;

    }

}
