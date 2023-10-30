package boot.data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import boot.data.dto.MemberDto;

@Mapper
public interface MemberMapperInter {
	
	public void insertMember(MemberDto dto);
	public List<MemberDto> getAllMembers();
	public int getSerchId(String id);
	public String getName(String id);
	public int loginPassCheck(Map<String, String> map); // MyBatis라서 Map을 사용해야 함.. String, String 따로 못받음..
	public MemberDto getDataById(String id);
	public void deleteMember(String num);
	public void updatePhoto(Map<String, String>map); // 회원사진 수정하기.
	public void updateMember(MemberDto mdto); // 회원정보 수정하기.
}
