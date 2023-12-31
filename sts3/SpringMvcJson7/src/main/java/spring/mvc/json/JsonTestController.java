package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 일반적인 controller 에서 사용할때에는 public 위쪽이나, Map<> 앞쪽에 @ResponseBody 를 넣어줘야 한다.
public class JsonTestController {
	
	@GetMapping("/list1")
	@ResponseBody // json으로 처리하여 브라우저로 출력하는 annotation.
	public Map<String, String> list1(){
		
		Map<String, String> map=new HashMap<String, String>();
		// Map은 인터페이스라서 HashMap으로 호출해줘야 한다.
		
		map.put("name", "뽀로로");
		map.put("hp", "010-1111-2223");
		map.put("addr", "남극");
		
		return map;
	}
		
	@GetMapping("/list3")
	public @ResponseBody List<PhotoDto> list3(){
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("흰냥이", "1.jpg"));
		list.add(new PhotoDto("깜냥이", "17.jpg"));
		list.add(new PhotoDto("회냥이", "6.jpg"));
		list.add(new PhotoDto("줄냥이", "8.jpg"));
		list.add(new PhotoDto("갈냥이", "5.jpg"));
		
		return list;
	}
}
