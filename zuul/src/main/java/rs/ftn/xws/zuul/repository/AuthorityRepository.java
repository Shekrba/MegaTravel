package rs.ftn.xws.zuul.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import rs.ftn.xws.zuul.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	
}
