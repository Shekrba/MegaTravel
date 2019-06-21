package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.dto.ReservationDTO;
import com.megatravel.rezervacija.model.Rezervacija;
import com.megatravel.rezervacija.model.SJedinica;
import com.megatravel.rezervacija.model.User;
import com.megatravel.rezervacija.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RezervacijaServiceImpl implements  RezervacijaService {

    @Autowired
    RezervacijaRepository rezervazijaRepository;

    @Override
    public Rezervacija addRezervacija(Rezervacija rezervacija){

        return rezervacija;
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
}
