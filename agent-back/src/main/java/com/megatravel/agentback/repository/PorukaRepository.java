package com.megatravel.agentback.repository;


import com.megatravel.agentback.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PorukaRepository extends JpaRepository<Poruka, Long> {

    Poruka findOneById(Long id);
    List<Poruka> findAll();

    @Query("select distinct p from Poruka p where p.statusPoruke='NEODGOVORENO'")
    List<Poruka> findNeodgovorene();
}
