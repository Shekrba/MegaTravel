package com.megatravel.agentback.repository;


import com.megatravel.agentback.model.Mesec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesecRepository extends JpaRepository<Mesec, Long> {


}
