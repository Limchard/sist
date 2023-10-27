package boot.data.service;

import java.util.List;

import boot.data.dto.MemberDto;

public interface MemberServiceInter { // Service에서 Override 받기 편하려고 만든거다. 별 의미 없다. 

	
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public int getSerchId(String id);
	
	
}
