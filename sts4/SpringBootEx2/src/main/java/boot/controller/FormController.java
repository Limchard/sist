package boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.dto.PersonDto;

@Controller
public class FormController {

	@GetMapping("/sist/form1")
	public String form1() {
		return "form/form1";
	}
	
	@GetMapping("/sist/form2")
	public String form2() {
		return "form/form2";
	}
	
	@GetMapping("/sist/form3")
	public String form3() {
		return "form/form3";
	}
	
	// 값 읽기 
	@PostMapping("/sist/read1")
	public String read1(@RequestParam String irum,
			@RequestParam int java,
			@RequestParam int spring,
			Model model) {
		
		model.addAttribute("irum", irum);
		model.addAttribute("java", java);
		model.addAttribute("spring", spring);
				
		return "result/result1";
	}
	
	
//	@PostMapping("/sist/write2")
//	public String read2(Model model,@ModelAttribute PersonDto pdto) {
//		
//		model.addAttribute("name", pdto.getName());
//		model.addAttribute("addr", pdto.getAddr());
//		model.addAttribute("hp", pdto.getHp());
//		
//		
//		return "result/result2";
//	}
	
	// dto
	@PostMapping("/sist/write2")
	public String read2(@ModelAttribute("pdto") PersonDto pdto) {
		
		return "result/result2";
	}
	
//	// map
//	@PostMapping("/sist/myread")
//	public String read3(Model model,@RequestParam String name,
//			@RequestParam String blood,
//			@RequestParam String age) {
//		
//		Map<String, String> map=new HashMap<>();
//		
//		map.put("name", name);
//		map.put("blood", blood);
//		map.put("age", age);
//		
//		model.addAttribute("map", map);
//		
//		return "result/result3";
//	}
	
	// map
	// map으로 읽을경우 폼의 name이 key값으로 받고, 입력값은 value값으로 받는다.
		@PostMapping("/sist/myread")
		public String read3(Model model,@RequestParam Map<String, String>map) {
			
			model.addAttribute("name", map.get("name"));
			model.addAttribute("blood", map.get("blood"));
			model.addAttribute("age", map.get("age"));
			
			return "result/result3";
		}
	
	
}
