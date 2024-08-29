package SWEA_1873_상호의;

import java.util.Scanner;

public class Solution {
	
	static int H, W, N, d, x, y; // H: 행, W : 열, N : 이동 횟수, d : 현재방향, x : 현재 car이 위치한 행, y : 현재 car이 위치한 열
	static char[][] map; // 맵
	static char[] move; // 이동 방향
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];
			d = 0;
			
			for (int r = 0; r < H; r++) {
				String str = sc.next();
				for (int c = 0; c < W; c++) {
					map[r][c] = str.charAt(c);
					
					// 전차 위치 및 방향 저장
					if (str.charAt(c) == '^' || str.charAt(c) == 'v' || str.charAt(c) == '<' || str.charAt(c) == '>') {
						x = r;
						y = c;
						car(str.charAt(c));
					}
				}
			}// 초기맵 입력 끝
			
			N = sc.nextInt();
			move = sc.next().toCharArray();
			// 사용자 입력 끝
			
			int nx = 0;
			int ny = 0;
			
			// 사용자 입력 배열 도는 동안
			// case '입력' : {
			//	1. direction 변경
			// 	2. 현재 방향 입력과 동일하게 변경
			//	3. 이동 좌표 설정
			//	4. 이동 좌표 적용 후 범위 유효 확인
			//	  1) 이동 가능
			//		- 이동 전 좌표 = 기호 '.' 변경
			//		- 이동 후 좌표 = 기호 '입력' 변경
			//	  2) 이동 불가 -> break;
			for (int i = 0; i < move.length; i++) {
				
				switch (move[i]) {
				
				case 'U': {
					d = 0; // 1. direction 변경
					map[x][y] = '^'; // 2. 현재 방향 입력과 동일하게 변경
					nx = x + dr[d]; // 3. 이동 좌표 설정
					ny = y + dc[d];
					if (range(nx, ny) && map[nx][ny] == '.') { // 4. 이동 좌표 적용 후 범위 유효 확인
						map[x][y] = '.'; //	- 이동 전 좌표 = 기호 '.' 변경
						map[nx][ny] = '^'; // - 이동 후 좌표 = 기호 '입력' 변경
						x = nx;
						y = ny;
					}
					break; // 이동 불가
				}
				case 'D' : {
					d = 1;
					map[x][y] = 'v';
					nx = x + dr[d];
					ny = y + dc[d];
					if (range(nx, ny) && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = 'v';
						x = nx;
						y = ny;
					}
					break;
				}
				case 'L' : {
					d = 2;
					map[x][y] = '<';
					nx = x + dr[d];
					ny = y + dc[d];
					if (range(nx, ny) && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '<';
						x = nx;
						y = ny;
					}
					break;
				}
				case 'R' : {
					d = 3;
					map[x][y] = '>';
					nx = x + dr[d];
					ny = y + dc[d];
					if (range(nx, ny) && map[nx][ny] == '.') {
						map[x][y] = '.';
						map[nx][ny] = '>';
						x = nx;
						y = ny;
					}
					break;
				}
				case 'S' : {
					int tx = x; //
					int ty = y;
					while (range(tx, ty)) {
						tx = tx + dr[d];
						ty = ty + dc[d];
						if (range(tx, ty)) {
							if (map[tx][ty] == '*') { // 벽돌 벽일때 벽을 평지로 바꾸고 포탄 사라짐
								map[tx][ty] = '.';
								break;
							} else if (map[tx][ty] == '#') { // 강철 벽일때 포탄만 사라짐
								break;
							} else { // 물이나 평지가 나올 경우 직진
								continue;
							}
						}
					}
				}
				default : {
					break;
				}
				}
			} // 입력 배열 돌기 끝
			
			System.out.print("#" + t + " ");
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					System.out.print(map[r][c]);
				}
				System.out.println();
			} //출력

		} // testcase
	} // main
	
	// 전차 위치 및 방향 저장
		static void car(char c) {
			if (c == '^') {
				d = 0;
			} else if (c == 'v') {
				d = 1;
			} else if (c ==  '<') {
				d = 2;
			} else if (c == '>') {
				d = 3;
			}
		}
	
	//범위 확인
	static boolean range(int x, int y) {
		if (0 <= x && x < H && 0 <= y && y < W) {
			return true;
		} else {
			return false;
		}
	}
	
}