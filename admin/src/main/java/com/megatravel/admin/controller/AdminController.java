package com.megatravel.admin.controller;

import com.megatravel.admin.dto.AgentDTO;
import com.megatravel.admin.dto.ChosenServicesDTO;
import com.megatravel.admin.dto.SmestajDTO;
import com.megatravel.admin.dto.UslugaDTO;
import com.megatravel.admin.model.*;
import com.megatravel.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.List;

@RestController
@RequestMapping(value = "api/admin", produces="application/json;charset=UTF-8")
public class AdminController {

    @Autowired
    AdminService adminService;


    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return adminService.getCategories();
    }

    @RequestMapping(value="/serviceForCategory/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> setServicesForCategory(@PathVariable("id") Long id, @RequestBody ChosenServicesDTO services){
        try {
            String message = adminService.setServicesForCategory(id,services.getServices());
            return new ResponseEntity<String>(message,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/services", method = RequestMethod.POST)
    public Usluga addUsluga(@RequestBody UslugaDTO usluga){
        return adminService.addUsluga(usluga);
    }

    @RequestMapping(value = "/services/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUsluga(@PathVariable("id")Long id){
        try {
            String message = adminService.deleteUsluga(id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/services/{id}", method = RequestMethod.PUT)
    public Usluga updateUsluga(@RequestBody UslugaDTO usluga, @PathVariable("id") Long id){
        return adminService.updateUsluga(usluga, id);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<Usluga> getUsluge(){
        return adminService.getUsluge();
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.PUT)
    public SJedinica setTip(@RequestBody Smestaj smestaj){
        return adminService.setTip(smestaj.getId(), smestaj.getTipSmestaja());
    }

    @RequestMapping(value="/accomodation", method = RequestMethod.POST)
    public Smestaj addAccomodation(@RequestBody SmestajDTO smestaj)
    {
        return adminService.addAccomodation(smestaj);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public List<Komentar> getComments()
    {
        return adminService.getUnapprovedComments();
    }
    @RequestMapping(value = "/comments/{id}", method = RequestMethod.PUT)
    public Komentar odobriKomentar(@PathVariable("id")Long id){
        return adminService.odobriKomentar(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User blockKorisnik(@PathVariable("id")Long id){
        return adminService.blockKorisnik(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public User activatKorisnik(@PathVariable("id")Long id){
        return adminService.activateKorisnik(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User deleteKorisnik(@PathVariable("id")Long id){
        return adminService.deleteKorisnik(id);
    }

    @RequestMapping(value = "/agent", method = RequestMethod.POST)
    public User addAgent(@RequestBody AgentDTO agent){
        return adminService.addAgent(agent);
    }
}
