package spring.mvc.friday;

import java.util.List;

public interface InfoInter {

	public int getTotalCount();
	
	public void insertMyInfo(InfoDto idto);
	
	public List<InfoDto> getAllDataOfMyInfo();
	
	public InfoDto getData(String num);
	
	public void updateMyInfo(InfoDto idto);
	
	public void deleteInfo(String num);
	
}
