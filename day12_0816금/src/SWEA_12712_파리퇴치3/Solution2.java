package SWEA_12712_파리퇴치3;

import java.util.Scanner;

public class Solution2{
	static int[][] arr;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt(); // 배열 크기
			M = sc.nextInt(); // 파리퇴치용 스프레이 크기
			
			arr = new int[3*N][3*N];// 파리 개체 배열
			
			for (int r = N; r < 2*N; r++) {
				for (int c = N; c < 2*N; c++) {
					arr[r][c] = sc.nextInt();
				} 
			} // 파리 배열 입력 끝
			
			int res = flyget();
			
			System.out.println("#" + t + " " + res);
					
		}
	}
	
	static int flyget() {
		int max = 0;
		
		for (int r = N; r < 2*N; r++) {
			for (int c = N; c < 2*N; c++) {
				int sum = 0;
				
				// 십자로 잡을 경우
				for (int i = -M + 1; i < M; i++) {
					sum += arr[r][c + i];
					sum += arr[r + i][c];
				}
				
				sum -= arr[r][c]; // 중복으로 추가한 값 제거
				
				max = Math.max(max, sum);
				
				sum = 0;
				
				// 대각선으로 잡을 경우
				for (int i = -M + 1; i < M; i++) {
					sum += arr[r + i][c + i];
					sum += arr[r - i][c + i];
				}
				
				sum -= arr[r][c];
				
				max = Math.max(max, sum);
				
			}
		}
		return max;
	}
}
