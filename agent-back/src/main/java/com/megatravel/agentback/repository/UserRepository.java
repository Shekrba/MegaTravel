package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.smestaji WHERE u.username = :username")
    User fetchAccommodations(@Param("username") String username);
	
}
