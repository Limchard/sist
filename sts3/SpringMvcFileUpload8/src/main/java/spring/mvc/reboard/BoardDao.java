package spring.mvc.reboard;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // bean에 등록
public class BoardDao implements BoardDaoInter {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfReboard");
	}
	
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return session.selectOne("maxNumOfReboard");
	}
	
	@Override
	public void updateRestep(int regroup, int restep) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		// int를 integer(ref class)로 써야 합니다.
		map.put("regroup", regroup);
		map.put("restep", restep);
		session.update("updateStepOfReboard", map);
	}
	
	@Override
	public void insertReboard(BoardDto bdto) {
		// TODO Auto-generated method stub
		int num=bdto.getNum();
		int regroup=bdto.getRegroup();
		int restep=bdto.getRestep();
		int relevel=bdto.getRelevel();
			
		if(num==0) { // 새글
			regroup=getMaxNum()+1;
			restep=0;
			relevel=0;
		} else { // 답글
			// 같은 그룹중 전달받은 restep보다 큰 글들은 모두 +1 해준다.
			this.updateRestep(regroup, restep);
			
			// 전달받은 step과 level 모두 +1
			restep++;
			relevel++;
		}
		
		// 바뀐 값들을 다시 dto에 담아줘야 합니다.
		bdto.setRegroup(regroup);
		bdto.setRestep(restep);
		bdto.setRelevel(relevel);
		
		// insert
		session.insert("insertOfReboard", bdto);
		
	}
	
	@Override
	public List<BoardDto> getPagingList(int start, int perpage) {
		
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		
		return session.selectList("selectPagingOfReboard", map);
	}
	
	
	@Override
	public BoardDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("getDataOfReboard", num);
	}
	
	@Override
	public void updateReadCount(int num) {
		
		session.update("plusReadCountOfReboard", num);
	}
	
	@Override
	public int getCheckPass(int num, int pass) {
		// TODO Auto-generated method stub
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("num", num);
		map.put("pass", pass);
		
		return session.selectOne("checkPassEqualOfReboard", map);
	}
	
	@Override
	public void deleteReboard(int num) {
		// TODO Auto-generated method stub
		session.delete("deleteOfReboard", num);
	}
	
	@Override
	public void updateReboard(BoardDto bdto) {
		// TODO Auto-generated method stub
		session.update("updateOfReboard", bdto);
		
	}
}
