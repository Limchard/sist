package answer.data;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AnswerController {

	@Autowired
	AnswerDaoInter ainter;
	
	@PostMapping("/board/ainsert")
	public String answerinsert(@ModelAttribute AnswerDto adto,@RequestParam String currentPage) {
		
		//DB에 추가
		ainter.insertAnswer(adto);
		
		return "redirect:content?num="+adto.getNum()+"&currentPage="+currentPage; 
	}
	
	@GetMapping("/board/adelete")
	@ResponseBody
	public HashMap<String, Integer> answerDelete(@RequestParam int idx,@RequestParam String pass){ // {"idx":1}
		
		int check=ainter.checkPassAnswer(idx, pass);
		
		if(check==1) {
			ainter.deleteAnswer(idx);
		} 
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("check", check); // {"check":1}
		
		return map;
	}
	
}
