package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService service;

	@GetMapping("/member/myinfo")
	public String info(Model model) {
		

		List<MemberDto> list=service.getAllMembers();
		
		model.addAttribute("list", list);
		
		return "/member/myinfo";
	}
	
	@GetMapping("/member/list")
	public ModelAndView list() {
		
		ModelAndView model=new ModelAndView();
		
		List<MemberDto> list=service.getAllMembers();
		
		model.addObject("list", list);
		model.addObject("totalCount", list.size());
		
		model.setViewName("/member/memberlist");
		
		return model;
	}
	
	@GetMapping("/member/form")
	public String form() {
		
		return "/member/addform";
	}
	
	// 아이디체크
	@GetMapping("/member/idcheck")
	public @ResponseBody Map<String, Integer> idCheck(@RequestParam String id) {
		
		Map<String, Integer> map=new HashMap<>();
		
		int idcheck=service.getSerchId(id);
		
		map.put("count", idcheck); // 0 or 1 이 나온다.		
		
		return map;
	}
	
	// isnert (list로 가는데.. admin이 아니면 gaipsuccess로 이동할 예정)
	@PostMapping("/member/insert")
	public String insertMember(@ModelAttribute MemberDto dto,
			@RequestParam MultipartFile myphoto,
			HttpSession session) {
		
		// 업로드할 위치 구하기
		String path=session.getServletContext().getRealPath("/membersave");
				
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		// 업로드할 파일 dto에 들어갈 이름 얻기..		
		String fileName=sdf.format(new Date())+myphoto.getOriginalFilename();
		
		// dto 저장
		dto.setPhoto(fileName);
		
		try {
			myphoto.transferTo(new File(path+"/"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.insertMember(dto);
		
		return "redirect:list";
	}
	
	// 사진 삭제는 ajax 로 진행할꺼에요~ // 반환값을 void로 한다. ajax는 포워드가 없다. 해당 페이지에서 바로 진행하기 때문.
	@GetMapping("/member/delete")
	@ResponseBody
	public void deleteMember(@RequestParam String num) {
		service.deleteMember(num);
	}
	
	@PostMapping("/member/updatephoto")
	@ResponseBody
	public void photoupload(@RequestParam String num,
			MultipartFile photo,
			HttpSession session) {
		
		// 업로드할 경로
		String path=session.getServletContext().getRealPath("/membersave");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName=sdf.format(new Date())+photo.getOriginalFilename();
		
		// 업로드하기
		try {
			photo.transferTo(new File(path+"/"+fileName));
			
			service.updatePhoto(fileName, num); // db 사진 수정
			
			session.setAttribute("loginphoto", fileName); // 세션사진수정
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 나의 정보 삭제
	@GetMapping("/member/deleteme")
	@ResponseBody
	public void deleteinfo(@RequestParam String num,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/membersave");
		String photo=service.getDataByNum(num).getPhoto();
		File file=new File(path+"/"+photo);
		file.delete();
		
		
		service.deleteMember(num);
		
		session.removeAttribute("loginok");
		session.removeAttribute("saveok");
		session.removeAttribute("myid");
		session.removeAttribute("loginphoto");
		
	}
//	// 나의 정보 받아오기
//	@GetMapping("/member/umodal")
//	public MemberDto umodal(@RequestParam String num) {
//		
//		MemberDto mdto=service.getDataByNum(num);
//		
//		return mdto;
//	}
	
	// 나의 정보 업데이트
	@PostMapping("/member/updateinfo")
	@ResponseBody
	public void updateinfo(@ModelAttribute MemberDto mdto) {

		service.updateMember(mdto);
		
	}
	
	
	
}