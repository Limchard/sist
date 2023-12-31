package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardWriteController {
	
	@Autowired
	BoardDao bdao;

	
	@GetMapping("/board/writeform")
	public ModelAndView form(@RequestParam Map<String, String>map) {
		ModelAndView mview=new ModelAndView();
		
		// 아래 5개는 답글일 경우에만 넘어온다. 새글일 경우에는 안넘어온다.
		String currentPage=map.get("currentPage");
		String num=map.get("num");
		String regroup=map.get("regroup");
		String restep=map.get("restep");
		String relevel=map.get("relevel");
		
		System.out.println(currentPage+","+num);
		
		// 입력폼에 hidden으로 넣어줘야함.. 답글일때 대비
		mview.addObject("currentPage", currentPage==null?"1":currentPage); // 얘는 default 값을 1로 설정해줬음.
		mview.addObject("num", num==null?"0":num);
		mview.addObject("regroup", regroup==null?"0":regroup);
		mview.addObject("restep", restep==null?"0":restep);
		mview.addObject("relevel", relevel==null?"0":relevel);
		
		// 0으로 넣어야 dao에서 새글로 인식
		// 폼이 답글,새글 공용이므로..	
		
		mview.setViewName("reboard/writeform");
		return mview;
	}
	
	@PostMapping("/board/insert")
	public String insert(@ModelAttribute BoardDto bdto,@RequestParam ArrayList<MultipartFile>uimage,HttpSession session,
			@RequestParam String currentPage) {
		
		// 실제경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/photo");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(currentPage);
		String photo="";
		
		if(uimage.get(0).getOriginalFilename().equals("")) {
			photo="no";
		} else {
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
		
		// insert
		bdao.insertReboard(bdto);		
		
		
		int maxNum=bdao.getMaxNum();
		
//		return "redirect:list"; // content 일단 없어서 목록으로 이동.. 나중에 content로 경로 변경 예정.
		return "redirect:content?num="+maxNum+"&currentPage="+currentPage;
	}
	
	
}
