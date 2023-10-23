package mycar.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	@PostMapping("/insert") // multipart 관련사항 수정해주기. MultiPart, HttpSession,등등 받아오면 끝!
	public String insert(@ModelAttribute MyCarDto dto,
			MultipartFile carupload,
			HttpSession session) {
		
		// 업로드할 save 위치 구하기
		String path=session.getServletContext().getRealPath("/save");
		
		// 업로드한 파일 dto얻기 
		dto.setCarphoto(carupload.getOriginalFilename());
		
		// 실제 업로드
		try {
			carupload.transferTo(new File(path+"/"+carupload.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// insert
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
	
	// update	
	@PostMapping("/updatecar")
	public String updatecar(@ModelAttribute("dto") MyCarDto dto) {
		
		dao.updateCar(dto); // insert와 동일하므로, insert로 사용해도 무관함
		
		return "redirect:carlist";
	}
	
	// delete
	@GetMapping("/deletecar")
	public String delete(@RequestParam long num) {
		dao.deleteCar(num);
		
		return "redirect:carlist";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam long num,Model model) {
		
		MyCarDto dto=dao.getData(num);
		
		model.addAttribute("dto", dto);
		
		return "detail";
	}
	
	
	
	
}
