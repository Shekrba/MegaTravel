package com.megatravel.agent.repository;


import com.megatravel.agent.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);

	
}
