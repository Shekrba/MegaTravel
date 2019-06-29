package com.megatravel.rezervacija.service;

import com.megatravel.rezervacija.dto.*;
import com.megatravel.rezervacija.model.Poruka;
import com.megatravel.rezervacija.model.Rezervacija;

import java.util.List;

public interface RezervacijaService {

    public Long addRezervacija(MakeResDTO rezervacija);
    public String deleteRezervacija(Long id);
    public List<Rezervacija> getRezervacije();
    public Rezervacija getRezervacija(Long id);
    public List<ReservationDTO>getReservationsToRate(Long user_id);
    public String setRatedTrue(Long id);
    public SmestajDTO formReservation(formDTO form);
    public List<ReservationDTO> getUserReservations(Long userId);
    public String newMessage(PorukaDTO porukaDTO);
    public List<PorukaDTO> getInboxMessages(Long user_id);
    public List<PorukaDTO> getSentMessages(Long user_id);
}
