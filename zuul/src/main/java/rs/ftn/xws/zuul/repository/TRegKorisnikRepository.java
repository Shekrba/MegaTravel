package rs.ftn.xws.zuul.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.xws.zuul.model.TRegKorisnik;

public interface TRegKorisnikRepository extends JpaRepository<TRegKorisnik, Long> {

	
	TRegKorisnik findByUsername(String username);

	
}
