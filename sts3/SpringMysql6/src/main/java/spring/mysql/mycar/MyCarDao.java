package spring.mysql.mycar;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean에 등록하는것.  
public class MyCarDao {
	// root-context 에서 받는다.
	
	@Autowired
	private SqlSession session; // SqlSession 이라는 Interface가 있고 그걸 가져와서 사용한다고 생각하면 된다. 해당 사항들은 root-context에 
	
	String namespace="spring.mysql.mycar.MyCarDao";
	
	public int getTotalCount() {
		
		return session.selectOne(namespace+".getTotalCountOfMyCar");
//		return session.selectOne("getTotalCountOfMyCar");
//		return session.selectOne("mymycar.getTotalCountOfMyCar"); // 괄호안에는 mapper에서 지정한 id값이 들어간다.
		// 겹칠꺼 같으면 앞에 mapper의 "namespace값."을 앞에 써도 상관없다.
	}
	
	// insert
	public void insertCar(MyCarDto dto) {
		session.insert("insertOfMyCar", dto);
	}
	
	// 전체 목록 출력
	public List<MyCarDto> getAllCars(){	
		return session.selectList("getAllListOfMyCar");
	}
	
	// delete
	public void deleteCar(String num) {
		session.delete("deleteOfMyCar", num);
	}
	
	// update를 위해 항목 찾기
	public MyCarDto getData(String num) {
		
		return session.selectOne("selectOneOfMyCar", num);
	}
	
	// update 하기
	public void updateCar(MyCarDto dto) {
		session.update("updateOfMyCar", dto);
	}
	
		
}
