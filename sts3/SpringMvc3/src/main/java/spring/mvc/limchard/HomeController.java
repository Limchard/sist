package spring.mvc.limchard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String start() {
		
		return "start"; // return "form";
	}
	
	@GetMapping("/login/form")
	public String form() {	
		
		return "form";
	}
	
	@GetMapping("/login/read") // 위에서 form  앞에 login을 줬기 때문에 여기서도 login을 무조건 적어줘야 한다.
	public String process(Model model,@RequestParam(value = "myid") String id,String mypass) {
//		@@RequestParam(value = "myid") String id: form 에 있는 myid를 id로 쓰겠다, 변경해줄 때.. myid를 그냥 myid 그대로 쓸거면 그냥 써도 된다.
//		
		model.addAttribute("id", id);
		String msg="";
		if(mypass.equals("1234")) {
			msg="login 성공!!";
		} else {
			msg="login 실패 ㅠㅠ";
		}
		model.addAttribute("msg", msg);
		
		return "result";
	}
}
