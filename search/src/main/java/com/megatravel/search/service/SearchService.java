package com.megatravel.search.service;

import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;

import java.util.List;

public interface SearchService {
    public List<Smestaj> getSmesaje();
    public Smestaj getSmestaj(Long id);
    public List<Usluga> getUsluge(Long id);
    public List<SJedinica> getSJedinice(Long id);
}
