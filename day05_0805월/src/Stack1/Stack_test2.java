package Stack1;

public class Stack_test2 {
	static int[] stack;
	static int top = -1;
	
	// isEmpty
	static boolean isEmpty() {
		return top == -1;
	}
	
	// isFull
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	// push
	static void push(int i) {
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		} else {
			stack[++top] = i;
		}
	}
	
	// pop
	static int pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return -1;
		} else {
			return stack[top--];
		}
	}
	
	// peak -- stack의 top에 있는 원소를 반환
	static int peak() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return -1;
		} else {
			return stack[top];
		}
	}
	
	
}
