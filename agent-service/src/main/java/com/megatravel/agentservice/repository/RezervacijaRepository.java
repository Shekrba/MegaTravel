package com.megatravel.agentservice.repository;


import com.megatravel.agentservice.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    Rezervacija findOneById(Long id);

    @Query("select distinct r from Rezervacija r where r.sJedinica.id=?1")
    List<Rezervacija> findSveRezervacijeSJedinice(Long sjedId);
}