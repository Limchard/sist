package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") // id가 logic이 된다.
public class LogicController {
	
	@Autowired
	// 정확한 빈의 아이디로 주입_ 모호성이 있는 경우에는 @Resource(name="myDao") 로 명확하게 입력해줘야 한다. 
	DaoInter daoInter;
	
//	public LogicController(MyDao dao) {
//		
//		this.daoInter=dao;
//		
//	}
	
	//insert
	public void insert(String str) {
		daoInter.insertData(str); // 한번 더 받는다.
	}
	
	//delete
	public void delete(String num) {
		daoInter.deleteData(num);
		
		
	}
	
}
