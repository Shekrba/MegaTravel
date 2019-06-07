package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.model.Rezervacija;
import com.megatravel.rezervacija.model.SJedinica;
import com.megatravel.rezervacija.model.TRegKorisnik;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RezervacijaServiceImpl implements  RezervacijaService {

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

        ArrayList<Rezervacija> rezervacije = new ArrayList<Rezervacija>();

        Rezervacija rez = new Rezervacija();
        rez.setId(new Long(1));
        rez.setKorisnik(new TRegKorisnik());
        rez.setSJedinica(new SJedinica());
        rez.setUCena(2000);

        rezervacije.add(rez);

        return rezervacije;
    }

    @Override
    public Rezervacija getRezervacija(Long id){

        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setId(id);

        return rezervacija;
    }
}
