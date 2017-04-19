package day08.quiz;

public class Quiz03 {
	public String[] split(String data, String deter) {
		
		int deterCount = 0;
		
		for(int i=0; i<data.length() ; i++) {
			if(String.valueOf(data.charAt(i)).compareTo(deter) == 0) {
				deterCount++;
			}
		}
		
		String[] splites = new String[deterCount + 1];
		for(int i=0; i<splites.length ; i++) {
			int location = 0;
			if(i < deterCount) {
				location = data.indexOf(deter);
				splites[i] = data.substring(0, location);
				data = data.replaceAll(String.valueOf(splites[i] + ":"), "");
			} else {
				splites[i] = data;
			}
		}	
		return splites; 
	}
	
	
	public static void main(String[] args) {
		Quiz03 q = new Quiz03();
		String[] result = q.split("33:홍길동:서울:a@a.com", ":");
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
