package boot.mvc.cine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDaoInter extends JpaRepository<MovieDto, Long>{

	
	
}
