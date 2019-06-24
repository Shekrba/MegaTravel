package com.megatravel.search.repository;

import com.megatravel.search.model.Smestaj;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    List<Smestaj> findAll();
    Smestaj findOneById(Long id);

    @Query("SELECT DISTINCT s FROM Adresa a LEFT OUTER JOIN a.smestaj s LEFT OUTER JOIN s.sJedinica sj WHERE mesto LIKE CONCAT('%',?1,'%') AND sj.brojKreveta >= ?2 AND sj.dostupnost=1")
    List<Smestaj> findAllFiltered(String mesto, Integer brojKreveta);

}
