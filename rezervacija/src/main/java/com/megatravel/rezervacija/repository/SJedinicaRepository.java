package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.SJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Date;
import java.util.List;

@Repository
public interface SJedinicaRepository extends JpaRepository<SJedinica, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    SJedinica findOneById(Long id);

    @Query("SELECT DISTINCT sj FROM SJedinica sj LEFT OUTER JOIN sj.rezervacije r WHERE sj.id=?3 AND ((r.od >=?1 AND r.od <= ?2) OR (r._do >=?1 AND r._do <= ?2))")
    SJedinica findIfTaken(Date dateFrom, Date dateTo, Long id);
}
