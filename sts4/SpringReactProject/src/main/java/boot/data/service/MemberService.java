package boot.data.service;

import boot.data.dto.MemberDto;
import boot.data.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MemberService implements MeberServiceInter{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void insertMember(MemberDto dto) {
        memberMapper.insertMember(dto);
    }

    @Override
    public List<MemberDto> getAllMembers() {
        return memberMapper.getAllMembers();
    }

    @Override
    public int getSerchId(String id) {
        return memberMapper.getSerchId(id);
    }

    @Override
    public String getName(String id) {
        return memberMapper.getName(id);
    }

    @Override
    public int loginPassCheck(String id, String pass) {
        Map<String, String>map=new HashMap<>();
        map.put("id",id);
        map.put("pass",pass);
        return memberMapper.loginPassCheck(map);
    }

    @Override
    public void deleteMember(int num) {
        memberMapper.deleteMember(num);
    }


}
