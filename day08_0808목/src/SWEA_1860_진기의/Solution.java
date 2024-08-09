package SWEA_1860_진기의;

import java.util.Arrays;
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
			
			int[] client = new int[N];
			
			for(int i = 0; i < N; i++) {
				client[i] = sc.nextInt();
			}
			
			Arrays.sort(client);
			
			String answer = "Possible";
			
			for (int i = 0; i < N; i++) {
				int time = client[i];
				
				// time / M : 지금까지 붕어빵 만드는 사이에 사이클 몇 번 돌았는가?
				// (time / M) * K : 지금까지 만들어진 붕어빵 개수
				if((time / M) * K  < i + 1) {
					answer = "Impossible";
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
		
		
		
	}
	
	
	
	
}