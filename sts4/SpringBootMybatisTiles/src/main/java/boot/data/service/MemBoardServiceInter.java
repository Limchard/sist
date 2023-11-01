package boot.data.service;

import java.util.List;

import boot.data.dto.MemboardDto;

public interface MemBoardServiceInter {

	public int getTotalCount();
	public void updateReadCount(String num);
	public void insertMemboard(MemboardDto dto);
	public MemboardDto getData(String num);
	public int getMaxNum();
	public List<MemboardDto> getList(int start,int perpage);
}
