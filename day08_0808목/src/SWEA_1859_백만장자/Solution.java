package SWEA_1859_백만장자;

import java.util.Arrays;
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
			
			int[] price = new int[N];
			
			for (int i = 0; i < N; i++) {
				price[i] = sc.nextInt();
			}
			
			long answer = 0; // 문제에서 제공된 N의 범위가 int를 넘어감
			
			int[] max = new int[N];
			max[N - 1] = price[N - 1];
			for (int i = N -2; i >= 0; i--) {
				max[i] = Math.max(price[i], max[i + 1]);
				answer += max[i] - price[i];
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
}