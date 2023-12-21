package boot.data.controller;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/idsearch")
    public int idCheck(@RequestParam String id){
        return memberService.getSerchId(id);
    }

    @PostMapping("/login")
    public int login(@RequestBody MemberDto dto){
        System.out.println("Login>>"+dto.getId());
        return memberService.loginPassCheck(dto.getId(), dto.getPass());
    }

    @GetMapping("/getname")
    public String getName(@RequestParam String id){
        return memberService.getName(id);
    }

    // 리스트
    @GetMapping("/list")
    public List<MemberDto> getAllMembers(){
        List<MemberDto> list=memberService.getAllMembers();
        return list;
    }

    // 삭제
    @DeleteMapping("/delete")
    public void deleteMember(@RequestParam int num){
        memberService.deleteMember(num);
    }

}
