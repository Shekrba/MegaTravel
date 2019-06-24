package com.megatravel.agent;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class AgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgentApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean cxfServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CXFServlet(), "/api/*");
        registration.setLoadOnStartup(1);
        return registration;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}
