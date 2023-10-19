package my.info;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {
	
	@GetMapping("/my/info")
	@ResponseBody
	public HashMap<String, String> info(){
		HashMap<String, String> myinfo=new HashMap<>();
		
		myinfo.put("name", "장순영");
		myinfo.put("age", "23");
		myinfo.put("addr", "서울시 강남구");
		// 출력 순서는 random이다. 
		return myinfo;
	}
	
	
}
