package com.megatravel.search.controller;

import com.megatravel.search.dto.SmestajDTO;
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
            sDTO.setId(s.getId());
            sDTO.setNaziv(s.getNaziv());
            sDTO.setOpis(s.getOpis());
            sDTO.setPeriodOtkaza(s.getPeriodOtkaza());
            sDTO.setTip(s.getTipSmestaja());
            sDTO.setMesto(s.getAdresa().getMesto());
            sDTO.setBroj(s.getAdresa().getBroj());
            sDTO.setUlica(s.getAdresa().getUlica());
            sDTO.setSlike(new ArrayList<String>());

            for (Slika slika: s.getSlika()) {
                sDTO.getSlike().add(slika.getSrc());
            }

            listDTO.add(sDTO);
        }

        return listDTO;
    }

    @RequestMapping(value = "/hotels/{id}",method = RequestMethod.GET)
    public Smestaj getSmestaj(@PathVariable("id")Long id){
        return searchService.getSmestaj(id);
    }

    @RequestMapping(value = "/services/{id}",method = RequestMethod.GET)
    public List<Usluga> getUsluge(@PathVariable("id")Long id){
        return searchService.getUsluge(id);
    }

    @RequestMapping(value = "/rooms/{id}",method = RequestMethod.GET)
    public List<SJedinica> getSJedinice(Long id){
        return searchService.getSJedinice(id);
    }
}
