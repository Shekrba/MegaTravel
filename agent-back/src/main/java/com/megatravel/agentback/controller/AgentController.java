package com.megatravel.agentback.controller;


import com.megatravel.agentback.client.AgentClient;
import com.megatravel.agentback.dto.RezervacijaDTO;
import com.megatravel.agentback.dto.SJedinicaDTO;
import com.megatravel.agentback.dto.SmestajDTO;
import com.megatravel.agentback.dto.UslugaDTO;
import com.megatravel.agentback.model.*;
import com.megatravel.agentback.service.AgentService;
import generated.GetTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")

public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentClient client;

    @RequestMapping(value = "/accomodations",method = RequestMethod.GET)
    public List<SmestajDTO> getSmestaje()
    {
        List<Smestaj> list = agentService.getSmestaje();
        List<SmestajDTO> listDTO = new ArrayList<>();

        for (Smestaj s: list) {
            SmestajDTO sDTO = new SmestajDTO();
            smestajToDto(s,sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<AccomodationType>  getTypes()
    {
        return agentService.getAccTypes();
    }


    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<UslugaDTO> getServices()
    {
        return agentService.allServices();
    }

    @RequestMapping(value = "/hoteli/{id}",method = RequestMethod.GET)
    public SmestajDTO getSmestaj(@PathVariable("id")Long id){

        Smestaj smestaj = agentService.getSmestaj(id);
        SmestajDTO smestajDTO = new SmestajDTO();

        smestajToDto(smestaj,smestajDTO);

        return smestajDTO;
    }

    @RequestMapping(value = "/accomodationUnits/{id}",method = RequestMethod.GET)
    public List<SJedinicaDTO> getSveSJedinice(@PathVariable("id")Long id)
    {
        List<SJedinica> list = agentService.getSveSJedinice(id);
        List<SJedinicaDTO> listDTO = new ArrayList<>();

        for (SJedinica s: list) {
            SJedinicaDTO sDTO = new SJedinicaDTO();
            sJedinicaToDto(s,sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/accomodationUnit/{id}",method = RequestMethod.GET)
    public SJedinicaDTO getSJedinica(@PathVariable("id")Long id){

        SJedinica sJedinica = agentService.getSJedinica(id);
        SJedinicaDTO sJedinicaDTO = new SJedinicaDTO();

        sJedinicaToDto(sJedinica,sJedinicaDTO);

        return sJedinicaDTO;
    }

    @RequestMapping(value = "/accomodationUnit/{smestajId}",method = RequestMethod.POST)
    public ResponseEntity<SJedinica> addSJedinica(@PathVariable("smestajId")Long smestajId, @RequestBody SJedinicaDTO sJedinica){

        SJedinica addedSJedinica = null;

        try {
            addedSJedinica = agentService.addSJedinica(sJedinica, smestajId);
            return new ResponseEntity<SJedinica>(addedSJedinica, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "/accomodationUnit/{id}",method = RequestMethod.PUT)
    public SJedinica updateSJedinica(@PathVariable("id")Long id, @RequestBody SJedinicaDTO sJedinica){

        SJedinica updatedSJedinica = null;

        try {
            updatedSJedinica = agentService.updateSJedinica(sJedinica);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedSJedinica;
    }

    @RequestMapping(value = "/smestajnaJedinicaDelete/{id}",method = RequestMethod.DELETE)
    public ArrayList<SJedinica> deleteSJedinica(@PathVariable("id")Long id,@PathVariable("smestajId")Long smestajId){

        ArrayList<SJedinica> sJedinice = agentService.deleteSJedinica(id, smestajId);

        return sJedinice;
    }

    @RequestMapping(value = "/smestajAdd",method = RequestMethod.POST)
    public ResponseEntity<Smestaj> addSJedinica(@RequestBody SmestajDTO smestaj){

        Smestaj addedSmestaj = null;

        try {
            addedSmestaj = agentService.addSmestaj(smestaj);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Smestaj>(addedSmestaj,HttpStatus.OK);
    }

    @RequestMapping(value = "/smestajUpdate",method = RequestMethod.PUT)
    public Smestaj updateSmestaj(@RequestBody SmestajDTO smestaj){

        Smestaj updatedSmestaj = null;

        try {
            updatedSmestaj = agentService.updateSmestaj(smestaj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedSmestaj;
    }

    @RequestMapping(value = "/smestajDelete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<List<Smestaj>> deleteSmestaj(@PathVariable("id")Long id){
        List<Smestaj> smestajs = agentService.getSmestaje();
        List<Smestaj> smestaji = agentService.deleteSmestaj(id);
        if(smestaji.size() == smestajs.size())
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        else
            return  new ResponseEntity<List<Smestaj>>(smestaji, HttpStatus.OK);
    }


    @RequestMapping(value = "/occupancy/{id}",method = RequestMethod.POST)
    public Zauzetost zauzmiSJedinica(@PathVariable("id")Long id, @RequestParam("odDatum") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate odDatum, @RequestParam("doDatum") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate doDatum){

        Zauzetost z = null;

        try {
            z = agentService.zauzmiSJedinicu(id, odDatum, doDatum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return z;
    }

    @RequestMapping(value = "/reservations/{id}",method = RequestMethod.GET)
    public List<RezervacijaDTO> getRezervacijeSJedinice(@PathVariable("id")Long id)
    {
        List<Rezervacija> list = agentService.getRezervacijeSJedinice(id);
        List<RezervacijaDTO> listDTO = new ArrayList<>();

        for (Rezervacija r: list) {
            RezervacijaDTO rDTO = new RezervacijaDTO();
            rezervacijaToDto(r,rDTO);
            listDTO.add(rDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/confirmReservation/{id}",method = RequestMethod.PUT)
    public Rezervacija realizovanaRezervacija(@PathVariable("id")Long id)
    {
        Rezervacija r = agentService.realizovanaRezervacija(id);

        return r;
    }

    @RequestMapping(value = "/declineReservation/{id}",method = RequestMethod.PUT)
    public Rezervacija nerealizovanaRezervacija(@PathVariable("id")Long id)
    {
        Rezervacija r = agentService.nerealizovanaRezervacija(id);

        return r;
    }


    public void rezervacijaToDto(Rezervacija r, RezervacijaDTO rDTO) {

        rDTO.setId(r.getId());
        rDTO.setKorisnik(r.getKorisnik());
        rDTO.setuCena(r.getuCena());
        rDTO.setStatusRezervacije(r.getStatusRezervacije());
        rDTO.setDatumRez(r.getDatumRez());
        rDTO.setOd(r.getOd());
        rDTO.set_do(r.get_do());

    }


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public GetTestResponse returnCountryResponse()
    {
        return client.test("test");
    }



    public void smestajToDto(Smestaj s, SmestajDTO sDTO){
        sDTO.setId(s.getId());
        sDTO.setNaziv(s.getNaziv());
        sDTO.setOpis(s.getOpis());
        sDTO.setPeriodOtkaza(s.getPeriodOtkaza());
        sDTO.setMesto(s.getAdresa().getMesto());
        sDTO.setBroj(s.getAdresa().getBroj());
        sDTO.setUlica(s.getAdresa().getUlica());
        sDTO.setLatitude(s.getAdresa().getLatitude());
        sDTO.setLongitude(s.getAdresa().getLongitude());
        sDTO.setPosBroj(s.getAdresa().getPosBroj());

        for (Slika slika: s.getSlika()) {
            sDTO.getSlike().add(slika.getSrc());
        }

        for (Usluga usluga: s.getUslugaList()) {
            UslugaDTO uslugaDTO = new UslugaDTO();
            uslugaDTO.setId(usluga.getId());
            uslugaDTO.setNaziv(usluga.getNaziv());
            uslugaDTO.setCena(usluga.getCena());
            uslugaDTO.setOpis(usluga.getOpis());

            sDTO.getUsluge().add(uslugaDTO);
            sDTO.getAdditionalServices().add(usluga.getId());
        }

        for (SJedinica sj: s.getSJedinica()) {
            SJedinicaDTO sjDTO = new SJedinicaDTO();
            sjDTO.setId(sj.getId());
            sjDTO.setBroj(sj.getBroj());
            sjDTO.setBrojKreveta(sj.getBrojKreveta());
            sjDTO.setCena(sj.getCena());

            sDTO.getSjedinice().add(sjDTO);
        }

        sDTO.setTip(s.getAccomodationType().getId());

    }

    public void sJedinicaToDto(SJedinica s, SJedinicaDTO sDTO){

        sDTO.setId(s.getId());
        sDTO.setBroj(s.getBroj());
        sDTO.setBrojKreveta(s.getBrojKreveta());
        sDTO.setCena(s.getCena());

    }
}
