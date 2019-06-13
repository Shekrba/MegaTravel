package com.megatravel.search.repository;

import com.megatravel.search.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

    List<Smestaj> findAll();
    Smestaj findOneById(Long id);

    @Query("SELECT DISTINCT s FROM Adresa a LEFT OUTER JOIN a.smestaj s LEFT OUTER JOIN s.sJedinica sj LEFT OUTER JOIN sj.rezervacije r WHERE mesto LIKE CONCAT('%',?1,'%') AND sj.brojKreveta >= ?2 AND (?3 <= r.od OR ?3 >= r._do OR r.od IS NULL) AND (?4 <= r.od OR ?4 >= r._do OR r.od IS NULL)")
    List<Smestaj> findAllFiltered(String mesto, Integer brojKreveta, Date dateFrom, Date dateTo);
}
