package com.megatravel.admin.controller;

import com.megatravel.admin.model.*;
import com.megatravel.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/admin", produces="application/json;charset=UTF-8")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/services", method = RequestMethod.POST)
    public Usluga addUsluga(@RequestBody Usluga usluga){
        return adminService.addUsluga(usluga);
    }

    @RequestMapping(value = "/services/{id}", method = RequestMethod.DELETE)
    public Usluga deleteUsluga(@PathVariable("id")Long id){
        return adminService.deleteUsluga(id);
    }

    @RequestMapping(value = "/services/{id}", method = RequestMethod.PUT)
    public Usluga updateUsluga(@RequestBody Usluga usluga){
        return adminService.updateUsluga(usluga);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<Usluga> getUsluge(){
        return adminService.getUsluge();
    }

    @RequestMapping(value = "/hotels", method = RequestMethod.PUT)
    public SJedinica setTip(@RequestBody Smestaj smestaj){
        return adminService.setTip(smestaj.getId(), smestaj.getTipSmestaja());
    }

    @RequestMapping(value = "/comments", method = RequestMethod.PUT)
    public Komentar odobriKomentar(@PathVariable("id")Long id){
        return adminService.odobriKomentar(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public TKorisnik blockKorisnik(@PathVariable("id")Long id){
        return adminService.blockKorisnik(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public TKorisnik activatKorisnik(@PathVariable("id")Long id){
        return adminService.activatKorisnik(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public TKorisnik deleteKorisnik(@PathVariable("id")Long id){
        return adminService.deleteKorisnik(id);
    }

    @RequestMapping(value = "/agent", method = RequestMethod.POST)
    public TKorisnik addAgent(@RequestBody TAgent agent){
        return adminService.addAgent(agent);
    }
}
