package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);
}
