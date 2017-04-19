package day08.exam;

public class Exam03 {
	public static void main(String[] args) {
		System.out.println(leftPad("JAVA", 10, '#'));
		System.out.println(leftPad("C", 10, '$'));
		System.out.println(leftPad("S-CORE ", 10, '*'));
		System.out.println(leftPad("BIT JAVA", 5, '@'));
	}

	public static String leftPad(String value, int pad, char c) {
		String padStr = "";
		if(value.length() < pad) {
			int mod = pad - value.length();
			for(int i=0; i <= mod; i++) {
				padStr = padStr + c; 
			}
		} else if(value.length() == pad){
			padStr = null;
		} else {
			value = value.substring(0, pad);
		}
		
		return String.valueOf(padStr + value);
	}
}
