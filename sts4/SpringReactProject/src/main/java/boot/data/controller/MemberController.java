package boot.data.controller;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/insert")
    public void insert(@RequestBody MemberDto dto){
        System.out.println("insert>>>"+dto.getEmail());
        memberService.insertMember(dto);
    }

    @GetMapping("/idserch")
    public int idCheck(@RequestParam String id){
        return memberService.getSerchId(id);
    }

}
