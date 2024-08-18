package SWEA_12712_파리퇴치3;

import java.util.Scanner;

public class Solution {
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // testcase 수
		
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt(); // 배열 크기
			map = new int[3*N][3*N]; // 범위 지정 안하는 대신 배열 크게 만들기
			int M = sc.nextInt(); // 파리 퇴치 스프레이
			for (int r = N; r < 2*N; r++) {
				for (int c = N; c < 2*N; c++) {
					map[r][c] = sc.nextInt();	
				}
			} // 파리 배열 입력 끝
			
			int max = 0;
			
			
			for (int r = N; r < 2 * N; r++) {
                for (int c = N; c < 2 * N; c++) {
                    int sum = 0;

                    // 십자 더하기
                    for (int i = -M + 1; i <= M - 1; i++) {
                        sum += map[r][c + i];
                        sum += map[r + i][c];
                    }
                    
                    // map[r][c] 중복으로 들어간 값 하나 제거
                    sum -= map[r][c];

                    max = Math.max(max, sum);

                    // 대각선과 비교 위해 sum 초기화
                    sum = 0;

                    // 대각선 더하기
                    for (int i = -M + 1; i <= M - 1; i++) {
                        sum += map[r + i][c + i]; // \ 대각선
                        sum += map[r - i][c + i]; // / 대각선
                    }
                    
                    sum -= map[r][c];

                    // 십자 max보다 큰지 비교
                    max = Math.max(max, sum);
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
