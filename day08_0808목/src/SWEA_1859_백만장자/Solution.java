package SWEA_1859_백만장자;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// 1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
	    // 2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
	    // 3. 판매는 얼마든지 할 수 있다.
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // testcase
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			int sum = 0;
			int sell = 0;
			int cnt = 0;
			
			for (int i = 1; i < N; i++) {
				// if 1. 아무것도 사지 않는게 최대 이익
				
				// else 2. 최대 이익 구하기
			}
		
			max = sell - sum;
			System.out.println("#" + t + " " + max);
			
		}
		
	}
	
}