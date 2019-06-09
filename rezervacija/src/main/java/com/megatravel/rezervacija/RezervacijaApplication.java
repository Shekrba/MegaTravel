package com.megatravel.rezervacija;

import com.megatravel.rezervacija.controller.RezervacijaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
public class RezervacijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RezervacijaApplication.class, args);
    }
}
