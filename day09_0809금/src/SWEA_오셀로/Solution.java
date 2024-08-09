package SWEA_오셀로;

import java.util.Scanner;

public class Solution {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] board;
	static int N;
	static int r;
	static int c;
	static int color;
	static int black = 0;
	static int white = 0;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트케이스 수
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			board = new int[N][N];
			// 가운데 흑돌, 백돌 놓기
			board[N/2-1][N/2-1] = 2;
			board[N/2][N/2] = 2;
			board[N/2-1][N/2] = 1;
			board[N/2][N/2-1] = 1;
			
			int M = sc.nextInt();
			for (int m = 0; m < M; m++) {
				r = sc.nextInt(); // 행
				c = sc.nextInt(); // 열
				color = sc.nextInt(); // 돌 색상
				
				play();
				
				}
			// 출력
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						black++;
					} else if (board[i][j] == 2) {
						white++;
					}
				}
			}
			System.out.println("#" + t + " " + black + " " + white);

		}
	}
	
	static void play() {
		r--; 
		c--;
		board[r][c] = color;
		int d = 0;
		for (; d < 4; d++) {
			int nr = r + dr[d]; 	
			int  nc = c + dc[d];
			if(0 <= nr && nr < N && 0 <= nc && nc < N) {// 배열 내에 있으면
				if (color != 1 && board[nr][nc] == 1) {
					board[nr][nc] = color;
					} else if (color != 2 && board[nr][nc] == 2) {
						board[nr][nc] = color;
					}
				}
			}
	}

}

