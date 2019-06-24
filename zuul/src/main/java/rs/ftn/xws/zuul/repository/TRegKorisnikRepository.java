package rs.ftn.xws.zuul.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.xws.zuul.model.User;

public interface TRegKorisnikRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);

	
}
