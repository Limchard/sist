package answer.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository 
public class AnswerDao implements AnswerDaoInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public void insertAnswer(AnswerDto adto) {
		// TODO Auto-generated method stub
		session.insert("insertOfReanswer", adto);
	}
	
	
	@Override
	public List<AnswerDto> getAnswerList(int num) {
		// TODO Auto-generated method stub
		return session.selectList("selectNumOfReanswer", num);
	}
	
	@Override
	public int checkPassAnswer(int idx, String pass) {
		// TODO Auto-generated method stub
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("pass", pass);
		
		return session.selectOne("checkEqulPassOfReanswer", map);
	}
	
	@Override
	public void deleteAnswer(int idx) {
		// TODO Auto-generated method stub
		session.delete("deleteOfReanswer", idx);
	}
	
	
}
