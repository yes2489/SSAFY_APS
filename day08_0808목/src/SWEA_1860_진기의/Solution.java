package SWEA_1860_진기의;

import java.util.Scanner;

public class Solution {
	
	static int[] t;
	// 그래서 오늘은 N명의 사람이 자격을 얻었다.

	// 진기는 0초부터 붕어빵을 만들기 시작하며, M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다.

	// 0초 이후에 손님들이 언제 도착하는지 주어지면, 
	
	// 모든 손님들에게 기다리는 시간없이 붕어빵을 제공할 수 있는지 판별하는 프로그램을 작성하라.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 자격을 얻은 사람
			int M = sc.nextInt(); // 붕어빵 만드는 시간
			int K = sc.nextInt(); // 만들 수 있는 붕어빵 수
			for (int i = 0; i < N; i++) { // 사람이 도착하는 시간
				t = new int[N];
				t[i]= sc.nextInt();
			}
			
			// 1. 붕어빵을 만드는 시간보다 사람이 빨리 도착하면 Impossible
			for (int i = 0; i < M; i++) {
				if(M < t[i]) {
					System.out.println("#" + tc + " " + "Impossible");
					break;
				}
			}
			
			
			// 2. 시간 내에 만들 수 있는 붕어빵보다 사람이 더 많이 도착하면 Impossible
//			for(int i = 0; i < M*N; i++) {
//				if (M >= t[i] && ) {
//					
//				}
//			}
//			
			// 나머지 possible
			
			
		}
		
		
		
	}
	
	
	
	
}