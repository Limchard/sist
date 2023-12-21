package boot.data.service;

import boot.data.dto.MemberDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface MeberServiceInter {
    public void insertMember(MemberDto dto);
    public List<MemberDto> getAllMembers();
    public int getSerchId(String id);
    public String getName(String id);
    public int loginPassCheck(String id,String pass); // MyBatis라서 Map을 사용해야 함.. String, String 따로 못받음..

    public void deleteMember(int num);
}
