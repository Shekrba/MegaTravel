package com.megatravel.admin.repository;

import com.megatravel.admin.model.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType,Long> {
    AccomodationType findOneById(Long id);

    @Query("SELECT a from AccomodationType a LEFT OUTER JOIN a.smestajList s WHERE s.id IS NULL")
    List<AccomodationType> findAllNonSmestaj();
}
