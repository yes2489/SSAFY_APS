package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			getFly(n, m);
			int res = getFly(n, m);
			System.out.println(res);
		}
	}
	
	
	
	static int getFly(int n, int m) {
		Scanner sc = new Scanner(System.in);
		// 파리 배열 생성
		int[][] arr = new int[n][n];
		for(int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		// 파리 최대값 출력
		int max = 0;
		for (int r = 0; r < n-m-1; r++) {
			for (int c = 0; c < n-m-1; c++) {
				int sum = 0; // 죽은 파리 수
				for (int rm = r; rm < r + m; rm++) {
					for (int cm = c; cm < c + m; cm++) {
						sum += arr[rm][cm];
					}
				}
				if (max < sum) {
					max = sum;
				}
			}
		}
		return max;
	}
}