package SWEA_1974_스도쿠;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = 9;
			int[][] sudoku = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					sudoku[r][c] = sc.nextInt();
				}
			}
			
			int answer = 0;
			
			if (check(N, sudoku)) {
				answer = 1;
			}
			
			System.out.println("#" + test + " " + answer);
			
		}
	}
	
	static boolean check(int N, int[][] sudoku) {
		// 행 검증
		for (int r = 0; r < N; r++) {
			boolean[] count = new boolean[10];
			for (int c = 0; c < N; c++) {
				int num = sudoku[r][c];
				if (count[num])
					return false;
				count[num] = true;
			}
		}
		// 열 검증
		for (int c = 0; c < N; c++) {
			boolean[] count = new boolean[10];
			for (int r = 0; r < N; r++) {
				int num = sudoku[r][c];
				if (count[num])
					return false;
				count[num] = true;
			}
		}
		// 3x3 영역 검증
		boolean[][][] count = new boolean[3][3][10];
		
		for(int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int num = sudoku[r][c];
				int i = r / 3;
				int j = c / 3;
				
				if(count[i][j][num])
					return false;
				count[i][j][num] = true;
			}
		}
		return true;
	}
}
		