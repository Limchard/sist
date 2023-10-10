package spring.mvc.munje;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.InfoDto;

@Controller
public class InfoController {
	
	
	@GetMapping("/info/form")
	public String info() {
				
		return "infoForm";
	}
	
	@PostMapping("/info/result")
	public String result(@ModelAttribute("dto") InfoDto dto) {
		
		
		return "infoWrite";
	}
	// String 은 포워드 시킬때, model은 저장할때, ModelAndView 는 포워드랑 저장을 같이 할때 사용한다.	

//	@GetMapping("/info.form")
//	public ModelAndView start() {
//		
//		ModelAndView model=new ModelAndView();
//		
//		model.setViewName("info/infoForm");
//		
//		return model;
//	}
	
}
