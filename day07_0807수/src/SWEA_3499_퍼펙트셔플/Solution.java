package SWEA_3499_퍼펙트셔플;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	// 반으로 나누기
	// 홀수일때는 첫 번째 놓는쪽에 한 장 더 추가
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<String> queue1 = new LinkedList<>();
		Queue<String> queue2 = new LinkedList<>();
		
		int T = sc.nextInt(); 
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 카드 수
			if (N %2 == 0) {
				for (int n = 0; n < N/2; n++) {
					queue1.offer(sc.next());
				}
				for (int n = N/2; n < N; n++) {
					queue2.offer(sc.next());
				}
				
				System.out.print("#" + t + " ");
				
				while(!queue1.isEmpty()) {
					System.out.print(queue1.poll() + " ");
					System.out.print(queue2.poll() + " ");
				}
				System.out.println();
				
			} else {
				for (int n = 0; n < (N+1)/2; n++) {
					queue1.offer(sc.next());
				}
				for (int n = (N+1)/2; n < N; n++) {
					queue2.offer(sc.next());
				}
				
				System.out.print("#" + t + " ");
				
				while(!queue2.isEmpty()) {
					System.out.print(queue1.poll() + " ");
					System.out.print(queue2.poll() + " ");
				}
				System.out.println(queue1.poll());
			}
		}
	}
}
