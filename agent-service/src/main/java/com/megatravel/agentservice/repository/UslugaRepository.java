package com.megatravel.agentservice.repository;

import com.megatravel.agentservice.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UslugaRepository extends JpaRepository<Usluga,Long> {
}
