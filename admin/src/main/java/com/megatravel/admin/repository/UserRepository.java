package com.megatravel.admin.repository;

import com.megatravel.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);

    @Query("SELECT u FROM User u WHERE u.status <> 'REMOVED' AND u.enabled = 1")
    List<User> findAllNonRemoved();
}
