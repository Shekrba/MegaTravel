package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    List<Smestaj> findAll();
    Smestaj findOneById(Long id);

}
