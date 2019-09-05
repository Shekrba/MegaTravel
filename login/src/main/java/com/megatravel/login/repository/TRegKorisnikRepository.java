package com.megatravel.login.repository;


import com.megatravel.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TRegKorisnikRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT u FROM User u WHERE u.username=?1 AND u.status='ACTIVE'")
	User findByUsername(String username);

	
}
