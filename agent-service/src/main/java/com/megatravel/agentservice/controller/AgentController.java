package com.megatravel.agentservice.controller;


import com.megatravel.agentservice.client.AgentClient;
import generated.GetTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgentController {

    @Autowired
    AgentClient client;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetTestResponse returnCountryResponse()
    {
        return client.test("test");
    }


}
