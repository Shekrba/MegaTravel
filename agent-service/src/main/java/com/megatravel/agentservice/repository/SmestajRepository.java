package com.megatravel.agentservice.repository;

import com.megatravel.agentservice.model.Smestaj;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    ArrayList<Smestaj> findAll();
    Smestaj findOneById(Long id);

}
