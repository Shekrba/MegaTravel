package com.megatravel.admin.repository;

import com.megatravel.admin.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {

    Category findOneById(Long id);

}
