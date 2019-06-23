package com.megatravel.login.repository;


import com.megatravel.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRegKorisnikRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);

	
}
