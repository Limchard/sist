package spring.mysql.carmember;

import java.util.List;
import java.util.Vector;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfMember");
	}
	
	@Override
	public List<CarMemberDto> getAllData() {
		// TODO Auto-generated method stub	
		return session.selectList("getAllDataOfMember");
	}
	
	@Override
	public void insertMember(CarMemberDto cardto) {
		// TODO Auto-generated method stub
		session.insert("insertAllDataOfMember",cardto);
	}
	
	@Override
	public void deleteMember(String num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfMember", num);
	}
	
	@Override
	public CarMemberDto getOneData(String num) {
		// TODO Auto-generated method stub
		
		return session.selectOne("getOneDataOfMember", num);
	}
	
	@Override
	public void updateMember(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfMember", dto);
	}
	
}
