package day02;

public class Test02 {
	public static void main(String [] args) {
		String a = "100";
		String b = "200";
		int c = 100;
		int d = 200;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println(c + d + a); // 300100
		System.out.println(a + c + d); // 100100200
	}
}