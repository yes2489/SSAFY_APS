package SWEA_4613_러시아;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 행
			int M = sc.nextInt(); // 열
			char[][] flag = new char[N][M]; // 국기 배열
			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for (int c = 0; c < M; c++) {
					flag[r][c] = line.charAt(c);
				}
			} // 현재 국기 상태
			
			// 국기 색깔 별 올 수 있는 범위
			// w : 첫 번째 줄 부터 N-2까지
			// b : 두 번째 줄 부터 N-1까지
			// r : 세 번째 줄 부터 N까지
			
			int[][] max = new int[N][3];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (flag[r][c] == 'W') {
						max[r][0]++; 
					} else if (flag[r][c] == 'B') {
						max[r][1]++;
					} else {
						max[r][2]++;
					}
				}
			}
			
			System.out.println(Arrays.deepToString(max));
		}
	}
}