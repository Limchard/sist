package board.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDaoInter;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {

	@Autowired // 자동 주입
	BoardDaoInter inter;
	
	
	@GetMapping("/board/content") // list에서 a태그 href에 있는 'content?' 라고 넘겨서 mapping 주소도 content이다.
	public ModelAndView content(@RequestParam int num, @RequestParam String currentPage) { // boardlist 에서 보내준 2개의 값 다 받아줘야 한다.
		
		ModelAndView mview=new ModelAndView();
		
		// 조회수 증가
		inter.updateReadCount(num);
		
		// 넘어온 num에 대한 값들을 다시 dto에 넣어주기 
		BoardDto bdto=inter.getData(num);
		
		mview.addObject("bdto", bdto);
		mview.addObject("currentPage", currentPage);
		
		mview.setViewName("reboard/content");
		
		return mview;
	}
	
}
