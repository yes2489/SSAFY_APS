package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int [n][n];
			
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for (int ar = 0; ar < n-m-1; ar++) {
				for (int ac = 0; ac < n-m-1; ac++) {
					int cnt = 0;
					for (int j = ar; j < ar + m; j++) {
						for (int k = ac; k < ac + m; k++) {
							cnt += arr[j][k];
						}
					}
					if (max < cnt) {
						max = cnt;
					}
					
				}
			}
			System.out.println(max);
		}
	}
	
}