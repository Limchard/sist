package boot.mvc.ex1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/test")
		public TestDto hell() {
			
			TestDto dto=new TestDto();
			dto.setName("뽀로로");
			dto.setAddr("남극");
			
			return dto;
		}
	
}
