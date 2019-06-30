package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Category;
import com.megatravel.agentback.model.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findOneById(Long id);



}
