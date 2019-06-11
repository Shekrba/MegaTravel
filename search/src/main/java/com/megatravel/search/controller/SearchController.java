package com.megatravel.search.controller;

import com.megatravel.search.dto.SJedinicaDTO;
import com.megatravel.search.dto.SmestajDTO;
import com.megatravel.search.dto.UslugaDTO;
import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Slika;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;
import com.megatravel.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
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

    @RequestMapping(value = "/hotels/{id}",method = RequestMethod.GET)
    public SmestajDTO getSmestaj(@PathVariable("id")Long id){

        Smestaj smestaj = searchService.getSmestaj(id);
        SmestajDTO smestajDTO = new SmestajDTO();

        smestajToDto(smestaj,smestajDTO);

        return smestajDTO;
    }

    @RequestMapping(value = "/rooms/{id}",method = RequestMethod.GET)
    public List<SJedinica> getSJedinice(Long id){
        return searchService.getSJedinice(id);
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
}
