package SWEA_7102_준홍이의카드놀이;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		// 입력
		// 첫 줄에 테스트케이스 T
		// 각 테스트케이스의 첫 번째 줄에는 두 개의 정수가 공백 하나로 구분
		Scanner sc = new Scanner(System.in);
				
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N+M+1];
		
			// N+M 계산 -> 인덱스에 값 ++
			for (int n = 1; n <= N; n++) {
				for (int m = 1; m <= M; m++) {
					arr[m+n]++;
				}
			}
			// 최대값 찾기
			int max = 0;
//			for (int i = 2; i <= N+M; i++) {
//				max = Math.max(arr[i], max); // Math.max => 최대값 구하기
//			}
			
			for(int i = 2; i <= N+M; i++) {
				if (max < arr[i]) {
					max = arr[i];
				}
			}
			
			
			// 출력
			System.out.print("#" + t + " ");
			for (int i = 0; i <= N+M; i++) {
				// max값을 가진 arr[i] 찾기;
				if(max == arr[i]) {
					System.out.print(i + " "); // index출력
				}
			}
			System.out.println();
		}
		
	}
}