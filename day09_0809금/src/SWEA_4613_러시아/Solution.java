package SWEA_4613_러시아;

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
			
			// 각 행에서 칠해야하는 w, b, r의 수
			int[] white = new int[N];
			int[] blue = new int[N];
			int[] red = new int[N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (flag[r][c] != 'W') {
						white[r]++; 
					}
					if (flag[r][c] != 'B') {
						blue[r]++;
					}
					if (flag[r][c] != 'R') { 
						red[r]++;
					}
				}
			}
			
//			System.out.println(Arrays.toString(white));
//			System.out.println(Arrays.toString(blue));
//			System.out.println(Arrays.toString(red));
			
			// 국기 색깔 별 올 수 있는 범위
			// w : 첫 번째 줄 부터 N-2까지 
			// b : 두 번째 줄 부터 N-1까지
			// r : 세 번째 줄 부터 N까지
			
			// 일단 저장할 수 있는 가장 큰 수를 저장해두고, 작은 수를 찾으면 그것으로 변경예정
			int min = Integer.MAX_VALUE; 
			
			// w, b 범위
			for (int wEnd = 1; wEnd < N-1; wEnd++) {
				int bStart = wEnd+1;
				int cnt = 0;
				
				// w영역
				for(int i = 0; i < wEnd; i++) {
					cnt += white[i];
				}
				
				// b영역
				for(int i = wEnd; i < bStart; i++) {
					cnt += blue[i];
				}
				
				// r영역
				for(int i = bStart; i < N; i++) {
					cnt += red[i];
				}
				min=Math.min(min, cnt); // 두 개의 수 중 더 작은 수를 선택
			}
			
			
			System.out.println("#"+ t + " " + min);
		}
	}
}
