package kr.heartof.springWeb_01.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionController {
	@RequestMapping("/service/main")
	public String showServiceMain() {
		return "service/main";
	}
	
	@RequestMapping("/service/item") 
	public String showServiceItem() {
		return "service/item";
	}
	
	
}
