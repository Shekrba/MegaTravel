package com.megatravel.admin.service;

import com.megatravel.admin.dto.AgentDTO;
import com.megatravel.admin.dto.SmestajDTO;
import com.megatravel.admin.dto.UslugaDTO;
import com.megatravel.admin.model.*;
import com.megatravel.admin.repository.KomentarRepository;
import com.megatravel.admin.repository.SmestajRepository;
import com.megatravel.admin.repository.UserRepository;
import com.megatravel.admin.repository.UslugaRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements  AdminService{

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    KomentarRepository komentarRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SmestajRepository smestajRepository;

    @Override
    public List<Usluga> getUsluge() {
        return uslugaRepository.findAll();
    }

    @Override
    public Usluga addUsluga(UslugaDTO usluga){
        Usluga saveUsluga = new Usluga();
        saveUsluga.setCena(usluga.getCena());
        saveUsluga.setNaziv(usluga.getNaziv());
        saveUsluga.setOpis(usluga.getOpis());
        return uslugaRepository.save(saveUsluga);
    }

    @Override
    public String deleteUsluga(Long id){
        uslugaRepository.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public Usluga updateUsluga(UslugaDTO usluga, Long id){
        Usluga updateUsluga = uslugaRepository.findOneById(id);
        updateUsluga.setCena(usluga.getCena());
        updateUsluga.setNaziv(usluga.getNaziv());
        updateUsluga.setOpis(usluga.getOpis());
        return uslugaRepository.save(updateUsluga);
    }


    @Override
    public SJedinica setTip(Long id, TTipSmestaja tip){
        return new SJedinica();
    }

    @Override
    public Komentar odobriKomentar(Long id){
        Komentar komentar = komentarRepository.findOneById(id);
        komentar.setOdobren(true);
        return komentarRepository.save(komentar);
    }

    @Override
    public List<Komentar> getUnapprovedComments() {
        return komentarRepository.findUnapprovedComments();
    }

    @Override
    public User blockKorisnik(Long id){
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.BLOCKED);
        return userRepository.save(user);
    }

    @Override
    public User activateKorisnik(Long id){
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User deleteKorisnik(Long id) {
        User user = userRepository.findOneById(id);
        user.setStatus(UserStatus.REMOVED);
        return userRepository.save(user);
    }

    @Override
    public User addAgent(AgentDTO agent){
        User newUser = new User();
        newUser.setAdresa(agent.getAdresa());
        newUser.setStatus(UserStatus.ACTIVE);
        newUser.setIme(agent.getIme());
        newUser.setPosMatBroj(agent.getPosMatBroj());
        newUser.setPrezime(agent.getPrezime());
        newUser.setRole(UserType.AGENT);
        return userRepository.save(newUser);
    }

    @Override
    public Smestaj addAccomodation(SmestajDTO smestaj) {
        Smestaj accomodation = new Smestaj();
        accomodation.setNaziv(smestaj.getNaziv());
        accomodation.setAdresa(smestaj.getAdresa());
        accomodation.setOpis(smestaj.getOpis());
        accomodation.setTipSmestaja(smestaj.getTipSmestaja());
        accomodation.setPeriodOtkaza(smestaj.getPeriodOtkaza());
        List<Usluga> uslugaList = uslugaRepository.findAllById(smestaj.getAdditionalServices());
        accomodation.setUsluge(uslugaList);
        return smestajRepository.save(accomodation);
    }
}
