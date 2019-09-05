package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.SJedinica;
import com.megatravel.agentback.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface SJedinicaRepository extends JpaRepository<SJedinica, Long> {

    ArrayList<SJedinica> findBySmestaj(Smestaj smestaj);
    SJedinica findOneById(Long id);

    SJedinica findOneByIdGlBaza(Long idGlBaza);
}
