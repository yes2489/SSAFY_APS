package 부분집합;

import java.util.Arrays;

public class 부분집합_01_반복문3 {
	static String[] items = {"단무지", "햄", "오이", "시금치"};
	static int N = 4; // 재료의 수
	static boolean[] sel = new boolean[N]; // 해당 인덱스의 재료를 사용 했는지의 유무를 저장하는 배열
			
	public static void main(String[] args) {
		N = 4;
		sel = new boolean[N];
		
		powerset(0);
		
	}
	
	// N은 이미 static 하니까 들고 다닐 필요X
	// idx : 내가 어떤 재료를 선택할지에 대한 인덱스
	public static void powerset(int idx) {
		// 기저조건
		if (idx >= N) {
			String tmp ="김밥: ";
			for (int i = 0; i < N; i++) {
				if (sel[i])
				tmp += items[i];
			}
			System.out.println(tmp);
			return;
		}
		
		// 재귀호출
		sel[idx] = true;
		powerset(idx + 1);
		
		sel[idx] = false;
		powerset(idx + 1);
		
	}

}
