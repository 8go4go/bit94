package day08.quiz;

public class Quiz02 {
	private boolean startWidth(String str1, String str2) {
		int result =str1.indexOf(str2);		
		
		return result > 0 ? true : false;
	}
	
	public static void main(String[] args) {
		Quiz02 q = new Quiz02();
		
		boolean isResult = q.startWidth("hello world", "hel");
		
		System.out.println(isResult);
	}
}
