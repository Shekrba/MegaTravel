package com.megatravel.agentback.controller;


import com.megatravel.agentback.client.AgentClient;
import com.megatravel.agentback.dto.*;
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


    @RequestMapping(value = "/occupancy/{id}",method = RequestMethod.POST)
    public Zauzetost zauzmiSJedinica(@PathVariable("id")Long id, @RequestBody ZauzetostDTO zauzetostDTO){

        Zauzetost z = null;
        LocalDate odDatum = zauzetostDTO.getOdDatum();
        LocalDate doDatum = zauzetostDTO.getDoDatum();
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

    @RequestMapping(value = "/messages",method = RequestMethod.GET)
    public List<PorukaDTO> getSvePoruke()
    {
        List<Poruka> list = agentService.getSvePoruke();
        List<PorukaDTO> listDTO = new ArrayList<>();

        for (Poruka p: list) {
            PorukaDTO pDTO = new PorukaDTO();
            porukaToDto(p,pDTO);
            listDTO.add(pDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/unansweredMessages",method = RequestMethod.GET)
    public List<PorukaDTO> getNeodgovorenePoruke()
    {
        List<Poruka> list = agentService.getNeodgovorenePoruke();
        List<PorukaDTO> listDTO = new ArrayList<>();

        for (Poruka p: list) {
            PorukaDTO pDTO = new PorukaDTO();
            porukaToDto(p,pDTO);
            listDTO.add(pDTO);
        }

        return listDTO;
    }


    @RequestMapping(value = "/answerMessage/{messageId}",method = RequestMethod.POST)
    public ResponseEntity<Poruka> addSJedinica(@PathVariable("messageId")Long messageId, @RequestBody PorukaDTO poruka){

        Poruka addedPoruka = null;

        try {
            addedPoruka = agentService.addOdgovor(poruka, messageId);
            return new ResponseEntity<Poruka>(addedPoruka, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    @RequestMapping(value = "/message/{id}",method = RequestMethod.GET)
    public PorukaDTO getPoruka(@PathVariable("id")Long id)
    {
        Poruka p = agentService.getPoruka(id);

        PorukaDTO porukaDTO = new PorukaDTO();
        porukaToDto(p, porukaDTO);

        return porukaDTO;
    }


    @RequestMapping(value = "/pricelist/{id}",method = RequestMethod.POST)
    public CenovnikSJedinice postaviCenovnikSJedinice(@PathVariable("id")Long id, @RequestBody CenovnikSJediniceDTO cenovnikSJediniceDTO){

        CenovnikSJedinice c = null;
        LocalDate odDatum = cenovnikSJediniceDTO.getDatumOd();
        LocalDate doDatum = cenovnikSJediniceDTO.getDatumDo();
        double cena = cenovnikSJediniceDTO.getCena();
        try {
            c = agentService.postaviCenu(id, odDatum, doDatum, cena);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
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
            sjDTO.setNaziv(sj.getNaziv());
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
        sDTO.setNaziv(s.getNaziv());

    }

    public void porukaToDto(Poruka p, PorukaDTO pDTO) {

        pDTO.setId(p.getId());
        pDTO.setDatumSlanja(p.getDatumSlanja());
        pDTO.setSadrzaj(p.getSadrzaj());
        pDTO.setStatusPoruke(p.getStatusPoruke());
        pDTO.setIdOdgovora(p.getIdOdgovor());
        pDTO.setPosaljilac(p.getPosaljilac());
        pDTO.setPrimalac("Agent");
        pDTO.setNaslov(p.getNaslov());

    }
}
