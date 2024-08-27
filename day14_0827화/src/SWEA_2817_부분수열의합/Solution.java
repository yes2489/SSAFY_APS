package SWEA_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int ans;
	static boolean[] sel;
	static int[] nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			nums = new int[N];
			sel = new boolean[N];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			powerset(0);
			System.out.println("#" + t + " " + ans);
			
		}
	}
	
	static void powerset(int idx) {
		// 기저 조건
		
		if (idx >= N) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					cnt += nums[i];
				}
			}
			// 부분집합의 합이 k가 되는 경우의 수
			if (cnt == K) {
				ans ++;
			}
			return;
		}
		
		// 재귀 호출
		sel[idx] = true;
		powerset(idx + 1);
		
		sel[idx] = false;
		powerset(idx + 1);

	}
}