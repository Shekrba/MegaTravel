package com.megatravel.agentback.service;

import com.megatravel.agentback.dto.*;
import com.megatravel.agentback.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
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

    public List<UslugaDTO> allServices();

    public void setCategoryForAccomodation(Smestaj smestaj);

    public Rezervacija zauzmiSJedinicu(Long sjedId, Date odDatum, Date doDatum,Long idGlBaza);
    public List<Rezervacija> getRezervacijeSJedinice(Long sjedId);
    public Rezervacija realizovanaRezervacija(Long id);
    public Rezervacija nerealizovanaRezervacija(Long id);

    public List<AccomodationType> getAccTypes();

    public List<Poruka> getSvePoruke();
    public List<Poruka> getNeodgovorenePoruke();
    public Poruka addOdgovor(PorukaDTO porukaDTO, Long idPitanja);
    public Poruka getPoruka(Long id);

    public Cenovnik postaviCenu(CenovnikSJediniceDTO cDTO);

    public boolean uploadImages(Long idSmestaj, MultipartFile[] files) throws IOException;

    List<String> getImages(Long id) throws UnsupportedEncodingException;


}
