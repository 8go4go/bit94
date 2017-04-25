package kr.co.mlec.board.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.mlec.board.ui.BoardUI;

public class BoardMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/application-config.xml");
		
		BoardUI ui = ctx.getBean("boardui", BoardUI.class);
		
		ui.service();
		
		ctx.close();
	}
}
