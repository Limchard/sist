package Spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // controller 역할을 하는 곳에서는 @Component 가 아니라 @Controller 를 사용해야 한다. bean에 넣어준다.


public class StartController {
	// start.jsp 로 가기 위한 메서드 (포워드... url 주소값도 아예 이동하는 것.)
	
	@GetMapping("/") //mapping 주소 써줘야 한다. 원래는 @RequestMapping을 써야 한다. 이는 그때그때 value값 입력하고.. 암튼 귀찮다.   
	// 5버전 이후부터 getMapping을 사용 할 수있다.(그래서 pom.xml에서 <org.springframework-version>5.2.9.RELEASE</org.springframework-version>에서 버전을 바꿔줘야 한다.) 훨씬 간단하다.
	public String start(Model model) { // jsp 파일 명을 써주기 위한 최소한의 String만 있으면 된다.
		
		// Model: request에 데이터를 저장하기위한 인터페이스 
		// 서블릿에서 하던 request.setAttribute와 똑같은 것이다.
		model.addAttribute("name", "김영환");
		model.addAttribute("addr","서울시 강남구");
		
		return "start"; // WEB-INF/day1005/start.jsp 를 의미한다.
	}

	
	
}
