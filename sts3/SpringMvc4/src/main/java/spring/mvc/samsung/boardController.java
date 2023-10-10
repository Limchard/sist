package spring.mvc.samsung;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board") // 중간경로가 겹치면 맨쓰기 귀찮으니까 이렇게 지정해놓을 수 있다.
public class boardController {

	@GetMapping("/form1")
	public String form1() {
		
		return "board/writeForm";
	}
	
	@PostMapping("/process") // action에서 오는 process가 있어야 한다.
	public ModelAndView process1(@RequestParam String name,
			@RequestParam String date,
			@RequestParam String gender,
//			@RequestParam(defaultValue = "행복한 하루 보내세요") String msg
			@RequestParam(required = false) String msg, // required : true가 기본값.. 항목이 없어도 에가 안나게 하려면 false를 해야한다.
			@RequestParam(defaultValue = "1") int currentPage){
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("name", name);
		mview.addObject("date", date);
		mview.addObject("gender", gender);
		mview.addObject("msg", msg);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("board/result");
		
		return mview;
	}
	
	
	@GetMapping("/result2")
	public String result2(Model model) {
		
		model.addAttribute("myimg1", "../image/11.jpg");
		model.addAttribute("title", "냐아오옹");
		
		return "board/result2";
	}
	
}
