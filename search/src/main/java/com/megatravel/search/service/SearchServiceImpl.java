package com.megatravel.search.service;

import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;
import com.megatravel.search.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    SmestajRepository smestajRepository;

    @Override
    public List<Smestaj> getSmesaje(){

        List<Smestaj> ret = smestajRepository.findAll();

        return ret;
    }

    @Override
    public Smestaj getSmestaj(Long id) {
        return smestajRepository.findOneById(id);
    }

    @Override
    public List<SJedinica> getSJedinice(Long id){
        return new ArrayList<SJedinica>();
    }
}
