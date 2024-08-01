package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 수
		int T = sc.nextInt();
		for (int t=1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			
			// n*n 배열
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c]=sc.nextInt();
					}
				}
			
			// 최대값 변수 생성
			int max = 0;
			
			// 전체 탐색
			for (int r = 0; r < n - m + 1; r++) {// 시작좌표 (n-m)=> m*m이 갈 수 있는 마지막 좌표 | sx => start x
				for (int c = 0; c < n -m + 1; c++) {// sy => start y
					int sum =0;
					for (int x = 0; x < m; x++) {
						for (int y = 0; y < m; y++) {
							sum += arr[r+x][c+y];
							}
						}
					if (max < sum)
						max = sum;
					}
				}
				System.out.println("#"+(t) + " " + max);
			}
	}
}
