package 배열2차원;

import java.util.*;

public class Array3_델타연습 {
	//델타 배열 선언
	//				   0  1  2  3
	//			   	     상   하   좌  우
	static int[] dr = {-1, 1, 0, 0}; // 선언과 동시에 초기화 할 경우 new 키워드 X
	static int[] dc = {0, 0, -1, 1};
			
	// 2차원 배열 만들기
	static int[][] map = new int[5][5]; // 5*5배열
	
	// 행 열 선언
	static int r = 2;
	static int c = 2;
	
	public static void printmap() {
		
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (r == row && c == col) {
					System.out.print('O');
				} else {
					System.out.print('X');
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		printmap();
		
		// 이동
		while(true) {
			System.out.println("이동할 값을 입력하세요 ( 0: 상 | 1: 하 | 2: 좌 | 3: 우 )");
			int d = sc.nextInt();
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 이동 거리 제약
			if(0 <= nr && nr < map.length && 0 <= nc && nc < map[0].length) {
				r = nr;
				c = nc;
			} else {
				System.out.println("배열 크기를 벗어납니다.");
			}
			
			// 이동 위치 출력
			printmap();
		}
		
	
	}

}
