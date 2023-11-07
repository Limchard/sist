package boot.data.controller;

import boot.data.dto.ReBoardDto;
import boot.data.service.MemberService;
import boot.data.service.ReBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/reboard")
public class ReBoardController {

	@Autowired
	ReBoardService service;

	@Autowired
	MemberService memberService;

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(value = "currentPage",defaultValue = "1") int currentPage,
							 @RequestParam(value = "searchcolumn",required = false) String sc, // 값이 null일 경우에 오류나기때문에 (required = false) 해줘야 한다.
							 @RequestParam(value = "searchword", required = false) String sw) {

		ModelAndView model=new ModelAndView();

		// 페이징에 필요한 변수들 가져오기
		// 페이징 처리에 필요한 변수선언
		int totalCount=service.getTotalCount(sc,sw); //전체갯수
		int totalPage; //총 페이지수
		int startPage; //각블럭에서 보여질 시작페이지
		int endPage; //각블럭에서 보여질 끝페이지
		int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이 0,오라클은 1)
		int perPage=5; //한페이지당 보여질 글의 갯수
		int perBlock=3; //한블럭당 보여질 페이지 개수
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
		List<ReBoardDto> list=service.getPagingList(sc,sw,startNum,perPage);

//		// list의 각글에 댓글 갯수 표시하기
//		for(BoardDto d:list) {
//			d.setAcount(adao.getAnswerList(d.getNum()).size());
//		}

		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("totalPage", totalPage);
		model.addObject("no", no);
		model.addObject("currentPage", currentPage);

		System.out.println("totalCount="+totalCount);

		model.setViewName("/reboard/boardlist");

		return model;
	}

	@GetMapping("/form")
	public String reform(@RequestParam(defaultValue = "0") int num,
						 @RequestParam(defaultValue = "0") int regroup,
						 @RequestParam(defaultValue = "0") int restep,
						 @RequestParam(defaultValue = "0") int relevel,
						 @RequestParam(defaultValue = "1") int currentPage,
						 Model model){
		// 답글일 경우에만 넘어오는 값들이다.

		// 새글일 경우는 모두 null(0) 이므로 defaultValue만 값으로 전달된다.
		model.addAttribute("num",num);
		model.addAttribute("regroup",regroup);
		model.addAttribute("restep",restep);
		model.addAttribute("relevel",relevel);
		model.addAttribute("currentPage",currentPage);

		// 새글일경우에는 "", 답글일경우에는 원글 제목 가져오기.
		String subject="";
		if(num>0){
			subject=service.getData(num).getSubject();
		}
		model.addAttribute("subject",subject);

		return "/reboard/addform";
	}

	@PostMapping("/insert")
	public String insertReBoard(@ModelAttribute ReBoardDto dto,
								@RequestParam ArrayList<MultipartFile>upload,
								HttpSession session,
								@RequestParam int currentPage){

		String id=(String) session.getAttribute("myid");
		String name=memberService.getName(id);
		// String name=(String)session.getAttribute("loginname");

		// 실제 경로 구하기
		String path=session.getServletContext().getRealPath("/membersave");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(path);

		// 이름 초기화
		String photo="";

		if(upload.get(0).getOriginalFilename().equals("")){
			photo="no";
		} else {
			for (MultipartFile f:upload){
				String fName= sdf.format(new Date())+"_"+f.getOriginalFilename();
				photo+=fName+","; // 누적 ^^ 구분자 넣기

				try {
					f.transferTo(new File(path+"/"+fName));
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			// photo 에서 마지막 컴마 제거
			photo=photo.substring(0,photo.length()-1);
		}

		// dto의 photo에 넣기
		dto.setPhoto(photo);

		dto.setId(id);
		dto.setName(name);

		// insert
		service.insertReBoard(dto);

		int maxNum= service.getMaxNum();

		return "redirect:list?currentPage="+currentPage;
	}

	@GetMapping("/content")
	public String detail(@RequestParam int num,int currentPage,
						 Model model){

		// 조회수 증가
		service.updateReadCount(num);

		// dto
		ReBoardDto dto=service.getData(num);

		model.addAttribute("dto",dto);
		model.addAttribute("currentPage",currentPage);

		return "/reboard/content";
	}

	// 추천수 증가
	@GetMapping("/likes")
	@ResponseBody
	public Map<String,Integer> likes(int num){
		service.updateLikes(num);
		int likes=service.getData(num).getLikes();

		Map<String,Integer>map=new HashMap<>();
		map.put("likes",likes);

		return map;
	}



	// 삭제
	@GetMapping("/delete")
	public String deleteContent(@RequestParam int num, @RequestParam int currentPage,
								HttpSession session){

		String photo=service.getData(num).getPhoto();
		System.out.println(photo);

		if(photo!="no"){
			String[]photoArr=photo.split(",");
			for (int i=0;i<photoArr.length;i++){

				String path=session.getServletContext().getRealPath("/membersave");

				File file=new File(path+"/"+photo);
				file.delete();
			}
		}

		service.deleteReBoard(num);

		return "redirect:list?currentPage="+currentPage;
	}

}
