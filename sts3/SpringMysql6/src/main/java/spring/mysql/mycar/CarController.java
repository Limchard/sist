package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return "redirect:list"; // redirect 의 경우 주소값을 주는것이다. 그래서 앞에 경로 상관없이 지점만 적어주면 된다.
	}
	
	// delete
	@GetMapping("/kakao/delete") // mapping 주소 : onclick으로 넘겨준 주소.
	public String delete(@RequestParam String num) {
		
		dao.deleteCar(num);
		
		return "redirect:list"; // mapping 주소를 가지고 있는 controller 를 통해서 이동하기 때문에 'car/carList'가 아니라 'redirect:list' 로 보내줘야 한다.
		// 디스페쳐 서블릿이 컨트롤러에 가서 경로를 검색한다.	
	}
	
	// update 1단계 : updateForm 띄우기
	@GetMapping("/kakao/updateform")
	public String uform(@RequestParam String num,Model model) {
		
		MyCarDto dto=dao.getData(num);
		model.addAttribute("dto", dto);
		
		return "car/updateForm";
	}
	
	// update 2단계 : update 하기
	@PostMapping("/kakao/update")
	public String update(@ModelAttribute MyCarDto dto) {
		
		dao.updateCar(dto);
		
		return "redirect:list";
	}
	

	
}
