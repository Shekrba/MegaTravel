package com.megatravel.admin.repository;

import com.megatravel.admin.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UslugaRepository  extends JpaRepository<Usluga, Long> {

    Usluga findOneById(Long id);

}
