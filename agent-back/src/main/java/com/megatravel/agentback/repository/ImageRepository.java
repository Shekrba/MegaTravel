package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Image findOneById(Long id);
}
