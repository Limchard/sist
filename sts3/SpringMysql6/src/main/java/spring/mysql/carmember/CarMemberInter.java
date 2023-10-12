package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {

	public int getTotalCount();
	
	public List<CarMemberDto> getAllData();
	
	public void insertMember(CarMemberDto dto);
	
	public void deleteMember(String num);
	
	public CarMemberDto getOneData(String num);
	
	public void updateMember(CarMemberDto dto);
	
}
