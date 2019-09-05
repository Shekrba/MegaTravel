package com.megatravel.agent.repository;

import com.megatravel.agent.model.SJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface SJedinicaRepository extends JpaRepository<SJedinica,Long> {

    @Query("SELECT DISTINCT sj FROM SJedinica sj LEFT OUTER JOIN sj.rezervacije r WHERE sj.id=?2 AND (r.od >=?1 OR r._do >= ?1) AND r is not empty")
    SJedinica findIfEditable(Date date,Long id);

}
