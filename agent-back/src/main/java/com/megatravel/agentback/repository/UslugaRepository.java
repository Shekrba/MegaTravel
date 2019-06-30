package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UslugaRepository extends JpaRepository<Usluga,Long> {

    @Query("select u from Usluga u where u.idGlBaza=?1")
    Usluga findUslugaSaIdGlBaze(Long id);
}
