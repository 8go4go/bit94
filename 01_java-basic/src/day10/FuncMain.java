package day10;

public class FuncMain {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println(System.currentTimeMillis());
		}).start();
		
		
		
		Func add = (int a, int b) -> {return a + b;};
		Func add2 = (int a, int b) -> a - b;
		
		
		
		System.out.println(add.add(10, 19));
		
	}
}
