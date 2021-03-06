package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenovnikSJediniceRepository extends JpaRepository<Cenovnik, Long> {

    Cenovnik findOneById(Long id);


}
