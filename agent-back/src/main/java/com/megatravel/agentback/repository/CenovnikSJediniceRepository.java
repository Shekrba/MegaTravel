package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.CenovnikSJedinice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenovnikSJediniceRepository extends JpaRepository<CenovnikSJedinice, Long> {

    CenovnikSJedinice findOneById(Long id);


}
