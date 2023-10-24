package boot.mvc.cine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

	@Autowired
	MovieDaoInter inter;
	
	// insert
	public void insertMovie(MovieDto dto) {
		inter.save(dto);
	}
	
	// select
	public List<MovieDto> getAllMovie(){
		return inter.findAll();
	}
	
	// detail page
	public MovieDto getDetail(long num) {
		MovieDto dto=new MovieDto();
		
		return inter.getReferenceById(num);		
	}
	
	
}
