package com.megatravel.agentback.repository;

import com.megatravel.agentback.model.AccomodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccomodationTypeRepository extends JpaRepository<AccomodationType, Long> {

    AccomodationType findOneById(Long id);

}
