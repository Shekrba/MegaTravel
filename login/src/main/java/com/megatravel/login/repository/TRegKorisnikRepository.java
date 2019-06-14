package com.megatravel.login.repository;


import com.megatravel.login.model.TRegKorisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRegKorisnikRepository extends JpaRepository<TRegKorisnik, Long> {

	
	TRegKorisnik findByUsername(String username);

	
}
