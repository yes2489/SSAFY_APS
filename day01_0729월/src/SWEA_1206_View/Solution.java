package SWEA_1206_View;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		// 1206. VIEW
		// 양쪽 모두 거리 2 이상의 공간이 확보될 때 조망권이 확보된다고 말한다.
		Scanner sc = new Scanner(System.in);
		
		for (int test = 1; test <= 10; test++) {
			int T = sc.nextInt(); // 건물개수 T
			int[] arr = new int[T];
			int sum = 0;
			for(int t = 0; t < T; t++) {
				arr[t] = sc.nextInt();
			} // 입력 끝
			
			for(int i = 2; i < T -2; i++) { // 양 옆 2칸씩 빈 공간
				int max = 0;
				// 왼쪽 조망권 max
				max = Math.max(arr[i-2], arr[i-1]);
				
				// 오른쪽 조망권 max
				max = Math.max(max, arr[i+1]);
				max = Math.max(max, arr[i+2]);
				// 조망권 확보 세대 수
				if(max < arr[i]) {
					sum += (arr[i] - max);
				}
				
			}
			System.out.println("#" + test + " " + sum);
			
		}
		
	}

}
