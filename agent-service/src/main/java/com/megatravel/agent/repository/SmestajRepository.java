package com.megatravel.agent.repository;

import com.megatravel.agent.model.Smestaj;
import com.megatravel.agent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SmestajRepository extends JpaRepository<Smestaj,Long> {



}
