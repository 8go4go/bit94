package day08;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("문자열 테스트 ");
		String s = new String("a");
		long start = System.currentTimeMillis() / 1000;
		
		for(int i=0; i < 100000; i++) {
			s += i;
		}
		
		long end = System.currentTimeMillis() / 1000;
		
		
		System.out.println("걸린 시간 : " + (end - start) + "초");
		
		start = System.currentTimeMillis() / 1000;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < 100000; i++) {
			sb.append(i);
		}
		
		end = System.currentTimeMillis() / 1000;
		System.out.println("걸린 시간 : " + (end - start) + "초");
	}
}
