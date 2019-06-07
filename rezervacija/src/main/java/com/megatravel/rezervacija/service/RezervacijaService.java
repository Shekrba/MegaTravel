package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.model.Rezervacija;

import java.util.List;

public interface RezervacijaService {

    public Rezervacija addRezervacija(Rezervacija rezervacija);
    public Rezervacija deleteRezervacija(Long id);
    public List<Rezervacija> getRezervacije();
    public Rezervacija getRezervacija(Long id);
}