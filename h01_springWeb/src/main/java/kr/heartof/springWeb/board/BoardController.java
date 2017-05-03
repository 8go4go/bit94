package kr.heartof.springWeb.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	@RequestMapping("/write")
	public String writeView(HttpServletRequest req, Model model) {
		return "board/write";
	}
	
	@RequestMapping("/writeOk") 
	public String writeBoard(BoardVO vo, Model model) {
		System.out.println(vo.getNo());
		System.out.println(vo.getTitle());
		System.out.println(vo.getWriter());
		System.out.println(vo.getContent());
		
		model.addAttribute("result", "true");
		return "board/writeOk";
	}
	
	@RequestMapping("/delete")
	public String deleteView(Model model) {
		return "board/delete";
	}
	
	@RequestMapping("/deleteOk")
	public String deleteBoard(BoardVO vo, Model model) {
		System.out.println(vo.getNo());
		return "board/deleteOk";
	}
	
	@RequestMapping("/modify")
	public String modifyView() {
		return "board/modify";
	}
	
	@RequestMapping("/modifyOk")
	public String modifyBoard(BoardVO vo, Model model) {
		System.out.println(vo.getNo());
		return "board/modifyOk";
	}
		
		
}
