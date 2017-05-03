package kr.heartof.auction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuctionManinController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/member")
	public String register() {
		return "member/register";
	}
	
	@RequestMapping("/products/item")
	public String itemDetail() {
		return "item";
	}
	
	@RequestMapping("/member/login")
	public String showLogin() {
		return "member/login";
	}
}
