package boot.mvc.cine;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MovieController {

	@Autowired
	MovieDao dao;
	
	@GetMapping("/")
	public String home() {
		
		return "redirect:movie/list";
	}
	
	@GetMapping("/movie/list")
	public String list(Model model) {
		
		List<MovieDto> list=dao.getAllMovie();
		
		model.addAttribute("list", list);
		model.addAttribute("movieCount", list.size());
		
		return "movielist";
	}
	
	@GetMapping("/movie/writeform")
	public String addform() {
		
		return "addform";
	}
	
	@PostMapping("/movie/insert")
	public String insert(@ModelAttribute MovieDto dto,
			MultipartFile mv_file,
			HttpSession session) {
		
		// 업로드할 위치 구하기
		String path=session.getServletContext().getRealPath("/moviephoto");
		
		// 업로드한 파일 dto 얻기
		dto.setMv_poster(mv_file.getOriginalFilename());
		
		
		try {
			mv_file.transferTo(new File(path+"/"+mv_file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.insertMovie(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/movie/detail")
	public String detail(@RequestParam long num,Model model) {
		
		MovieDto dto=dao.getDetail(num);
		
		model.addAttribute("dto", dto);
		
		return "detail";
	}
	
	
}
