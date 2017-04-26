package kr.heartof.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.heartof.board.ui.BoardUI;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/application-config.xml");
		
//		ctx.refresh();
		BoardUI ui = ctx.getBean("ui", BoardUI.class);
		ui.service();
		
		ctx.close();
	}
}
