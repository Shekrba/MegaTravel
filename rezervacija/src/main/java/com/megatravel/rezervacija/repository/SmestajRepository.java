package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {
    Smestaj findOneById(Long id);
}
