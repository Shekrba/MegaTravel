package com.megatravel.admin.repository;

import com.megatravel.admin.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findOneByName(String name);

}
