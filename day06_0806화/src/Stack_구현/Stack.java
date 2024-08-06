package Stack_구현;

public class Stack {
	
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
	
	// pop
	static int pop() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return -1;
		} else {
			return stack[top--];
		}
	}
	
	// push
	static void push(int item) {
		if(isFull()) {
			System.out.println("스택이 가득 찼습니다.");
			return;
		}
		stack[++top] = item;
	}
	
	// peek
	static int peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있습니다.");
			return -1;
		}
		return stack[top];
	}
	
}
