package com.megatravel.agentback.repository;


import com.megatravel.agentback.model.Zauzetost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZauzetostRepository extends JpaRepository<Zauzetost, Long> {

    Zauzetost findOneById(Long id);
}
