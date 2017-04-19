package day02.quiz;

public class Quiz02 {
	public static void main(String[] args) {
		
		int i = 0;
		
		try {
			i = 100;
		} 
		catch(Exception e) {
			i = -1;
		}
		finally {
			System.out.println(i);
		}
		
	}
}
