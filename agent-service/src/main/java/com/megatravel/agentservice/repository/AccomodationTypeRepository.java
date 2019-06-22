package com.megatravel.agentservice.repository;

import com.megatravel.agentservice.model.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType, Long> {

    AccomodationType findOneById(Long id);

}
