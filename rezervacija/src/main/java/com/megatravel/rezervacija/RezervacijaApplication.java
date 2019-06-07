package com.megatravel.rezervacija;

import com.megatravel.rezervacija.controller.RezervacijaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RezervacijaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RezervacijaApplication.class, args);
    }
}
