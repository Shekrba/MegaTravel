package com.megatravel.search.controller;

import com.megatravel.search.dto.*;
import com.megatravel.search.model.*;
import com.megatravel.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api", produces="application/json;charset=UTF-8")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/hotels",method = RequestMethod.GET)
    public List<SmestajDTO> getSmestaje()
    {
        List<Smestaj> list = searchService.getSmesaje();
        List<SmestajDTO> listDTO = new ArrayList<>();

        for (Smestaj s: list) {
            SmestajDTO sDTO = new SmestajDTO();
            smestajToDto(s,sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/hotels",method = RequestMethod.POST)
    public List<SmestajDTO> getFilteredSmestaje(@RequestBody FilterDTO filter){
        List<Smestaj> list = searchService.getFilteredSmetaje(filter);
        List<SmestajDTO> listDTO = new ArrayList<>();

        for (Smestaj s: list) {
            SmestajDTO sDTO = new SmestajDTO();
            smestajToDto(s,sDTO);
            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/hotels/{id}",method = RequestMethod.GET)
    public SmestajDTO getSmestaj(@PathVariable("id")Long id){

        Smestaj smestaj = searchService.getSmestaj(id);
        SmestajDTO smestajDTO = new SmestajDTO();

        smestajToDto(smestaj,smestajDTO);

        return smestajDTO;
    }

    @RequestMapping(value = "/services", method =  RequestMethod.GET)
    public List<String> getUslugeByNaziv(){
        return searchService.getUslugeByNaziv();
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<String> getTypes(){
        return searchService.getTypes();
    }

    public void smestajToDto(Smestaj s, SmestajDTO sDTO){
        sDTO.setId(s.getId());
        sDTO.setNaziv(s.getNaziv());
        sDTO.setOpis(s.getOpis());
        sDTO.setPeriodOtkaza(s.getPeriodOtkaza());
        sDTO.setTip(s.getAccomodationType().getNaziv());
        sDTO.setMesto(s.getAdresa().getMesto());
        sDTO.setBroj(s.getAdresa().getBroj());
        sDTO.setUlica(s.getAdresa().getUlica());

        for (Slika slika: s.getSlike()) {
            sDTO.getSlike().add(slika.getSrc());
        }

        for (Usluga usluga: s.getUslugaList()) {
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
}
