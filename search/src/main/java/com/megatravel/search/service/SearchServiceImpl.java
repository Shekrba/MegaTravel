package com.megatravel.search.service;

import com.megatravel.search.dto.FilterDTO;
import com.megatravel.search.dto.SJedinicaDTO;
import com.megatravel.search.model.*;
import com.megatravel.search.repository.*;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    AccomodationTypeRepository actRepository;

    @Autowired
    SJedinicaRepository sJedinicaRepository;

    @Autowired
    UserRepository userRepository;

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

        List<Smestaj> smestaji = smestajRepository.findAllFiltered(filter.getMesto(),filter.getBrojKreveta());
        List<Smestaj> advanced = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = null;
        Date dateTo = null;
        if(filter.getDateTo() != null && filter.getDateFrom() != null) {
            try {
                dateFrom = format.parse(filter.getDateFrom());
                dateTo = format.parse(filter.getDateTo());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<SJedinica> takens = sJedinicaRepository.findAllTaken(dateFrom,dateTo);

        for (Smestaj s: smestaji) {

            boolean flag = true;

            List<SJedinica> newSJ = new ArrayList<>();

            for (SJedinica sj: s.getSJedinica()) {
                boolean f = true;
                for (SJedinica t: takens) {
                    if (t.getSmestaj().getId() == s.getId() && sj.getId() == t.getId()) {
                        f = false;
                        break;
                    }
                }
                if(f){
                    newSJ.add(sj);
                }
            }

            if(newSJ.size()==0){
                continue;
            }
            s.setsJedinica(newSJ);

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
    public List<SJedinicaDTO> getFilteredRooms(Long id, FilterDTO filter){

        List<SJedinica> sjedinice = sJedinicaRepository.findAllByHotelId(id);
        List<SJedinicaDTO> ret = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = null;
        Date dateTo = null;
        if(filter.getDateTo() != null && filter.getDateFrom() != null) {
            try {
                dateFrom = format.parse(filter.getDateFrom());
                dateTo = format.parse(filter.getDateTo());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<SJedinica> takens = sJedinicaRepository.findAllTaken(dateFrom,dateTo);

        for (SJedinica sj: sjedinice) {
            boolean f = true;
            for (SJedinica t: takens) {
                if (t.getSmestaj().getId() == id && sj.getId() == t.getId()) {
                    f = false;
                    break;
                }
            }
            if(f){
                SJedinicaDTO sjDTO = new SJedinicaDTO();
                sjDTO.setId(sj.getId());
                sjDTO.setDostupnost(sj.getDostupnost());
                sjDTO.setBroj(sj.getBroj());
                sjDTO.setCena(sj.getCena());
                sjDTO.setBrojKreveta(sj.getBrojKreveta());
                sjDTO.setVersion(sj.getVersion());
                ret.add(sjDTO);
            }
        }

        return ret;
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

    @Override
    public String getUsername(Long id){
        return userRepository.getOne(id).getUsername();
    }

    @Override
    public String getSmestajNaziv(Long id){
        return smestajRepository.getOne(id).getNaziv();
    }
}
