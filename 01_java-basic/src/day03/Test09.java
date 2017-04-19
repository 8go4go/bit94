package day03;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		
		//Scanner cannot be resolved to a type
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		//nextLine()은 엔터값도 읽은 후 제외한다.
		String name = sc.nextLine();
		System.out.println("name : " + name);
		
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());

		System.out.println("age : " + age);
		
	}
}