package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.Rezervacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    @Query("SELECT r FROM Rezervacija r WHERE r.canBeRated = 1 AND r.korisnik.id = ?1 And r.rated = 0 AND r.canceled=0")
    List<Rezervacija> findAllToRate(Long user_id);

    @Lock(LockModeType.PESSIMISTIC_READ)
    Rezervacija findOneById(Long id);

    @Query("SELECT r FROM Rezervacija r WHERE r.korisnik.id=?1 AND r.canceled=0")
    List<Rezervacija> findUserReservations(Long id);
}
