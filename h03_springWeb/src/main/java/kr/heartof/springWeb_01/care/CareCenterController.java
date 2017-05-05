package kr.heartof.springWeb_01.care;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CareCenterController {
	
	@RequestMapping("/care/bbs")
	public String showBBS() {
		return "care/bbs";
	}
}
