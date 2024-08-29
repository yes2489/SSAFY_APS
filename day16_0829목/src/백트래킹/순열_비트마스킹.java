package 백트래킹;

import java.util.Arrays;

public class 순열_비트마스킹 {
	static int[] nums;
	static int N; // nums의 length 길이
	static int[] res; // 결과 저장 배열
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		res = new int[N];
		perm(0, 0);
	}
	
	
	// idx = 결과 배열에 저장 할 위치
	// visit = 사용한 원소를 기록하기 위한 정수
	static void perm(int idx, int visit) {
		// 기저조건
//		if (visit == (1 << N) - 1) return; // N개의 비트가 전부 다 1로 가득 참
		if (idx == N) {
			System.out.println(Arrays.toString(res));
		}
		// 재귀부분
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) != 0) { // & 연산  // (x << y) : 정수 x의 각 비트를 y만큼 왼쪽으로 이동 (빈자리는 0으로 채워짐)
				continue;
			}
			res[idx] = nums[i];
			perm(idx + 1, visit | (1 << i)); // 다음 자리 판단
		}
		
	}
}
