package com.megatravel.agent.repository;


import com.megatravel.agent.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

}
