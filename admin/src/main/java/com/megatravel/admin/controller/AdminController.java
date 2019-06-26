package com.megatravel.admin.controller;

import com.megatravel.admin.dto.*;
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

    @RequestMapping(value = "/services/{id}", method = RequestMethod.GET)
    public UslugaDTO getUsluga(@PathVariable("id") Long id) {
        return adminService.getUsluga(id);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<Usluga> getUsluge(){
        return adminService.getUsluge();
    }



    @RequestMapping(value="/accomodation", method = RequestMethod.POST)
    public Smestaj addAccomodation(@RequestBody SmestajDTO smestaj)
    {
        return adminService.addAccomodation(smestaj);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public UserDTO blockKorisnik(@PathVariable("id")Long id){
        adminService.blockKorisnik(id);
        return new UserDTO();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public UserDTO activateKorisnik(@PathVariable("id")Long id){
        adminService.activateKorisnik(id);
        return new UserDTO();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public UserDTO deleteKorisnik(@PathVariable("id")Long id){
        adminService.deleteKorisnik(id);
        return new UserDTO();
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<UserDTO> getKorisnike(){
        return adminService.getKorisnike();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUsername(@PathVariable("id")Long id){
        return adminService.getUsername(id);
    }

    @RequestMapping(value = "/accommodation/{id}", method = RequestMethod.GET)
    public String getSmestjNaziv(@PathVariable("id")Long id){
        return adminService.getSmestajNaziv(id);
    }

    @RequestMapping(value = "/agent", method = RequestMethod.POST)
    public User addAgent(@RequestBody AgentDTO agent){
        return adminService.addAgent(agent);
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<AccTypeDTO> getAccTypes()
    {
        return adminService.getAccomodationTypes();
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public AccTypeDTO addAccomodationType(@RequestBody AccTypeDTO accTypeDTO){
        return adminService.addAcomodationType(accTypeDTO);
    }

    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAccomodationType(@PathVariable("id")Long id){
        try {
            String message = adminService.deleteType(id);
            return new ResponseEntity<String>(message, HttpStatus.OK);
        }catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AdminDTO addAdmin(@RequestBody AdminDTO adminDTO)
    {
        return adminService.addAdmin(adminDTO);
    }

}


