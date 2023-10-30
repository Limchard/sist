package boot.data.service;

import java.util.List;
import java.util.Map;

import boot.data.dto.MemberDto;

public interface MemberServiceInter { // Service에서 Override 받기 편하려고 만든거다. 별 의미 없다. 

	
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public int getSerchId(String id);
	public String getName(String id);
	public int loginPassCheck(String id,String pass); // 여기에서는 Map을 각각 parameter로 풀어서 사용 가능하다. 
	public MemberDto getDataById(String id);
	public void deleteMember(String num);
	public void updatePhoto(String photo,String num); // 회원사진 수정하기.
	public void updateMember(MemberDto mdto); // 회원정보 수정하기.
}
