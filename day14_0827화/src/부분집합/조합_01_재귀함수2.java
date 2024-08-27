package 부분집합;

import java.util.Arrays;

public class 조합_01_재귀함수2 {
	static String[] items = {"상추", "패티", "토마토", "치즈"};
	static int N, R; // N : 재료의 수, R: 내가 뽑고 싶은 재료의 수
	static String[] sel; // 뽑은 재료들을 저장할 배열
	public static void main(String[] args) {
		N = 4;
		R = 2;
		sel = new String[R];
		combination(0, 0);
		
	}
	
	// idx : 재료의 인덱스
	// sidx : 내가 뽑은 재료의 인덱스
	public static void combination (int idx, int sidx) {
		// 기저조건
		if (sidx == R) { 
			// 모든 재료를 전부 다 뽑음
			System.out.println(Arrays.toString(sel));
			return;
		}
		// 내가 이미 범위를 정해두고 반복문을 돌릴것이라 범위를 벗어날 걱정 할 필요가 없음
		// 재귀부분
			
		for (int i = idx; i <= N-R+sidx; i++) {
			sel[sidx] = items[i]; // 뽑은 재료
			combination(i+1, sidx+1);
		}
			
	}

}