package Spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	@GetMapping("/apple/list") // apple/list에 값을 보내준다.. // list뒤에 .do나 다른 확장자를 붙히던 다 호출됨. 
	public String result1(Model model) {
		model.addAttribute("name", "홍성경");
		model.addAttribute("addr", "서울시 관악구");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		// ModelAndView 를 생성한 후에 return 해줘야 한다. 
		// ModelAndView는 request에 저장하기 위한 Model과 포워드 하기위한 View를 합쳐놓은 클래스입니다.
		
		ModelAndView mview=new ModelAndView();
		
		// request에 저장
		mview.addObject("java", 88);
		mview.addObject("javascript", 30);
		mview.addObject("spring",93);
		
		// 포워드할 jsp 파일 지정
		mview.setViewName("result2");
		
		return mview; 
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView orange() {
		ModelAndView modelv=new ModelAndView();
		
		modelv.addObject("sangpum", "아령");
		modelv.addObject("price",40000);
		modelv.addObject("color","pink");
		
		modelv.setViewName("result3");
		
		
		return modelv;
	}
	
	@GetMapping("/shop/detail")
	public String resImage() {
		
		
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
	public String shopImage() { // String의 의미는 포워드만 해줄때.. 인자값 넘기거나 하는 추가 행동이 없을 경우.
		// shopImage 이름은 상관없다. 디스페쳐서블릿 얘는 mapping 주소만 찾는다. 
		
		return "result5";
	}
	
	
}
