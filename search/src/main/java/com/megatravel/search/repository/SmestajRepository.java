package com.megatravel.search.repository;

import com.megatravel.search.model.Smestaj;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    List<Smestaj> findAll();
}
