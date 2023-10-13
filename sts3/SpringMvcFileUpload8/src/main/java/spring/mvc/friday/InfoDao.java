package spring.mvc.friday;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InfoDao implements InfoInter {

	// sql팩토리로부터 만들어지는 sqlSession을 가지고 온다.
	@Autowired
	SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("selectTotalCountOfMyInfo");
	}
	
	@Override
	public void insertMyInfo(InfoDto idto) {
		// TODO Auto-generated method stub
		session.insert("insertOfMyInfo", idto);
	}
	
	@Override
	public List<InfoDto> getAllDataOfMyInfo() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfMyInfo");
	}
	
	@Override
	public InfoDto getData(String num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfMyInfo", num);
	}
	
	@Override
	public void updateMyInfo(InfoDto idto) {
		// TODO Auto-generated method stub
		session.update("updateOfMyInfo", idto);
	}
	
	@Override
	public void deleteInfo(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfMyInfo", num);
	}
	
}
