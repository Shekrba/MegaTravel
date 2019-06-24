
package com.example.demo.soap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CountryConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.demo.soapxml");
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
