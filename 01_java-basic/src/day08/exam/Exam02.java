package day08.exam;

public class Exam02 {
	public static void main(String[] args) {
		System.out.println(getNextId("USER-00007"));
		System.out.println(getNextId("ORDER-00009"));
		System.out.println(getNextId("PRODUCT-00003"));
	}
	
	private static String getNextId(String id) {
		String increment = id.replaceAll("[1-9]", "");
		String others = id.replaceAll("[A-Z0\\-]", "");
		int incrementValue = Integer.parseInt(others) + 1;
		
		if(incrementValue > 9) {
			increment = increment.substring(0, increment.length() - 1);
		}
		
		return String.valueOf(increment + incrementValue);
	}
}
