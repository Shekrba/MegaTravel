package com.megatravel.agent.repository;

import com.megatravel.agent.model.Poruka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PorukaRepository extends JpaRepository<Poruka,Long> {

    @Query(value = "SELECT p FROM Poruka p  WHERE p.primalac.username = :username")
    List<Poruka> findPorukeByUsername(@Param("username")String username);

}
