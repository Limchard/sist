package Spring.mvc.start;

import org.springframework.web.bind.annotation.GetMapping;

public class QuizController {

	@GetMapping("/happy")
	public String quiz1() {
		
		return "quiz1";
	}
	
}
