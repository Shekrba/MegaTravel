package com.megatravel.admin.repository;

import com.megatravel.admin.model.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomentarRepository extends JpaRepository<Komentar, Long> {

    @Query("SELECT k FROM Komentar k where k.odobren = FALSE")
    List<Komentar> findUnapprovedComments();

    Komentar findOneById(Long id);

}
