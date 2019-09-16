package com.megatravel.search.repository;

import com.megatravel.search.model.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType, Long> {
}
