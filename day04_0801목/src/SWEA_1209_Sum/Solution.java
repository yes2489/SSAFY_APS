package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 각 행의 합, 각 열의 합, 각 대각선의 합 중 
		// 최댓값을 구하는 프로그램.
		        
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];

		// 동일한 최댓값이 있을 경우, 하나의 값만 출력한다.
		for (int t = 0; t < 10; t++) { // 총 10개의 테스트 케이스가 주어진다.
				int T = sc.nextInt();
				for (int i = 0; i < 100; i++) {
					for(int j = 0; j < 100; j++) {
						arr[i][j] = sc.nextInt();
					}
				} // arr 문자 채우기
					
		int sum = 0;
		int rowcnt = 0; // 각 행의 합
		int colcnt = 0; // 각 열의 합
		int digcnt1 = 0; // 각 왼-오 대각선의 합
		int digcnt2 = 0; // 각 오-왼 대각선의 합
					
		// 각 행의 합
		for(int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {
				sum += arr[r][c];
			}
			if (rowcnt <= sum) {
				rowcnt = sum;
				sum = 0;
			} else {
				sum = 0;
			}
		}
					
		// 각 열의 합
		for (int c= 0; c < 100; c++) {
			for (int r = 0; r < 100; r++) {
				sum += arr[r][c];
			}
			if (colcnt <= sum) {
				colcnt = sum;
				sum = 0;
			} else {
				sum = 0;
			}
		}
					
		// 대각선의 합
		for (int r = 0; r < 100; r++) {
			sum += arr[r][r];
		}
		if (digcnt1 <= sum) {
			digcnt1 = sum;
			sum = 0;
		} else {
			sum = 0;
		}
		
		// 대각선의 합2
		for (int r = 0; r < 100; r++) {
			sum += arr[r][99-r];
		}
		if (digcnt2 <= sum) {
			digcnt2 = sum;
			sum = 0;
		} else {
			sum = 0;
		}
		
		// 가장 큰 값 찾기
		int[] max = {rowcnt, colcnt, digcnt1, digcnt2};
		int maxcnt = max[0];
		for (int i = 0; i < max.length; i++) {
			if (maxcnt <= max[i]) {
				maxcnt = max[i];
			}
		}
		System.out.println("#" + T + " " + maxcnt);
		maxcnt = 0;
		}
	}
}