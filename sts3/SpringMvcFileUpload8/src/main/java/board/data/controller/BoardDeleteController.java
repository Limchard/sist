package board.data.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDaoInter;

@Controller
public class BoardDeleteController {

	@Autowired
	BoardDaoInter inter;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView dpassform(@RequestParam String num,@RequestParam String currentPage) {
		
		ModelAndView mview=new ModelAndView();
		
		mview.addObject("num", num);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("reboard/delpassform");
		
		return mview;
	}
	
	@PostMapping("/board/deletepass")
	public ModelAndView deletepass(@RequestParam int num,@RequestParam int pass,
			@RequestParam int currentPage,HttpSession session) {
		
		ModelAndView mview=new ModelAndView();
		
		// 비밀번호가 맞으면 삭제하고, 틀리면 passfail로 이동
		
		int check=inter.getCheckPass(num, pass);
		
		if(check==0) {
			mview.setViewName("reboard/passfail"); 
		} else {
			
			String photo=inter.getData(num).getPhoto();
			if(!photo.equals("no")) {
				String [] fName=photo.split(",");
				String path=session.getServletContext().getRealPath("/WEB-INF/photo");
				
				for(String f:fName) {
					File file=new File(path+"/"+f);
					file.delete();
				}
			}
			inter.deleteReboard(num);
			mview.setViewName("redirect:list");
		}
		return mview;
	}
}
