package com.megatravel.agentservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.megatravel.agentservice.client.AgentClient;
import com.megatravel.agentservice.dto.SJedinicaDTO;
import com.megatravel.agentservice.dto.SmestajDTO;
import com.megatravel.agentservice.dto.UslugaDTO;
import com.megatravel.agentservice.model.*;
import com.megatravel.agentservice.service.AgentService;
import generated.GetTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api", produces = "application/json;charset=UTF-8")
public class AgentController {

    @Autowired
    AgentService agentService;

    @Autowired
    AgentClient client;

    @RequestMapping(value = "/hoteli",method = RequestMethod.GET)
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

    @RequestMapping(value = "/hoteli/{id}",method = RequestMethod.GET)
    public SmestajDTO getSmestaj(@PathVariable("id")Long id){

        Smestaj smestaj = agentService.getSmestaj(id);
        SmestajDTO smestajDTO = new SmestajDTO();

        smestajToDto(smestaj,smestajDTO);

        return smestajDTO;
    }

    @RequestMapping(value = "/hoteli/{id}/smestajneJedinice",method = RequestMethod.GET)
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

    @RequestMapping(value = "/smestajneJedinice/{id}",method = RequestMethod.GET)
    public SJedinicaDTO getSJedinica(@PathVariable("id")Long id){

        SJedinica sJedinica = agentService.getSJedinica(id);
        SJedinicaDTO sJedinicaDTO = new SJedinicaDTO();

        sJedinicaToDto(sJedinica,sJedinicaDTO);

        return sJedinicaDTO;
    }

    @RequestMapping(value = "/smestajnaJedinicaAdd/{smestajId}",method = RequestMethod.POST)
    public SJedinica addSJedinica(@PathVariable("smestajId")Long smestajId, @RequestBody SJedinicaDTO sJedinica){

        SJedinica addedSJedinica = null;

        try {
            addedSJedinica = agentService.addSJedinica(sJedinica, smestajId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addedSJedinica;
    }

    @RequestMapping(value = "/smestajnaJedinicaUpdate",method = RequestMethod.PUT)
    public SJedinica updateSJedinica(@RequestBody SJedinicaDTO sJedinica){

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
    public Smestaj addSJedinica(@RequestBody SmestajDTO smestaj){

        Smestaj addedSmestaj = null;

        try {
            addedSmestaj = agentService.addSmestaj(smestaj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addedSmestaj;
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
    public ArrayList<Smestaj> deleteSmestaj(@PathVariable("id")Long id){

        ArrayList<Smestaj> smestaji = agentService.deleteSmestaj(id);

        return smestaji;
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
        sDTO.setTip(s.getTipSmestaja());
        sDTO.setMesto(s.getAdresa().getMesto());
        sDTO.setBroj(s.getAdresa().getBroj());
        sDTO.setUlica(s.getAdresa().getUlica());

        for (Slika slika: s.getSlika()) {
            sDTO.getSlike().add(slika.getSrc());
        }

        for (Usluga usluga: s.getUsluge()) {
            UslugaDTO uslugaDTO = new UslugaDTO();
            uslugaDTO.setId(usluga.getId());
            uslugaDTO.setNaziv(usluga.getNaziv());
            uslugaDTO.setCena(usluga.getCena());
            uslugaDTO.setOpis(usluga.getOpis());

            sDTO.getUsluge().add(uslugaDTO);
        }

        for (SJedinica sj: s.getSJedinica()) {
            SJedinicaDTO sjDTO = new SJedinicaDTO();
            sjDTO.setId(sj.getId());
            sjDTO.setBroj(sj.getBroj());
            sjDTO.setBrojKreveta(sj.getBrojKreveta());
            sjDTO.setCena(sj.getCena());
            sjDTO.setDostupnost(sj.getDostupnost());

            sDTO.getSjedinice().add(sjDTO);
        }
    }

    public void sJedinicaToDto(SJedinica s, SJedinicaDTO sDTO){

        sDTO.setId(s.getId());
        sDTO.setBroj(s.getBroj());
        sDTO.setBrojKreveta(s.getBrojKreveta());
        sDTO.setCena(s.getCena());
        sDTO.setDostupnost(s.getDostupnost());

    }
}
