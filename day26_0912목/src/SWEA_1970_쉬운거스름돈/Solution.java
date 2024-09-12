package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	static int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			// 각 거스름돈 단위별로 몇 개씩 사용했는지 저장용 배열
			int[] dp = new int[coins.length];
			
			int N = sc.nextInt(); // 거스름돈 입력 끝
			
			int change = N;
			
			// 거스름돈 단위 배열 순회하며 거스름돈 계산 시작
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] > N) {
					dp[i] = 0; // 해당 화폐단위 사용 X
					continue; // 거스름돈보다 화폐 단위가 큰 경우 생략
				}
				
				// 현재 거스름돈 단위로 거슬러 줄 수 있는 동전 개수 계산
				int n = change / coins[i];
				
				// 현재 거스름돈 단위로 거스름돈을 줄 수 있을때까지 반복
				for (int j = 1; j <= n; j++) {
					change -= coins[i]; // 거스름돈에서 해당 단위만큼 빼주기
					dp[i]++; // 사용한 거스름돈 수 증가
				}
			}
			
			
			for (int i = 0; i < dp.length; i++) {
				sb.append(dp[i] + " ");
			}
			
			System.out.println("#" + t + " ");
			System.out.println(sb.toString());
			
			sb.setLength(0); // sb 초기화
			
		}// testcase
		
	}

}
