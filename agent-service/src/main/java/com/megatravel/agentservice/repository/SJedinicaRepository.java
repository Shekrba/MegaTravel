package com.megatravel.agentservice.repository;

import com.megatravel.agentservice.model.SJedinica;
import com.megatravel.agentservice.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashSet;

@Repository
public interface SJedinicaRepository extends JpaRepository<SJedinica, Long> {

    ArrayList<SJedinica> findBySmestaj(Smestaj smestaj);
    SJedinica findOneById(Long id);
}
