package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDaoInter;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardUpdateController {

	@Autowired
	BoardDaoInter inter;
	
	
	@GetMapping("/board/updatepassform")
	public ModelAndView upassform(@RequestParam int num,@RequestParam int currentPage) {
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("reboard/updatepassform");
		
		return mview;
	}
	
	@PostMapping("/board/updatepass")
	public ModelAndView updatepass(@RequestParam int num,@RequestParam int pass,@RequestParam int currentPage) {
				 
		ModelAndView mview=new ModelAndView();
		System.out.println(currentPage);
		
		// 비밀번호가 맞으면 수정폼으로, 틀리면 passfail로 이동
		
		int check=inter.getCheckPass(num, pass);
		
		if(check==0) {
			mview.setViewName("reboard/passfail");
		} else {
			BoardDto bdto=inter.getData(num);
			
			mview.addObject("bdto", bdto);
			mview.addObject("currentPage", currentPage);
			
			mview.setViewName("reboard/updateform");
		}
		
		return mview;
	}
	
	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto bdto,
			@RequestParam String currentPage,
			@RequestParam ArrayList<MultipartFile>uimage,
			HttpSession session) {
		String path=session.getServletContext().getRealPath("WEB-INF/photo");
		System.out.println(path);
		System.out.println(currentPage);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		if(uimage.get(0).getOriginalFilename().equals("")) {
			photo="no";
		} else {
			// 수정전에 이전사진 지우기
			String pre_photo=inter.getData(bdto.getNum()).getPhoto();
			
			String []pre_fName=pre_photo.split(",");
			for(String f:pre_fName) {
				File file=new File(path+"/"+f);
				file.delete();
			}
			
			for(MultipartFile f:uimage) {
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				photo+=fName+",";
				
				try {
					f.transferTo(new File(path+"/"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			// photo에서 마지막 컴마 제거하기 
			photo=photo.substring(0, photo.length()-1);
		}
		// dto의 Photo에 넣기
		bdto.setPhoto(photo);
		
		// update
		inter.updateReboard(bdto);
		
		// 내용 수정 후 원래 페이지로 이동
		return "redirect:content?num="+bdto.getNum()+"&currentPage="+currentPage;
	}
	
}
