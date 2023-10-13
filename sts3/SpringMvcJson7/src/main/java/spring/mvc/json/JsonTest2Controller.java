package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String name){
		
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("흰냥이", "1.jpg"));
		list.add(new PhotoDto("깜냥이", "17.jpg"));
		list.add(new PhotoDto("회냥이", "6.jpg"));
		list.add(new PhotoDto("줄냥이", "8.jpg"));
		list.add(new PhotoDto("갈냥이", "5.jpg"));
		
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "없는 고냥이");
		map.put("photo", "21.jpg");
		
		for(PhotoDto dto:list) {
			if(name.equals(dto.getName())) {
				map.put("name", dto.getName());
				map.put("photo", dto.getPhoto());
			}
		}
		
		return map;
	}
	
}
