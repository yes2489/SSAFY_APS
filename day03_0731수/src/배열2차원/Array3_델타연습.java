package 배열2차원;

import java.util.*;

public class Array3_델타연습 {
	// 델타 배열 만들기
	//					0  1  2  3
	//					상  하   좌   우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
			
	// 2차원 배열 만들기
	static int[][] map = new int[5][5];
	
	// 행 열 선언
	static int r = 2;
	static int c = 2;
	
	
	public static void printmap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0;j < map[0].length; j++) {
				if (r == i && c == j) {
					System.out.print("O");
				} else {
					System.out.print("X");
				}
			}
			System.out.println();
		}
	}
		
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		printmap();
		
		// 이동
		for (; r < map.length; r++) {
			for (; c < map[0].length; c++) {
				int d = sc.nextInt();
				int nr = r + dr[d];
				int nc = c + dc[d];
			}
		}
		// 이동 거리 제약

		
	
	}

}
