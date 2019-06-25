package com.megatravel.rezervacija.repository;

import com.megatravel.rezervacija.model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {
}
