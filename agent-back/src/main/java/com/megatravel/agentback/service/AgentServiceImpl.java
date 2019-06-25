package com.megatravel.agentback.service;

import com.megatravel.agentback.dto.PorukaDTO;
import com.megatravel.agentback.dto.SJedinicaDTO;
import com.megatravel.agentback.dto.SmestajDTO;
import com.megatravel.agentback.dto.UslugaDTO;
import com.megatravel.agentback.model.*;
import com.megatravel.agentback.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    SJedinicaRepository sjedinicaRepository;

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RezervacijaRepository rezervacijaRepository;

    @Autowired
    ZauzetostRepository zauzetostRepository;

    @Autowired
    AccomodationTypeRepository accomodationTypeRepository;

    @Autowired
    PorukaRepository porukaRepository;

    @Autowired
    CenovnikSJediniceRepository cenovnikSJediniceRepository;

    @Override
    public List<Smestaj> getSmestaje() {
        List<Smestaj> ret = smestajRepository.findAll();

        return ret;
    }

    @Override
    public Smestaj getSmestaj(Long id) {
        return smestajRepository.findOneById(id);
    }

    @Override
    public ArrayList<SJedinica> getSveSJedinice(Long smestajId) {

        Smestaj smestaj = smestajRepository.findOneById(smestajId);
        return sjedinicaRepository.findBySmestaj(smestaj);
    }

    @Override
    public SJedinica addSJedinica(SJedinicaDTO sjed, Long smestajId) {

        SJedinica sJedinicaNew = new SJedinica();


        sJedinicaNew.setBroj(sjed.getBroj());
        sJedinicaNew.setBrojKreveta(sjed.getBrojKreveta());
        sJedinicaNew.setCena(sjed.getCena());

        Smestaj smestaj = smestajRepository.findOneById(smestajId);

        sJedinicaNew.setSmestaj(smestaj);

        sjedinicaRepository.save(sJedinicaNew);

        return sJedinicaNew;
    }

    @Override
    public SJedinica updateSJedinica(SJedinicaDTO sjed) {

        SJedinica sJedinicaToUpdate = new SJedinica();

        sJedinicaToUpdate.setId(sjed.getId());
        sJedinicaToUpdate.setBroj(sjed.getBroj());

        sJedinicaToUpdate.setBrojKreveta(sjed.getBrojKreveta());
        sJedinicaToUpdate.setCena(sjed.getCena());


        Smestaj smestaj = getSJedinica(sjed.getId()).getSmestaj();

        sJedinicaToUpdate.setSmestaj(smestaj);
        //sJedinicaToUpdate.setSmestaj(new Smestaj(smestaj.getId(),smestaj.getNaziv(),smestaj.getAdresa(),smestaj.getOpis(),new ArrayList<SJedinica>(),new ArrayList<Usluga>(), smestaj.getPeriodOtkaza(), smestaj.getTipSmestaja(), smestaj.getKategorija(), smestaj.getSlika()));

        sjedinicaRepository.save(sJedinicaToUpdate);

        return sJedinicaToUpdate;
    }

    @Override
    public SJedinica getSJedinica(Long id) {
        return sjedinicaRepository.findOneById(id);
    }

    @Override
    public ArrayList<SJedinica> deleteSJedinica(Long id, Long smestajId) {

        sjedinicaRepository.delete(getSJedinica(id));

        return getSveSJedinice(smestajId);
    }

    @Override
    public List<Smestaj> deleteSmestaj(Long id) {
        Smestaj smestaj = getSmestaj(id);
        if(smestaj.getSJedinica().size() > 0)
        {
            return getSmestaje();
        }
        smestajRepository.delete(getSmestaj(id));

        return getSmestaje();
    }

    @Override
    public List<UslugaDTO> allServices() {
        List<Usluga> uslugaList = uslugaRepository.findAll();
        List<UslugaDTO> uslugaDTOS = new ArrayList<>();
        for(Usluga usluga : uslugaList)
        {
            UslugaDTO dto = new UslugaDTO();
            dto.setId(usluga.getId());
            dto.setNaziv(usluga.getNaziv());
            uslugaDTOS.add(dto);
        }
        return uslugaDTOS;
    }

    @Override
    public Smestaj addSmestaj(SmestajDTO smestaj) {

        Smestaj smestajNew = new Smestaj();

        smestajNew.setNaziv(smestaj.getNaziv());
        Adresa adresa = new Adresa(smestaj.getMesto(), smestaj.getUlica(), smestaj.getBroj());
        adresa.setLatitude(smestaj.getLatitude());
        adresa.setLongitude(smestaj.getLongitude());
        adresa.setPosBroj(smestaj.getPosBroj());
        smestajNew.setAdresa(adresa);

        smestajNew.setOpis(smestaj.getOpis());
        smestajNew.setPeriodOtkaza(smestaj.getPeriodOtkaza());

        smestajNew.setAccomodationType(accomodationTypeRepository.findOneById(smestaj.getTip()));

        List<Usluga> uslugaList = uslugaRepository.findAllById(smestaj.getAdditionalServices());
        smestajNew.setUslugaList(uslugaList);
        setCategoryForAccomodation(smestajNew);
        smestajRepository.save(smestajNew);

        return smestajNew;
    }

    @Override
    public Smestaj updateSmestaj(SmestajDTO smestaj) {


        Smestaj smestajUpdate = smestajRepository.findOneById(smestaj.getId());

        smestajUpdate.setId(smestaj.getId());
        smestajUpdate.setNaziv(smestaj.getNaziv());

        Adresa adresa = new Adresa(smestaj.getMesto(), smestaj.getUlica(), smestaj.getBroj());
        adresa.setId(smestajUpdate.getAdresa().getId());
        adresa.setLongitude(smestaj.getLongitude());
        adresa.setLatitude(smestaj.getLatitude());
        adresa.setPosBroj(smestaj.getPosBroj());

        smestajUpdate.setAdresa(adresa);
        smestajUpdate.setOpis(smestaj.getOpis());
        smestajUpdate.setPeriodOtkaza(smestaj.getPeriodOtkaza());

        smestajUpdate.setAccomodationType(accomodationTypeRepository.findOneById(smestaj.getTip()));

        List<Usluga> uslugaList = uslugaRepository.findAllById(smestaj.getAdditionalServices());
        smestajUpdate.setUslugaList(uslugaList);
        setCategoryForAccomodation(smestajUpdate);
        smestajRepository.save(smestajUpdate);

        return smestajUpdate;
    }

    @Override
    public void setCategoryForAccomodation(Smestaj smestaj) {
        List<Category> categories = categoryRepository.findAll();
        List<Category> foundCategories = new ArrayList<>();
        for(Category category: categories)
        {
            List<Usluga> categoryServices = category.getUslugaList();
            List<Usluga> accomodationServices = smestaj.getUslugaList();
            if(accomodationServices.size() >= categoryServices.size())
            {
                boolean isOk = true;
                if(categoryServices.size() == 0)
                    isOk = false;
                for(Usluga categoryService : categoryServices)
                {

                    boolean foundService = false;
                    for(Usluga accomodationService : accomodationServices)
                    {
                        if(accomodationService.getId() == categoryService.getId()) {
                            foundService = true;
                            break;
                        }
                    }
                    if(!foundService) {
                        isOk = false;
                        break;
                    }
                }
                if(isOk)
                    foundCategories.add(category);
            }
        }
        if(foundCategories.size() > 0){
            smestaj.setCategory(foundCategories.get(0));
            for(Category category : foundCategories){
                if(category.getVrednost() > smestaj.getCategory().getVrednost())
                    smestaj.setCategory(category);
            }
        }
        else
        {
            smestaj.setCategory(null);
        }
    }

    @Override
    public Zauzetost zauzmiSJedinicu(Long sjedId, LocalDate odDatum, LocalDate doDatum) {

        Zauzetost z = new Zauzetost();
        z.setsJedinica(sjedinicaRepository.findOneById(sjedId));
        z.setDatumOd(odDatum);
        z.setDatumDo(doDatum);

        zauzetostRepository.save(z);

        return z;
    }

    @Override
    public List<Rezervacija> getRezervacijeSJedinice(Long sjedId) {

        List<Rezervacija> rezervacijaList = rezervacijaRepository.findSveRezervacijeSJedinice(sjedId);

        return rezervacijaList;
    }

    @Override
    public Rezervacija realizovanaRezervacija(Long id) {

        Rezervacija r = rezervacijaRepository.findOneById(id);
        r.setStatusRezervacije(StatusRezervacije.REALIZOVANA);

        rezervacijaRepository.save(r);

        return r;
    }

    @Override
    public Rezervacija nerealizovanaRezervacija(Long id) {

        Rezervacija r = rezervacijaRepository.findOneById(id);
        r.setStatusRezervacije(StatusRezervacije.NEREALIZOVANA);

        rezervacijaRepository.save(r);

        return r;
    }

    @Override
    public List<AccomodationType> getAccTypes() {
        return accomodationTypeRepository.findAll();
    }

    @Override
    public List<Poruka> getSvePoruke() {
        return porukaRepository.findAll();
    }

    @Override
    public List<Poruka> getNeodgovorenePoruke() {
        return porukaRepository.findNeodgovorene();
    }

    @Override
    public Poruka addOdgovor(PorukaDTO porukaDTO, Long idPitanja) {

        Poruka p = new Poruka();

        p.setId(porukaDTO.getId());
        p.setDatumSlanja(LocalDate.now());
        p.setSadrzaj(porukaDTO.getSadrzaj());
        p.setPosaljilac("Agent");
        p.setStatusPoruke(StatusPoruke.ODGOVOR);
        p.setIdOdgovor(null);

        Poruka p1 = porukaRepository.findOneById(idPitanja);
        p1.setStatusPoruke(StatusPoruke.ODGOVORENO);
        p1.setIdOdgovor(porukaDTO.getId());

        p.setPrimalac(p1.getPosaljilac());
        p.setNaslov("RE:" + p1.getNaslov());

        porukaRepository.save(p1);

        porukaRepository.save(p);



        return p;
    }

    @Override
    public Poruka getPoruka(Long id) {
        return porukaRepository.findOneById(id);
    }

    @Override
    public CenovnikSJedinice postaviCenu(Long sjedId, LocalDate odDatum, LocalDate doDatum, double cena) {

        CenovnikSJedinice c = new CenovnikSJedinice();
        c.setsJedinica(sjedinicaRepository.findOneById(sjedId));
        c.setDatumDo(doDatum);
        c.setDatumOd(odDatum);
        c.setCena(cena);

        cenovnikSJediniceRepository.save(c);

        return c;
    }
}
