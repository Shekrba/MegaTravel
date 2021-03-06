package com.megatravel.rezervacija.controller;

import com.megatravel.rezervacija.dto.*;
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
    public ResponseEntity<Long> addRezervacija(@RequestBody MakeResDTO rezervacija){
        try {
            Long ret = rezervacijaService.addRezervacija(rezervacija);

            if(ret == null){
                return new ResponseEntity<Long>(ret,HttpStatus.UPGRADE_REQUIRED);
            }

            return new ResponseEntity<Long>(ret,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRezervacija(@PathVariable("id")Long id){
        try {
            String message = rezervacijaService.deleteRezervacija(id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Rezervacija getRezervacija(@PathVariable("id")Long id){
        return rezervacijaService.getRezervacija(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<ReservationDTO> getUserReservations(@PathVariable("id")Long userId){
        return rezervacijaService.getUserReservations(userId);
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

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseEntity<String> newMessage(@RequestBody PorukaDTO porukaDTO){
        try {
                String message = rezervacijaService.newMessage(porukaDTO);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/message/inbox/{id}", method = RequestMethod.GET)
    public List<PorukaDTO> getInboxMessages(@PathVariable("id")Long user_id) {
        return rezervacijaService.getInboxMessages(user_id);
    }

    @RequestMapping(value = "/message/sent/{id}", method = RequestMethod.GET)
    public List<PorukaDTO> getSentMessages(@PathVariable("id")Long user_id) {
        return rezervacijaService.getSentMessages(user_id);
    }

}
