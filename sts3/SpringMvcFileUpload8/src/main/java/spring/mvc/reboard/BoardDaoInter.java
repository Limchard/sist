package spring.mvc.reboard;

import java.util.List;

public interface BoardDaoInter {

	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup,int restep);
	public void insertReboard(BoardDto bdto);
	public List<BoardDto> getPagingList(int start,int perpage);
	public BoardDto getData(int num);
	public void updateReadCount(int num);
	public int getCheckPass(int num,int pass);
	public void deleteReboard(int num);
	public void updateReboard(BoardDto bdto);
}
