package SWEA_8931_제로;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Integer> stack = new Stack<>();
		
		int TC = sc.nextInt(); // testcase 수
		
		for(int t = 1; t <= TC; t++) {
			int K = sc.nextInt(); // 재현이가 부를 수
			for (int k = 0; k < K; k++) {
				int money = sc.nextInt();
				if (money == 0) {
					stack.pop();
				} else {
					stack.push(money);
				}
			}
			// 남아있는 액수 확인
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + t + " " + sum);
			
		}
	}
}