package day07;

public class Test01 {
	public static void main(String[] args) {
		Sub01 s = new Sub01();
		
		s.method01();
		s.method02(10);
		int i = 100;
		s.method02(i);
		s.method03(1,2);
		s.method04('c');
		s.method04('a');
		s.method05("a");
		s.method06(new int[]{1,2,3,4});
	}
}
