package com.megatravel.admin.repository;

import com.megatravel.admin.model.Smestaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Long> {

}
