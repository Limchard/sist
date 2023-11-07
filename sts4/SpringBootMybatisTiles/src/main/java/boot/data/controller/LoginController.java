package boot.data.controller;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class LoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/login/form")
	public String loginform(HttpSession session,Model model) {
		
		// 폼의 아이디 얻기
		String myid=(String)session.getAttribute("myid"); // set을 해줘야 get을 할 수 있다.. 그래서 여기서는 getAttribute를 쓴다.
		// 로그인 상태인지 아닌지 판단해야함
		String loginok=(String)session.getAttribute("loginok");
		
		// 한번도 실행안하면 null
		if(loginok==null) {
			return "/login/loginform";
		} else {
			
			// 로그인중이면 request에 login한 name을 저장해준다.
			String name=service.getName(myid);
			model.addAttribute("name", name);
			
			return "/login/logoutform"; // Tiles layout 을 사용했음.. 
		}
	}
	
	@PostMapping("/login/loginprocess")
	public String loginproc(@RequestParam String id,
			@RequestParam String pass,
			@RequestParam(required = false) String saveid, //400 번 뜨면 saveok에 대한거(required=false) 해줘야 함. check에 대한 처리를 안해줌.. check안했을때 null로 들어가는데 이에 대한 처리를 안해줌..
			HttpSession session) {
		
		HashMap<String, String>map=new HashMap<>();
		int check=service.loginPassCheck(id, pass);
		
		if(check==1) {
			session.setMaxInactiveInterval(60*60*8); // 8시간동안 저장..
			
			session.setAttribute("myid", id); // id 저장
			session.setAttribute("loginok", "yes"); 
			session.setAttribute("saveok", saveid); // check 박스 클릭 저장
			
			MemberDto mdto=service.getDataById(id);
			session.setAttribute("loginphoto", mdto.getPhoto()); // 로그인 완성시 왼쪽 사이드바의 이미지 바꿔봅시다.
			
			return "redirect:form";
		} else {
			return "/sub/member/passfail";
		}
	}
	
	@GetMapping("/login/logoutprocess")
	public String logout(HttpSession session) {
		
		session.removeAttribute("loginok");
		// check박스에 대한 saveid 값은 지워지면 안된다. 로그인폼에 id가 남아있어야 하니까 ㅎㅎ
		
		return "redirect:form";
	}
	
}
