package com.megatravel.rezervacija.controller;

import com.megatravel.rezervacija.dto.MakeResDTO;
import com.megatravel.rezervacija.dto.ReservationDTO;
import com.megatravel.rezervacija.dto.SmestajDTO;
import com.megatravel.rezervacija.dto.formDTO;
import com.megatravel.rezervacija.model.Rezervacija;
import com.megatravel.rezervacija.service.RezervacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/reservations", produces="application/json;charset=UTF-8")
public class RezervacijaController {

    @Autowired
    private RezervacijaService rezervacijaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addRezervacija(@RequestBody MakeResDTO rezervacija){
        try {
            String message = rezervacijaService.addRezervacija(rezervacija);
            return new ResponseEntity<String>(message,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

    @RequestMapping(value = "/rate/{id}", method = RequestMethod.GET)
    public List<ReservationDTO> getReservationsToRate(@PathVariable("id")Long user_id) {
        return rezervacijaService.getReservationsToRate(user_id);
    }

    @RequestMapping(value = "/rate/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> setRatedTrue(@PathVariable("id")Long id) {
        try {
            String message = rezervacijaService.setRatedTrue(id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public SmestajDTO formReservation(@RequestBody formDTO form) {
        return rezervacijaService.formReservation(form);
    }
}
