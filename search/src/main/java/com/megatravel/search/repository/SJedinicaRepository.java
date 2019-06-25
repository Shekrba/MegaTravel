package com.megatravel.search.repository;

import com.megatravel.search.model.SJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SJedinicaRepository extends JpaRepository<SJedinica, Long> {

    @Query("SELECT sj FROM SJedinica sj LEFT OUTER JOIN sj.rezervacije r WHERE (r.od >=?1 AND r.od <= ?2) OR (r._do >=?1 AND r._do <= ?2)")
    List<SJedinica> findAllTaken(Date dateFrom, Date dateTo);

    @Query("SELECT sj FROM SJedinica sj WHERE sj.smestaj.id=?1 AND sj.dostupnost=1")
    List<SJedinica> findAllByHotelId(Long id);
}
