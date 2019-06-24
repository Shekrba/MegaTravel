package com.megatravel.search.service;

import com.megatravel.search.dto.FilterDTO;
import com.megatravel.search.dto.SJedinicaDTO;
import com.megatravel.search.model.SJedinica;
import com.megatravel.search.model.Smestaj;
import com.megatravel.search.model.Usluga;

import java.util.List;

public interface SearchService {
    public List<Smestaj> getSmesaje();
    public Smestaj getSmestaj(Long id);
    public List<Smestaj> getFilteredSmetaje(FilterDTO filter);
    public List<String> getUslugeByNaziv();
    public List<String> getTypes();
    public List<SJedinicaDTO> getFilteredRooms(Long id, FilterDTO filter);
}
