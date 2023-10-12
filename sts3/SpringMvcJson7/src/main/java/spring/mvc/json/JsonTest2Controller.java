package spring.mvc.json;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // json으로 처리해서 브라우저로 표현해주는 restAPI (Ajax 전용,json 전용 컨트롤러)
public class JsonTest2Controller {
	
	@GetMapping("/list2")
	public Map<String, String> list2(){
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("phone", "아이폰");
		map.put("price", "1500000");
		map.put("color", "그레이");		
		
		return map;
	}
	
}
