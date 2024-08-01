import java.util.Arrays;

public class String_문자열뒤집기 {

	public static void main(String[] args) {
		// Java에서는 문자열 읽기는 가능, 특정 위치 문자 쓰기 X
		String str = new String("algorithm");
		
		char[] charArr = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
//		System.out.println(Arrays.toString(charArr));
		
		// 1. 새로운 배열을 만들어서 뒤집기
		
		char[] nextArr = new char[str.length()];
		
		// 원본 배열 정방향 순회하면서 새 배열에 뒤에서부터 써주기
		for (int i = 0; i < charArr.length; i++) {
			nextArr[charArr.length -1 -i] = charArr[i];
		}
//		System.out.println(Arrays.toString(nextArr));
		
		// 2. 원본 배열에서 스왑
		
		char[] charArr2 = str.toCharArray(); // toCharArray(); : 문자열을 char로 반환
		System.out.println(Arrays.toString(charArr2));
		
		
		int N = charArr2.length;
		for(int i = 0; i < N / 2; i++) { // 앞의 절반에 대해서만 swap 진행
			char tmp = charArr2[i];
			charArr2[i] = charArr2[N-1-i];
			charArr2[N-1-i] = tmp;
		}
		System.out.println(Arrays.toString(charArr2));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String nextStr = "";
//		for (int i = 0; i < charArr2.length; i++) {
//			nextStr += charArr2[i];
//		}
//		
//		// 문자열을 더하는 과정 반복마다 새로운 문자열 객체 생성
//		
//		System.out.println(nextStr);
//		
	}

}
