package kr.heartof.member;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.heartof.member.ui.LoginUI;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/application-config.xml");
		
//		ctx.refresh();
		LoginUI ui = ctx.getBean("memberUi", LoginUI.class);
		ui.service();
		ui.close();
		ctx.close();
	}
}
