package boot.data.service;

import boot.data.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MemberService implements MeberServiceInter{


    @Override
    public void insertMember(MemberDto dto) {

    }

    @Override
    public List<MemberDto> getAllMembers() {
        return null;
    }

    @Override
    public int getSerchId(String id) {
        return 0;
    }

    @Override
    public String getName(String id) {
        return null;
    }

    @Override
    public int loginPassCheck(String id, String pass) {
        return 0;
    }


}
