package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}
