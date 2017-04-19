package day05;

public class Test02 {
	public static void main(String[] args) {
		
		int[] iArr = new int[3];
		
		iArr[0] = 1;
		iArr[1] = 10;
		iArr[2] = 100;
		
		for(int i = 0, len = iArr.length; i < len; i++) {
			System.out.println(iArr[i]);
		}
		
		//iArr2는 배열의 선언과 함께만 사용 가능
		int[] iArr2 = {1, 10, 100};
//		iArr2 = {2, 20, 200}; //에러
		
		//iArr3은 선언할 때가 아니어도 사용 가능
		//그러나 new하기 때문에 주소값이 바뀐다
		int[] iArr3 = new int[]{1, 10, 100};
		iArr3 = new int[]{2, 20, 200};
		
	}
}