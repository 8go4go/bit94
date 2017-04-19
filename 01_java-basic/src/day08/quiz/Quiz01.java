package day08.quiz;

public class Quiz01 {
	
//	public String remove(String data, char delch) {
//		
//		String returnStr = data.replaceAll("[o]", "");
//		return returnStr;
//	}
//			
	public String remove(String data, char delch) {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i < data.length(); i++) {
			if(delch == data.charAt(i)) {
				continue;
			} else {
				sb.append(data.charAt(i));
			}
		}
		
		String returnStr = data.replaceAll("[o]", "");
		return returnStr;
	}
			
	
	public static void main(String[] args) {
		Quiz01 q = new Quiz01();
		System.out.println(q.remove("Hello World", 'o'));
	}
}
