package data.model.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import data.model.dto.MarketDto;
import data.model.mapper.MarketMapperInter;

@Controller
public class MarketController {
	
	@Autowired
	MarketMapperInter mapper;

	@GetMapping("/market/list")
	public ModelAndView list() {
		
		ModelAndView model=new ModelAndView();
		List<MarketDto> list=new ArrayList<>();
				
		
		// db로 부터 총개수 얻기
		int totalCount=mapper.getTotalCountOfMarket();
		list=mapper.getAllSangpums();
		
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
		
		// insert
		mapper.insertMarket(dto);
		
		return "redirect:list";
	}
	
}
