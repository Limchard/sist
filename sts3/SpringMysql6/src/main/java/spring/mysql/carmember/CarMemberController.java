package spring.mysql.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mysql.mycar.MyCarDto;

@Controller
public class CarMemberController {
	
	@Autowired
	CarMemberInter inter;
	
	
	@GetMapping("/member/list")
	public String memberList(Model model) {
		
		// 갯수 가져오기
		int count=inter.getTotalCount();
		// 전체 select
		List<CarMemberDto> list=inter.getAllData();
		
		// request에 저장
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "carmember/memberList";
	}
	
	@GetMapping("/member/insertform")
	public String insertform() {
		return "carmember/addForm";
	}
	
	@PostMapping("/member/insert")
	public String insertMember(@ModelAttribute CarMemberDto cardto) {
		inter.insertMember(cardto);
		
		return "redirect:list";
	}
	
	@GetMapping("/member/delete")
	public String delete(@RequestParam String num) {
		inter.deleteMember(num);
		
		return "redirect:list";
	}
	
	@GetMapping("/member/updateform")
	public String update(@RequestParam String num,Model model) {
		
		CarMemberDto cardto=inter.getOneData(num);
				
		model.addAttribute("cardto", cardto);
		
		return "carmember/updateMember";
	}
	
	
	@PostMapping("/member/update")
	public String updateMember(@ModelAttribute CarMemberDto cardto) {
		
		inter.updateMember(cardto);
		
		return "redirect:list";
	}
			
}
