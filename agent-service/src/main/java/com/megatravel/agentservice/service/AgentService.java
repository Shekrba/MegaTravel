package com.megatravel.agentservice.service;

import com.megatravel.agentservice.dto.SJedinicaDTO;
import com.megatravel.agentservice.dto.SmestajDTO;
import com.megatravel.agentservice.dto.UslugaDTO;
import com.megatravel.agentservice.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public interface AgentService {

    public List<Smestaj> getSmestaje();
    public Smestaj getSmestaj(Long id);
    public ArrayList<SJedinica> getSveSJedinice(Long smestajId);
    public SJedinica getSJedinica(Long id);
    public Smestaj addSmestaj(SmestajDTO smestaj);
    public Smestaj updateSmestaj(SmestajDTO smestaj);
    public SJedinica addSJedinica(SJedinicaDTO sjed, Long smestajId);
    public SJedinica updateSJedinica(SJedinicaDTO sjed);
    public ArrayList<SJedinica> deleteSJedinica(Long id, Long smestajId);
    public List<Smestaj> deleteSmestaj(Long id);

    public List<UslugaDTO> allServices();

    public void setCategoryForAccomodation(Smestaj smestaj);

    public Zauzetost zauzmiSJedinicu(Long sjedId, LocalDate odDatum, LocalDate doDatum);
    public List<Rezervacija> getRezervacijeSJedinice(Long sjedId);
    public Rezervacija realizovanaRezervacija(Long id);
    public Rezervacija nerealizovanaRezervacija(Long id);

    public List<AccomodationType> getAccTypes();


}
