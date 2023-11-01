package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemboardDto;
import boot.data.service.MemberService;
import boot.data.service.MemboardService;

@Controller
@RequestMapping("/memboard")
public class MemBoardController {

	@Autowired
	MemboardService service;
	
	@Autowired
	MemberService mservice;
	
	@GetMapping("/list")
	public ModelAndView list() {

		ModelAndView model = new ModelAndView();
		
		int totalCount=service.getTotalCount();
		
		model.addObject("totalCount", totalCount);

		model.setViewName("/memboard/memlist"); // tiles resolver

		return model;
	}

	@GetMapping("/form")
	public String addform() {

		return "/memboard/addform";
	}
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute MemboardDto dto,HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/savefile");
		
		// 업로드 안한 경우 no
		if(dto.getUpload().getOriginalFilename().equals("")) {
			dto.setUploadfile("no");
		} else {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
			String fileName=sdf.format(new Date())+dto.getUpload().getOriginalFilename();
			
			dto.setUploadfile(fileName);
			
			try {
				dto.getUpload().transferTo(new File(path+"/"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 세션에서 아이디 얻어서 dto에 저장해주기
		String myid=(String) session.getAttribute("myid");
		dto.setMyid(myid);
		
		// 이름 얻기
		String name=mservice.getName(myid); // dao로 이름 얻는 방법
		// String name=(String)session.getAttribute("loginname"); // 세션에서 이름 얻는 방법..
		dto.setName(name);
		
		// insert
		service.insertMemboard(dto);
		
		return "redirect:content?num="+service.getMaxNum();
	}
	
	@GetMapping("/content")
	public ModelAndView content(@RequestParam String num) {
		
		ModelAndView model=new ModelAndView();
		
		MemboardDto dto=service.getData(num);
		
		model.addObject("dto", dto);
		
		// 업로드 파일의 확장자 얻기
		int dotLoc=dto.getUploadfile().lastIndexOf("."); // 마지막 점의 위치
		String ext=dto.getUploadfile().substring(dotLoc+1); // .다음 글자부터 끝까지 추출.
		
		System.out.println(dotLoc+","+ext);

		// 사진이면 content 내용에 띄울꺼고,, 아니면 안띄울꺼야
		if(ext.equalsIgnoreCase("jpg")
				||ext.equalsIgnoreCase("gif")
				||ext.equalsIgnoreCase("jpeg")
				||ext.equalsIgnoreCase("png")) {
			model.addObject("bupload", true);
		} else {
			model.addObject("bupload", false);
		}
				
		model.setViewName("/memboard/content");
		
		return model;
	}
}
