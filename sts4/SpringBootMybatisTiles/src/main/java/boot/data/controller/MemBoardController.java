package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage) {

		ModelAndView model = new ModelAndView();
		
		int totalCount=service.getTotalCount();
		
		// 페이징 처리에 필요한 변수선언
		int totalPage; //총 페이지수
		int startPage; //각블럭에서 보여질 시작페이지
		int endPage; //각블럭에서 보여질 끝페이지
		int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이 0,오라클은 1)
		int perPage=4; //한페이지당 보여질 글의 갯수
		int perBlock=2; //한블럭당 보여질 페이지 개수
		int no; //각페이지당 출력할 시작번호   
				     
		//총페이지수 구하기
		//총글의 갯수/한페이지당 보여질 개수로 나눔(7/5=1)
		//나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
		  	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
		 
		//각블럭당 보여야할 시작페이지
		//perBlock=5일경우는 현재페이지 1~5 시작:1 끝:5
		//현재페이지 13  시작:11  끝:15
		  	startPage=(currentPage-1)/perBlock*perBlock+1;
				     
		  	endPage=startPage+perBlock-1;
				    
		 // 총페이지가 23일경우 마지막블럭은 25가아니라 23이다   
		      if(endPage>totalPage)
		        	endPage=totalPage;
				     
			//각페이지에서 보여질 시작번호
			//1페이지: 0,2페이지:5 3페이지:10....
			startNum=(currentPage-1)*perPage;
					
			//각페이지당 출력할 시작번호 구하기 no
			//총글개수가 23이면 1페이지 23,2페이지는 18,3페이지 13.....
			//출력시 1씩 감소하며 출력
			no=totalCount-(currentPage-1)*perPage;
				
			// 각 페이지에서 필요한 게시글 가져오기
			List<MemboardDto> list=service.getList(startNum, perPage);
					
			// list의 각글에 댓글 갯수 표시하기
//			for(MemboardDto d:list) {
//				d.setAcount(adao.getAnswerList(d.getNum()).size());
//			}
					
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("totalPage", totalPage);
		model.addObject("no", no);
		model.addObject("currentPage", currentPage);
		
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
	public ModelAndView content(@RequestParam String num,
			@RequestParam(defaultValue = "1") int currentPage) {
		System.out.println(currentPage);
		ModelAndView model=new ModelAndView();
		
		service.updateReadCount(num);
		
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
		
		model.addObject("currentPage", currentPage);
		model.setViewName("/memboard/content");
		
		return model;
	}
	
	@GetMapping("/updateform")
	public ModelAndView uform() {
		
		ModelAndView model=new ModelAndView();
		
		model.setViewName("/memboard/updateform");
		
		return model;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String num) {
					
		return "redirect:list";
	}
	
}
