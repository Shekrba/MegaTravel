package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    @Query("SELECT r FROM Rezervacija r WHERE r.canBeRated = 1 AND r.korisnik.id = ?1 And r.rated = 0")
    List<Rezervacija> findAllToRate(Long user_id);

    Rezervacija findOneById(Long id);
}
