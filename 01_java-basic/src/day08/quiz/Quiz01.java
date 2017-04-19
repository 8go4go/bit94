package day08.quiz;

public class Quiz01 {
	
	public String remove(String data, char delch) {
		
		String returnStr = data.replaceAll("[o]", "");
		return returnStr;
	}
			
	
	
	public static void main(String[] args) {
		Quiz01 q = new Quiz01();
		System.out.println(q.remove("Hello World", 'o'));
	}
}
