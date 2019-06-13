package com.megatravel.search.repository;

import com.megatravel.search.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UslugaRepository extends JpaRepository<Usluga, String> {

    @Query("SELECT DISTINCT u.naziv FROM Usluga u")
    List<String> findNazivUsluga();
}
