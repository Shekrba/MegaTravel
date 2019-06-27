package com.megatravel.agent.config;

import com.megatravel.agent.service.interceptors.AppInboundInterceptor;
import com.megatravel.agent.service.interceptors.AppOutboundInterceptor;
import com.megatravel.agent.service.AgentServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {
/*
	@Bean
	public ServletRegistrationBean dispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/api/*");
    }*/
    @Autowired
    AgentServiceImpl agentService;
	
    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
    	SpringBus springBus = new SpringBus();
       	springBus.getInInterceptors().add(new AppInboundInterceptor());
    	springBus.getOutInterceptors().add(new AppOutboundInterceptor());
    	return springBus;
    }	
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl ep = new EndpointImpl(springBus(), agentService);
        ep.getFeatures().add(new LoggingFeature());
        //ep.getProperties().put("schema-validation-enabled",true);
        ep.publish("/");
        return ep;
    }


}
