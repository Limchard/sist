package boot.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.mvc.ex1.ShopDto;
import boot.mvc.ex1.TestDto;

@RestController
public class TestController {

	@GetMapping("/test")
		public TestDto hell() {
			
			TestDto dto=new TestDto();
			dto.setName("뽀로로");
			dto.setAddr("남극");
			
			return dto;
		}
	
	@GetMapping("/shop/list")
	public List<ShopDto> list(){
		
		List<ShopDto> list=new ArrayList<>();
		
		ShopDto d1=new ShopDto();
		d1.setSang("초코파이");
		d1.setSu(2);
		d1.setDan(1000);
		
		ShopDto d2=new ShopDto();
		d2.setSang("메로나");
		d2.setSu(3);
		d2.setDan(1500);
		
		list.add(d1);
		list.add(d2);
		
		return list;
	}
	
}
