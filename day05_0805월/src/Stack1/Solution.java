package Stack1;

import java.util.Stack;

public class Solution {
	
	static String[] stack = new String[100];
	// 마지막에 들어간 데이터의 index를 가리키는 top
	static int top = -1;
	
	
	
	public static void main(String[] args) {
//		// 스택의 구현
//		Stack<String> stack = new Stack<>();
//		
//		stack.push("고양이");
//		stack.push("토끼");
//		stack.push("쥐");
//		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(stack.pop());
//		}
		
		push("고양이");
		push("토끼");
		push("쥐");
		
		
		while(!isEmpty()) {
			String popItem = pop();
			System.out.println(popItem);
		}
		
//		for(int i = 0; i <= 100; i++) {
//			push(i + "");
//		}
		
		
	}
	
	static boolean isEmpty() { // 비어있으면 true
//		if (top == -1) {
//			return true;
//		}
//		return false;
		return top == -1;
	}
	
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	static void push(String item) {
		if (isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return; // 변화없이 넘어감
		}
		stack[++top] = item;
	}
	
	
	static String pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		/* String popItem = stack[top];
		 * stack[top--] = null;
		 * retrun popItem;
		 */
		return stack[top--];
	}
	
	static String peek() { // 스택의 top에 있는 원소를 반환
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return stack[top];
	}
	
}