package 배열2차원;

import java.util.Arrays;

public class Array3_연습문제1 {

	public static void main(String[] args) {
		int N = 5;
		int[][] board = new int[N][N];
		
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				board[r][c] = (int) (Math.random() * 100); // Math.random() = 0 이상 1 미만의 실수 랜덤 반환
			}
		}
		
		System.out.println(Arrays.deepToString(board));
		
		// 25개 각 요소에 대해서 이웃한 요소와의  차이의 총 합
		int[][] sum = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r - 1 >= 0)
					sum[r][c] += Math.abs(board[r-1][c] - board[r][c]); // 상 
					// Math.abs(); = 절댓값 반환 
				if (r+1 < N)
					sum[r][c] += Math.abs(board[r+1][c] - board[r][c]); // 하
				if (c -1 >= 0)
					sum[r][c] += Math.abs(board[r][c-1] - board[r][c]); // 좌
				if (c + 1 < N)
					sum[r][c] += Math.abs(board[r][c+1] - board[r][c]); // 우
			}
		}
		System.out.println(Arrays.deepToString(sum));
		
		// 델타
		int[][] sum2 = new int[N][N];
		
		int[] dr = {0, 0, -1, 1};
		int[] dc = {1, -1, 0, 0};
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				
				for (int d = 0; d < 4; d++) {
					int nr =r +dr[d];
					int nc = c + dc[d];
					if (0 <= nr&& nr < N && 0 <= nc&& nc < N)
						sum2[r][c] += Math.abs(board[r][c] - board[nr][nc]);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(sum2));
		
		
		
		
		
		
	}
}
