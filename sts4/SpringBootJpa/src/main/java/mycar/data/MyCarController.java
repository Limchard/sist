package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/car") // 중복 경로 전체 자동 기입 
public class MyCarController {

	@Autowired
	MyCarDao dao;
	
	@GetMapping("/carlist") //..시작 // 중간경로는 해도 되고, 안해도 되고
	public ModelAndView list() {
		
		ModelAndView model=new ModelAndView();
		
		List<MyCarDto> list=dao.getAllData();
		
		model.addObject("list", list);
		model.addObject("totalCount", list.size());
		
		model.setViewName("carlist");
			
		return model;
	}
	
	@GetMapping("/carform")
	public String form() {
		
		return "addform";
	}
	
	// insert
	@PostMapping("/insert")
	public String insert(@ModelAttribute MyCarDto dto) {
		
		dao.insertMyCar(dto);
		
		return "redirect:carlist";
	}
	
	// updateform 연결하기
	@GetMapping("/updateform")
	public String uform(Model model,@RequestParam long num) {
		
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "uform";	
	}
	
	@PostMapping("/updatecar")
	public String updatecar(@ModelAttribute("dto") MyCarDto dto) {
		
		dao.updateCar(dto); // insert와 동일하므로, insert로 사용해도 무관함
		
		return "redirect:carlist";
	}
	
	@GetMapping("/deletecar")
	public String delete(@RequestParam long num) {
		dao.deleteCar(num);
		
		return "redirect:carlist";
	}
	
	
	
	
}
