package com.megatravel.search.repository;

import com.megatravel.search.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    List<Smestaj> findAll();
    Smestaj findOneById(Long id);
}
