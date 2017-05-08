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
	
	@RequestMapping("/service/addItem")
	public String showAddItem() {
		return "service/addItem";
	}
	
	@RequestMapping("/service/auction/bid")
	public String showBid() {
		return "service/auction/bid";
	}
}
