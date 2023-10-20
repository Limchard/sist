package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository // dao를 bean에 등록
//public class MyCarDao implements MyCarDaoInter { // 상속을 수십개를 받아야 하기 때문에 implements 없애준다.
public class MyCarDao {

	@Autowired
	MyCarDaoInter carInter;
	
	// insert
	public void insertMyCar(MyCarDto dto) {
		
		carInter.save(dto); // insert를 save라고 한다. update도 save라고 한다.
		// id type의 유,무에 따라 insert와 update가 자동으로 갈린다... 
		// insert는 auto_increment로 id가 추가되고(id값을 모르는 상태), update는 원래 있는 id를 기준으로(id를 알고있는 상태) 변경하기에 구분 해준다.
		
	}
	
	// select
	public List<MyCarDto> getAllData(){
		
		return carInter.findAll();
	}
	
	// update하기
	// num에 대한 값(dto) 반환
	public MyCarDto getData(long num) {
		
		// return carInter.getById(num); // 디플리케이트?
		return carInter.getReferenceById(num);
	}
	
	// update
	public void updateCar(MyCarDto dto) { // insert와 동일하므로, insert로 사용해도 무관함
		
		carInter.save(dto);
		
	}
	
	// delete
	public void deleteCar(long num) {
		carInter.deleteById(num);
	}
	
	
}
