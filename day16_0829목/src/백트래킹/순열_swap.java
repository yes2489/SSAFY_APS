package 백트래킹;

import java.util.Arrays;

public class 순열_swap {
	static int[] nums;
	static int N; // nums의 length 길이
	
	public static void main(String[] args) {
		nums = new int[] {1, 2, 3};
		N = nums.length;
		
		perm(0); // 0번 위치부터 판단
	}
	
	
	// idx = 현재 판단 위치
	static void perm(int idx) {
		// 기저조건
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
		}
		// 재귀부분
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx); // 다음 과정을 위해 원상복구
		}
		
	}

	// 바꾸고 싶은 배열이 static하게 선언 -> 위치만 인자로 보내도 됨
	static void swap(int i, int idx) {
		int tmp = nums[i];
		nums[i] = nums[idx];
		nums[idx] = tmp;
		
	}
}
