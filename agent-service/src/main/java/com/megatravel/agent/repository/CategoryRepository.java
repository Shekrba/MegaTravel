package com.megatravel.agent.repository;

import com.megatravel.agent.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
