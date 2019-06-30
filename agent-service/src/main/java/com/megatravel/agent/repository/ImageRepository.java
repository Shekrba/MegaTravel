package com.megatravel.agent.repository;

import com.megatravel.agent.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
