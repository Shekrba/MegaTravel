package com.megatravel.search.repository;

import com.megatravel.search.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findOneById(Long id);
}
