package com.megatravel.rezervacija.controller;

import com.megatravel.rezervacija.model.Rezervacija;
import com.megatravel.rezervacija.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/reservations", produces="application/json;charset=UTF-8")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.POST)
    public Rezervacija addRezervacija(@RequestBody Rezervacija rezervacija){
        return rezervacijaService.addRezervacija(rezervacija);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Rezervacija deleteRezervacija(@PathVariable("id")Long id){
        return rezervacijaService.deleteRezervacija(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Rezervacija> getRezervacije(){
        return rezervacijaService.getRezervacije();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rezervacija getRezervacija(@PathVariable("id")Long id){
        return rezervacijaService.getRezervacija(id);
    }
}
