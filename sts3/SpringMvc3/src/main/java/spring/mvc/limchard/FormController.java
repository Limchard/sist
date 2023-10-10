package spring.mvc.limchard;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class FormController {

	@GetMapping("/data/myform")
	public String insertform() {
		
		
		return "myforms";
	}
	
	// read1_get방식 폼 전송
	@GetMapping("/data/read1")
	public ModelAndView read1(String myname,int myage,@RequestParam(value = "msg",defaultValue = "HappyDay!!")String msg) { // 형변환도 여기서 가능, int로 쓰고 싶으면 그냥 int 쓰면 된다.
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("name", myname);
		mview.addObject("age", myage);
		mview.addObject("msg", msg);
		
		//forward	
		mview.setViewName("process1");
		
		return mview;
	}
	
	@PostMapping("/data/read2")
	public ModelAndView read2(@ModelAttribute FormDto dto) { // dto 받아오기!
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto", dto); // 데이터가 몇개이든 이렇게 하면 dto 다 보낸거다.
		
		model.setViewName("process2");
		
		
				
		return model;
	}
	
	@PostMapping("/data/read3")
	public ModelAndView read3(@RequestParam Map<String, String>map) {
		ModelAndView model=new ModelAndView();
		
		String sang=map.get("sang");
		String price=map.get("price");
		
		String data=sang+"의 가격은 "+price+"원 입니다.";
		
		model.addObject("data", data);
		
		model.setViewName("process3");
		
		return model;
	}
}
