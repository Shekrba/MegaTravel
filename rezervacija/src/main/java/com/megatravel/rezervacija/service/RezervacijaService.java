package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.dto.*;
import com.megatravel.rezervacija.model.Rezervacija;

import java.util.List;

public interface RezervacijaService {

    public String addRezervacija(MakeResDTO rezervacija);
    public Rezervacija deleteRezervacija(Long id);
    public List<Rezervacija> getRezervacije();
    public Rezervacija getRezervacija(Long id);
    public List<ReservationDTO>getReservationsToRate(Long user_id);
    public String setRatedTrue(Long id);
    public SmestajDTO formReservation(formDTO form);
}
