package mycar.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long>{
// 레포지터리 라는거 JpaRepository 는 추상 클래스이다...
	// 골라서 사용 불가능하다.
	// extends 하면..  추상 클래스는 모든 추상메서드들을 무조건 오버라이딩 해야한다.
	// 너무 많아서.. dao에서 extends 해서 가져오는게 아니라 호출(@Autowired)해서 사용한다.
	
}
