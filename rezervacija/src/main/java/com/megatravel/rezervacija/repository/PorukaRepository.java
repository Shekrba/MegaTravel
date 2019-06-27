package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long> {

    @Query("SELECT p FROM Poruka p WHERE p.primalac.id=?1")
    List<Poruka> findInbox(Long userId);

    @Query("SELECT p FROM Poruka p WHERE p.posiljalac.id=?1")
    List<Poruka> findSent(Long userId);
}
