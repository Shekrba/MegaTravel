package com.megatravel.agentback.client;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.megatravel.agentback.xml.dto");
        return marshaller;
    }

    @Bean
    public AgentClient countryClient(Jaxb2Marshaller marshaller) {
        AgentClient client = new AgentClient();
        client.setDefaultUri("http://localhost:8762/agent-service/api");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
