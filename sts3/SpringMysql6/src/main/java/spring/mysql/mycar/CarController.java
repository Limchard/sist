package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

	@Autowired
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model) {
		
		// dao로 부터 총 개수 가지고 오기
		int totalCount=dao.getTotalCount();
		
		// 목록 가져오기
		List<MyCarDto> list=dao.getAllCars();
		
		//request에 저장하는것.
		model.addAttribute("totalCount", totalCount);
		
		// request에 목록 가지고온거 저장하기
		model.addAttribute("list", list);
		
		return "car/carList";
	}
	
	@GetMapping("/kakao/writeForm")
	public String carform() {
		
		return "car/writeForm";
	}
	
	
	// insert
	@PostMapping("/kakao/write")
	public String insert(@ModelAttribute MyCarDto dto) {
		
		dao.insertCar(dto);
		
		return "redirect:list";
	}
	
	// delete
	@GetMapping("/kakao/delete")
	public String delete(@ModelAttribute MyCarDto dto) {
		
		dao.deleteCar(dto);
		
		return "redirect:list";
		
	}

	
}
