package boot.data.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MbAnswerDto;
import boot.data.dto.MemberDto;
import boot.data.mapper.MbAnswerMapperInter;
import boot.data.service.MemberService;

@RestController
@RequestMapping("/mbanswer")
public class MbAnswerController {
	
	@Autowired
	MbAnswerMapperInter mapper;
	
	@Autowired
	MemberService mservice;
	
	@PostMapping("/ainsert")
	public void insert(@ModelAttribute MbAnswerDto dto,
//			@RequestParam String content, // dto와 이름이 같으면 알아서 들어간다. 굳이 받아오고 기입해줄 필요 없다.
//			@RequestParam String num, // dto와 이름이 같으면 알아서 들어간다. 굳이 받아오고 기입해줄 필요 없다.
			HttpSession session) {
		
		// 세션에 로그인한 id 얻기
		String myid=(String)session.getAttribute("myid");
		
		// 아이디에 대한 작성자 얻어오기
		String name=mservice.getName(myid);
		
		
		// dto에 담기 
//		dto.setNum(num); // dto와 이름이 같으면 알아서 들어간다. 굳이 받아오고 기입해줄 필요 없다.
		dto.setName(name);
		dto.setMyid(myid);
//		dto.setContent(content); // dto와 이름이 같으면 알아서 들어간다. 굳이 받아오고 기입해줄 필요 없다.		
		
		mapper.insertMbAnswer(dto);
	}
	
	
	@GetMapping("/alist")
	public List<MbAnswerDto> alist(@RequestParam String num) {

		return mapper.getAllAnswers(num);
	}
	
	@GetMapping("/adelete")
	public void adelete(@RequestParam String idx) {
		
		mapper.deleteMbAnswer(idx);		
	}
	
	// 수정창 content(모달창) 띄우기
	@GetMapping("/adata")
	public MbAnswerDto getData(String idx) {
		
		return mapper.getAnswer(idx);
	}
	
	// 실절적인 수정
	@PostMapping("/aupdate")
	public void aupdate(@ModelAttribute MbAnswerDto dto) {
		
		mapper.updateMbAnswer(dto);
	}
	
}
