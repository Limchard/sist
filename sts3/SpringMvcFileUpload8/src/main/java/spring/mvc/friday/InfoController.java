package spring.mvc.friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InfoController {
	
	@Autowired
	InfoDao idao;
	
	@Autowired
	InfoInter inter;
	
	@GetMapping("/info/list")
	public ModelAndView list(@RequestParam(defaultValue = "name") String title, @RequestParam(required = false)String serch) {
		
		ModelAndView mview=new ModelAndView();
		int totalCount=idao.getTotalCount();
		
//		List<InfoDto> list=inter.getAllDataOfMyInfo();
		System.out.println(title+","+serch);
		
		Map<String, String> map=new HashMap<String, String>();
		map.put("serch", serch);
		map.put("title", title);
		
		List<InfoDto> list=inter.getAllDataOfMyInfo(map);
		
		mview.addObject("count", totalCount);
		mview.addObject("list",list);
		
		mview.setViewName("/info/infolist");
		
		return mview;
	}
	
	@GetMapping("/info/addform")
	public String addform() {
		
		return "info/addForm";
	}
	
	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto idto, @RequestParam MultipartFile upload, HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photo="";
		
		// 사진선택을 안했을 경우 no.. 
		if(upload.getOriginalFilename().equals("")) {
//			photo=null;
			photo="no";
		} else {
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			
			// 업로드
			try {
				upload.transferTo(new File(path+"/"+photo));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		// dto의 Photo에 업로드 한 것을 넣어줘야 한다.
					idto.setPhoto(photo);
					
					// insert
					inter.insertMyInfo(idto);
		
		return "redirect:list";
	}
	
	@GetMapping("/info/uform")
	public String uform(@RequestParam String num,Model model) {
		InfoDto idto=inter.getData(num);
		
		model.addAttribute("idto", idto);
		
		return "info/updateform";
	}
	
	@PostMapping("/info/update")
	public String update(@ModelAttribute InfoDto idto,@RequestParam MultipartFile upload,HttpSession session,String num) {
		String path=session.getServletContext().getRealPath("/resources/image/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		String photoname; // dto에 담을 변수
				
		// 기존사진삭제
		String photo=inter.getData(num).getPhoto();
				
		if(!photo.equals("no")) {
					
			File file=new File(path+"/"+photo); // 이미지중에 내가 고른 사진
			file.delete();
		}
		
		// 사진 선택안할경우 null
		if(upload.getOriginalFilename().equals("")) {
			photoname=null;
		} else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			
			// 업로드
			try {
				upload.transferTo(new File(path+"/"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	// dto의 Photo에 Upload한 photoname을 넣어준다.
		idto.setPhoto(photoname);
		
		//update
		inter.updateMyInfo(idto);
		
		return "redirect:list";
	}
	
	@GetMapping("/info/delete")
	public String deleteInfo(@RequestParam String num,HttpSession session) {
		
		// 파일삭제
		String photo=inter.getData(num).getPhoto();
		
		if(!photo.equals("no")) {
			String path=session.getServletContext().getRealPath("/resources/image/"); 
			
			File file=new File(path+"/"+photo); // 이미지중에 내가 고른 사진
			file.delete();
			
		}
		
		// db삭제
		inter.deleteInfo(num);
		
		return "redirect:list";
	}
	
}
