package spring.mvc.tea;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver")
public class NaverController {

	@GetMapping("/form1")
	public String form1() {
		
		return "day1010/form1";
		
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(@RequestParam String name, @RequestParam String gender, @RequestParam String addr) {
		ModelAndView model=new ModelAndView();
		
		// 모델에 넣어주기
		model.addObject("name", name);
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		
		// 포워드	
		model.setViewName("day1010/result1");
		
		return model;
	}
	
	@GetMapping("/form2")
	public String form2() {
		
		return "day1010/form2";
		
	}
	
	// @ModelAttribute : 폼의 데이터를 읽어서 dto에 넣고 model에 저장
	// 단, model에는 ShopDto 타입일경우 앞에만 소문자가 되어 자동 저장 -> shopDto
	// 다른이름으로 원하면 @ModelAttribute("이름") 으로 이름을 지정해준다.
	@PostMapping("/read2")
	public String read2(@ModelAttribute("dto") ShopDto dto) {
		
		return "day1010/result2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		
		return "day1010/form3";
		
	}
	
	@PostMapping("/read3")
	// 폼태그의 name이 key값으로, 입력값은 value 값으로 온다.
	public ModelAndView read3(@RequestParam Map<String, String>map) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		// 포워드 (이동 가즈아!)
		model.setViewName("day1010/result3");
		
		return model;
	}
	
	@GetMapping("/form4")
	public String uploadForm1() {
		
		
		return "upload/uploadForm1";
	}
	
	
	@PostMapping("/upload1")
	public ModelAndView read1(@RequestParam String title,@RequestParam MultipartFile photo,HttpSession session) {
		// HttpServletRequest 에 realPath 를 찾기 위해서 한다.
		// MultipartFile photo 에서 photo는 uploadForm1의 name이다.
		ModelAndView model=new ModelAndView();
		
		// 업로드할 실제 경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		String fileName=photo.getOriginalFilename(); // upload된 파일 명 
		
		// 사진 여러개 올리기 위해서 (현재 날짜와 시간 이용하여 파일명 겹치는거 방지하기)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		if(!fileName.equals("")) { // 파일 업로드 할 경우
		// path에 업로드
		fileName=sdf.format(new Date())+"_"+fileName;

		try {
			photo.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} else {
			fileName="no"; // 파일 업로드 안할경우
		}
		
		model.addObject("fileName", fileName);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult1");
		
		return model;
	}
	
	// 여려개 업로드 하는 폼으로 이동
	@GetMapping("/uploadform5")
	public String uploadform5() {
		
		return "upload/uploadForm2";
	}
	
	@PostMapping("/upload2")
	public ModelAndView read2(@RequestParam String title,@RequestParam ArrayList<MultipartFile>photo,HttpSession session) {
		// HttpServletRequest 에 realPath 를 찾기 위해서 한다.
		// MultipartFile photo 에서 photo는 uploadForm2의 name이다.
		ModelAndView model=new ModelAndView();
		
		// 업로드할 실제 경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		
		// 사진 여러개 올리기 위해서 (현재 날짜와 시간 이용하여 파일명 겹치는거 방지하기)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		ArrayList<String> files=new ArrayList<String>();
		
		// 파일명 ArrayList에 담기
		for(MultipartFile f:photo) {
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename();
			files.add(fileName);
			
			// 업로드.
			try {
				f.transferTo(new File(path+"/"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addObject("files", files);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadResult2");
		
		return model;
	}
	
}
