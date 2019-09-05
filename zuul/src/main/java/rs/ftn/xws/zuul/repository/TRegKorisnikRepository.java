package rs.ftn.xws.zuul.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ftn.xws.zuul.model.User;

public interface TRegKorisnikRepository extends JpaRepository<User, Long> {

	@Query(value="SELECT u FROM User u WHERE u.username=?1 AND u.status='ACTIVE'")
	User findByUsername(String username);

	
}
