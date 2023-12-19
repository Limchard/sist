package boot.data.mapper;

import boot.data.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberDto dto);
    public List<MemberDto> getAllMembers();
    public int getSerchId(String id);
    public String getName(String id);
    public int loginPassCheck(Map<String, String> map); // MyBatis라서 Map을 사용해야 함.. String, String 따로 못받음..

}
