package com.megatravel.search.service;

import com.megatravel.search.dto.FilterDTO;
import com.megatravel.search.model.*;
import com.megatravel.search.repository.AccomodationTypeRepository;
import com.megatravel.search.repository.SmestajRepository;
import com.megatravel.search.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    AccomodationTypeRepository actRepository;

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
    public List<Smestaj> getFilteredSmetaje(FilterDTO filter){

        List<Smestaj> smestaji = smestajRepository.findAllFiltered(filter.getMesto(),filter.getBrojKreveta(),filter.getDateFrom(),filter.getDateTo());
        List<Smestaj> advanced = new ArrayList<>();

        for (Smestaj s: smestaji) {

            boolean flag = true;

            if(!filter.getTip().equals(s.getAccomodationType().getNaziv()) && !filter.getTip().equals("ALL")){
                continue;
            }

            if(!filter.getKategorija().equals(s.getCategory().getNaziv()) && !filter.getKategorija().equals("ALL")){
                continue;
            }

            ArrayList<String> usluge = new ArrayList();

            for (Usluga u : s.getUslugaList()) {
                usluge.add(u.getNaziv());
            }

            for (String str:filter.getUsluge()) {
                if(!usluge.contains(str)){
                    flag = false;
                    break;
                }
            }

            if(flag)
                advanced.add(s);
        }

        return advanced;
    }

    @Override
    public List<String> getUslugeByNaziv(){
        return uslugaRepository.findNazivUsluga();
    }

    @Override
    public List<String> getTypes(){
        List<AccomodationType> list = actRepository.findAll();

        List<String> acts = new ArrayList<>();
        for (AccomodationType a: list) {
            acts.add(a.getNaziv());
        }

        return acts;
    }
}
