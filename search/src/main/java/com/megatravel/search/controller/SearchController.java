package com.megatravel.search.controller;

import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;
import com.megatravel.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api", produces="application/json;charset=UTF-8")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/hotels",method = RequestMethod.GET)
    public List<Smestaj> getSmestaje(){
        return searchService.getSmesaje();
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
