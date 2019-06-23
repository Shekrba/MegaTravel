package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UslugaRepository extends JpaRepository<Usluga,Long> {
}
