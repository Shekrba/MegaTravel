package com.megatravel.search.service;

import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Override
    public List<Smestaj> getSmesaje(){
        return new ArrayList<Smestaj>();
    }

    @Override
    public Smestaj getSmestaj(Long id){
        return new Smestaj();
    }

    @Override
    public List<Usluga> getUsluge(Long id){
        return new ArrayList<Usluga>();
    }

    @Override
    public List<SJedinica> getSJedinice(Long id){
        return new ArrayList<SJedinica>();
    }
}
