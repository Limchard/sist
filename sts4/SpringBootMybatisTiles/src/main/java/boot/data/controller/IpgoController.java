package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import boot.data.dto.IpgoDto;
import boot.data.mapper.IpgoMapperInter;

@Controller
public class IpgoController {

	@Autowired
	IpgoMapperInter mapper;
	
	@GetMapping("/")
	public String start() {
		
		return "/layout/main"; // redirect는 Mapping 주소로 보내는 것.
	}
	
	@GetMapping("/ipgo/list")
	public ModelAndView list() {
		
		ModelAndView model=new ModelAndView();
		
		int totalCount=mapper.getTotalCount();
		List<IpgoDto> list=mapper.getAllIpgos();
		
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		
		// model.setViewName("ipgolist"); jsp resolver // jsp 경로로 찾아가기!
		model.setViewName("/ipgo/ipgolist"); // tiles 경로로 찾아가기!
		
		return model;
	}
	
	@GetMapping("/ipgo/ipgoform")
	public String form() {
		return "/sub/ipgo/ipgoform";
	}
	
	@PostMapping("/ipgo/insert")
	public String insert(@ModelAttribute IpgoDto dto,
			@RequestParam ArrayList<MultipartFile> photo,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/upload");
		System.out.println(path);
		
		String uploadName="";
		
		if(photo.get(0).getOriginalFilename().equals("")) {
			uploadName="no";
		} else {
			for(MultipartFile f:photo) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename();
				uploadName+=fName+",";
				
				// 실제 업로드
				try {
					f.transferTo(new File(path+"/"+fName)); // 업로드 폴더에 실제로 파일이 들어가는 작업.
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// photo 마지막 컴마 제거
			uploadName=uploadName.substring(0, uploadName.length()-1);
		}
		
		// dto에 넣어주기!
		dto.setPhotoname(uploadName);
		
		// db에 넣기!
		mapper.insertIpgo(dto);
		
		return "redirect:list";
	}
	
		
}
