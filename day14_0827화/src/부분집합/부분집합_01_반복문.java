package 부분집합;

import java.util.Arrays;

public class 부분집합_01_반복문 {
	static String[] items = {"단무지", "햄", "오이", "시금치"};
	static int N = 4; // 재료의 수
	static int[] sel = new int[N]; // 해당 인덱스의 재료를 사용 했는지의 유무를 저장하는 배열
			
	public static void main(String[] args) {
		
		// 2의 n승만큼 반복한다. i < (1 << N)
		// 여기서 i 는 하나의 김밥 종류~
		for (int i = 0; i < (1<<N); i++) { // i = 모든 김밥의 가짓수
			// 해당 재료가 있는지 없는지 확인하기위해 &연산
			String tmp = "";
			for (int j = 0; j < N; j++) { // j = 재료 종류
				if((i & (1 << j)) > 0) { // 해당 재료가 있는지 없는지 확인
					// 해당 재료가 있음
					tmp += items[j];
				}
			} // 재료 확인 끝
			System.out.println(tmp);
		}
	}
}
