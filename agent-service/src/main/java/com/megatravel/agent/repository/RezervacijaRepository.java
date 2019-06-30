package com.megatravel.agent.repository;

import com.megatravel.agent.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RezervacijaRepository extends JpaRepository<Rezervacija,Long> {

    @Query(value = "SELECT r FROM Rezervacija r  WHERE r.sJedinica.smestaj.agent.username = :username")
    List<Rezervacija> getAllByUsername(@Param("username")String username);

}
