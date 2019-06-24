package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.SJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SJedinicaRepository extends JpaRepository<SJedinica, Long> {

    SJedinica findOneById(Long id);
}
