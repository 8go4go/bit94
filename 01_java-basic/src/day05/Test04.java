package day05;

public class Test04 {
	public static void main(String[] args) {
		int[] iArr = {1,2,3};
		
		
		
		for (int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		for (int i : iArr) {
			System.out.println(i);
		}
		
		boolean[] bArr = {true, false, true};
		
		for(boolean b : bArr) {
			System.out.println(b);
		}
	}
}
