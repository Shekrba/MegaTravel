package com.megatravel.admin.repository;

import com.megatravel.admin.model.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType,Long> {
    AccomodationType findOneById(Long id);
}
