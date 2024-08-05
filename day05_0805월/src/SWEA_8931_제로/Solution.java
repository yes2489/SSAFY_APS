package SWEA_8931_제로;

import java.util.Scanner;

public class Solution {
	static int[] stack;
	static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); // 첫 번째 테스트 케이스
			stack = new int[N];
			
			// N만큼 값 입력 -> stack에 쌓기
			for (int n = 0; n < N; n++) {
				int money = sc.nextInt();
				if (money == 0) { // 0일 경우 최근 사용하지 않은 수 지우기
					pop();
				} else {// 0이 아니면 stack에 쌓기
				push(money);
				}
//				System.out.println(Arrays.toString(stack));
//				System.out.println(top);
			}
			
			// stack에 남아있는 수의 합 구하기
			int sum = 0;
			while(!isEmpty()) {
				int pop = pop();
				sum += pop;
			}
			System.out.println("#" + (t+1) + " " + sum);
		}
		
	}
	
	// isFull
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	// isEmpty
	static boolean isEmpty() {
		return top == -1;
	}
	
	// push
	static void push(int money) {
		if(isFull()) {
			System.out.println("스택이 가득찼습니다.");
			return;
		}
		stack[++top] = money;
	}
	
	// pop
	static int pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return 0;
		}
		return stack[top--];
	}
	
}