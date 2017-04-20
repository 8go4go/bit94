package day08.exam;

public class Exam02 {
	public static void main(String[] args) {
		System.out.println(getNextId("USER-00001"));
		System.out.println(getNextId("ORDER-00009"));
		System.out.println(getNextId("ORDER-00099"));
		System.out.println(getNextId("PRODUCT-00999"));
		System.out.println(getNextId("PRODUCT-09999"));
	}
	
	private static String getNextId(String id) {
		String increment = id.replaceAll("[0-9]", "");
		String others = id.replaceAll("[A-Z0\\-]", "");
		int incrementValue = Integer.parseInt(others) + 1;
		
		increment = String.valueOf(increment) + Exam03.leftPad(String.valueOf(incrementValue), 5, '0');
		
		return increment;
	}
}
