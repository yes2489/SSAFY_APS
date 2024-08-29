package 백트래킹;

import java.util.Arrays;

public class 순열_방문체크 {
	static int[] nums;
	static int N; // nums의 length 길이
	static boolean[] visit; // 확인용 배열
	static int[] res; // 결과 저장 배열
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		visit = new boolean[N];
		res = new int[N];
		perm(0);
	}
	
	
	// idx = 결과 배열에 저장 할 위치
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(res));
		}
		// 재귀부분
		for (int i = 0; i < N; i++) {
			// 사용하지 않은 원소 확인
			if (visit[i]) { // 해당 자리 i번째 원소 사용 함
				continue;
			}
			res[idx] = nums[i];
			visit[i] = true; 
			perm(idx + 1); // 다음 자리 판단
			visit[i] = false; // res는 덮어씌우니 초기화 할 필요 x
		}
	}
		
}
