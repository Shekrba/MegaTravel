package rs.ftn.xws.zuul.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.xws.zuul.model.TRegKorisnik;

public interface TRegKorisnikRepository extends JpaRepository<TRegKorisnik, Long> {

	
	TRegKorisnik findByUsername(String username);
	

	
	/*@Query("SELECT k FROM Korisnik k JOIN FETCH Zahtev z ON k.id=z.salje_id WHERE k.username=?1")
	List<Korisnik> findSentRequests(String username);*/
	
	
}
