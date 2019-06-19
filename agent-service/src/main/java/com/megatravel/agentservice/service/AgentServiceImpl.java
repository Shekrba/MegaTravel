package com.megatravel.agentservice.service;

import com.megatravel.agentservice.dto.SJedinicaDTO;
import com.megatravel.agentservice.dto.SmestajDTO;
import com.megatravel.agentservice.model.Adresa;
import com.megatravel.agentservice.model.SJedinica;
import com.megatravel.agentservice.model.Smestaj;
import com.megatravel.agentservice.model.Usluga;
import com.megatravel.agentservice.repository.SJedinicaRepository;
import com.megatravel.agentservice.repository.SmestajRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    SJedinicaRepository sjedinicaRepository;



    @Override
    public ArrayList<Smestaj> getSmestaje() {
        ArrayList<Smestaj> ret = smestajRepository.findAll();

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

        sJedinicaNew.setDostupnost(true);
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
        sJedinicaToUpdate.setDostupnost(sjed.getDostupnost());
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
    public ArrayList<Smestaj> deleteSmestaj(Long id) {

        smestajRepository.delete(getSmestaj(id));

        return getSmestaje();
    }

    @Override
    public Smestaj addSmestaj(SmestajDTO smestaj) {

        Smestaj smestajNew = new Smestaj();

        smestajNew.setNaziv(smestaj.getNaziv());
        smestajNew.setAdresa(new Adresa(smestaj.getMesto(), smestaj.getUlica(), smestaj.getBroj()));
        smestajNew.setTipSmestaja(smestaj.getTip());
        smestajNew.setOpis(smestaj.getOpis());
        smestajNew.setPeriodOtkaza(smestaj.getPeriodOtkaza());

        smestajRepository.save(smestajNew);

        return smestajNew;
    }

    @Override
    public Smestaj updateSmestaj(SmestajDTO smestaj) {

        Smestaj smestajUpdate = new Smestaj();

        smestajUpdate.setId(smestaj.getId());
        smestajUpdate.setNaziv(smestaj.getNaziv());
        smestajUpdate.setAdresa(new Adresa(smestaj.getMesto(), smestaj.getUlica(), smestaj.getBroj()));
        smestajUpdate.setOpis(smestaj.getOpis());
        smestajUpdate.setPeriodOtkaza(smestaj.getPeriodOtkaza());
        smestajUpdate.setTipSmestaja(smestaj.getTip());

        smestajRepository.save(smestajUpdate);

        return smestajUpdate;
    }
}
