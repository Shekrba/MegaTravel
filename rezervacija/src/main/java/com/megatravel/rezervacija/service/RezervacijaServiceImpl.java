package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.dto.*;
import com.megatravel.rezervacija.model.*;
import com.megatravel.rezervacija.repository.RezervacijaRepository;
import com.megatravel.rezervacija.repository.SJedinicaRepository;
import com.megatravel.rezervacija.repository.SmestajRepository;
import com.megatravel.rezervacija.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RezervacijaServiceImpl implements  RezervacijaService {

    @Autowired
    RezervacijaRepository rezervazijaRepository;

    @Autowired
    SmestajRepository smestajRepository;

    @Autowired
    SJedinicaRepository sJedinicaRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public String addRezervacija(MakeResDTO rezervacija){

        Rezervacija rez = new Rezervacija();

        User korisnik = userRepository.findOneById(rezervacija.getKorisnikId());
        SJedinica sjedinica = sJedinicaRepository.findOneById(rezervacija.getSjedinicaId());

        rez.setRated(false);
        rez.setCanBeRated(false);
        rez.setDo(rezervacija.getTo());
        rez.setOd(rezervacija.getFrom());
        rez.setDatumRez(new Date());
        rez.setUCena(rezervacija.getCost());

        rezervazijaRepository.save(rez);

        korisnik.getRezervacija().add(rez);
        rez.setKorisnik(korisnik);

        userRepository.save(korisnik);

        sjedinica.getRezervacije().add(rez);
        rez.setsJedinica(sjedinica);

        sJedinicaRepository.save(sjedinica);

        return "Reservation made";
    }

    @Override
    public Rezervacija deleteRezervacija(Long id){

        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setId(id);

        return rezervacija;
    }

    @Override
    public List<Rezervacija> getRezervacije(){


        return null;
    }

    @Override
    public Rezervacija getRezervacija(Long id){

        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setId(id);

        return rezervacija;
    }

    @Override
    public List<ReservationDTO>getReservationsToRate(Long user_id){
        List<Rezervacija> rez = rezervazijaRepository.findAllToRate(user_id);
        List<ReservationDTO> rezDTO = new ArrayList<>();

        for (Rezervacija r: rez) {
            ReservationDTO rDTO = new ReservationDTO();

            rDTO.setId(r.getId());
            rDTO.setKorisnik_id(r.getKorisnik().getId());
            rDTO.setSmestaj_id(r.getSJedinica().getSmestaj().getId());
            rDTO.setSmestaj_naziv(r.getSJedinica().getSmestaj().getNaziv());
            rDTO.setFrom(r.getOd());
            rDTO.setTo(r.getDo());

            rezDTO.add(rDTO);
        }

        return rezDTO;
    }

    @Override
    public String setRatedTrue(Long id){
        Rezervacija rez = rezervazijaRepository.findOneById(id);

        rez.setRated(true);

        rezervazijaRepository.save(rez);

        return "Update successful";
    }

    @Override
    public SmestajDTO formReservation(formDTO form){
        SmestajDTO smestajDTO = new SmestajDTO();

        Smestaj smestaj = smestajRepository.findOneById(form.getHotelId());
        SJedinica sjedinica = sJedinicaRepository.findOneById(form.getRoomId());

        smestajDTO.setNaziv(smestaj.getNaziv());
        smestajDTO.setId(smestaj.getId());
        smestajDTO.setFrom(form.getFrom());
        smestajDTO.setTo(form.getTo());

        smestajDTO.setServices(new ArrayList<>());

        for (Usluga u: smestaj.getUslugaList()) {
            UslugaDTO uDTO = new UslugaDTO();

            uDTO.setCena(u.getCena());
            uDTO.setId(u.getId());
            uDTO.setNaziv(u.getNaziv());
            uDTO.setOpis(u.getOpis());

            smestajDTO.getServices().add(uDTO);
        }

        smestajDTO.setBrojKreveta(sjedinica.getBrojKreveta());
        smestajDTO.setRoom(sjedinica.getBroj());
        smestajDTO.setRoomId(form.getRoomId());

        Long days = (form.getTo().getTime() - form.getFrom().getTime()) / (1000 * 60 * 60 * 24);
        double cost =  days * sjedinica.getCena();

        System.out.println(cost);

        smestajDTO.setCost(cost);

        return smestajDTO;
    }
}
