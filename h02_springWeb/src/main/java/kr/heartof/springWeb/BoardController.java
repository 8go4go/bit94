package kr.heartof.springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.heartof.springWeb.command.BoardCommandImpl;
import kr.heartof.springWeb.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardCommandImpl boardCommand;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("boardList", boardCommand.list());
		
		return "board/list";
	}
	
	@RequestMapping("/detail")
	public String detail(BoardVO vo, Model model) {
		model.addAttribute("detail", boardCommand.detail(vo));
		
		return "board/detail";
	}
	
	@RequestMapping("/write")
	public String writeForm() {
		return "board/writeForm";
	}
	
	@RequestMapping("/writeOk")
	public String writeOk(BoardVO vo, Model model) {
		model.addAttribute("result", Boolean.valueOf(boardCommand.insert(vo)));
		return "board/writeOk";
	}
}
