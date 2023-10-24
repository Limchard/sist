package data.model.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.model.dto.MarketDto;
// import data.model.service.MarketMapperInter;
import data.model.service.MarketService;

@Controller
public class MarketController {
	
//	
//	@Autowired
//	MarketMapperInter mapper;
//	
	@Autowired
	MarketService service;
	
	@GetMapping("/")
	public String start() {
		return "redirect:market/list"; // 이렇게 하면 아래 port번호만 입력해서 list가 나온다.
	}
	
	@GetMapping("/market/list")
	public ModelAndView list() {
		
		ModelAndView model=new ModelAndView();
		List<MarketDto> list=new ArrayList<>();
				
		
		// db 호출
		int totalCount=service.getTotalCountOfMarket();
		list=service.getAllSangpums();
		
		// 저장
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		
		
		// 포워드
		model.setViewName("market/marketlist");
		
		return model;
	}
	
	@GetMapping("/market/writeform")
	public String addform() {
		return "market/addform";
	}
	
	@PostMapping("/market/add")
	public String insert(@ModelAttribute MarketDto dto,
			MultipartFile sangupload,
			HttpSession session) {

		// upload할 save 위치 구하기
		String path=session.getServletContext().getRealPath("/save");
					
		// upload한 파일 dto 얻기
		dto.setPhotoname(sangupload.getOriginalFilename()); // 이거 물어봐야겠다.
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
					
		String photo="";

		if(sangupload.getOriginalFilename().equals("")) {
			photo=null;
			// null 은 equals가 먹지 않음. 이유는? equals는 String 비교 메서드이기 때문이다.
			
		} else {
			String fName=sangupload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
				
			// upload 하기
			try {
				sangupload.transferTo(new File(path+"/"+photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// dto의 Photo에 업로드 한 것을 넣어줘야 한다.
		dto.setPhotoname(photo);
		
		// insert (db에 저장)
		service.insertMarket(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/market/delete")
	public String delete(@RequestParam String num,HttpServletRequest request) {
		
		String photo=service.getData(num).getPhotoname();
		System.out.println(photo);
		if(photo!=null) {
			String path=request.getServletContext().getRealPath("/save");
			
			File file=new File(path+"/"+photo);
			file.delete();
		}
		
				
		service.deleteMarket(num);
		return "redirect:list";
	}
	
}
