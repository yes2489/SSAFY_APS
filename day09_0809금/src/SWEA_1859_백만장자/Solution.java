package SWEA_1859_백만장자;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// 연속된 N일동안의 물건의 매매가를 알고있음
		// 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구매
		// 판매는 얼마든지 가능
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int[] price = new int[N];
			for(int i  = 0; i < N; i++) {
				price[i] = sc.nextInt();
			} // 입력 끝
			
			long res = 0;
			
			int[] max = new int[N];
			
			// 마지막 날의 최댓값은 그 날의 판매 가격과 같음
			max[N-1] = price[N-1];
			
			for (int i = N-2; i >= 0; i--) {
				// 현재 최대값은 price[i]와 max[i+1]중 더 큰 값으로 설정
				max[i] = Math.max(price[i], max[i+1]);
				// 해당 날짜에 물건을 사서 다음 날 최댓값에 해당하는 날에 판매했을 때 얻을 수 있는 이익
				res += max[i] - price[i];
			}
			
			System.out.println("#" + test + " " + res);
			
		}
		
	}
}
