package Stack_구현;

import java.util.ArrayList;

public class StackAL<E> {
	private int top; 
	private int size;
	private ArrayList<E> stack;
	
	// 생성자
	public StackAL() {
		this.top = -1;
		this.size = 0;
		this.stack = new ArrayList<>();
	}
	
	// 메서드
	// isEmpty
	public boolean isEmpty() {
		return top == -1;
	}
	
	
	// push
	public void push(E item) {
		top++;
		stack.add(top, item);
		size++;
		}
	
	// pop
	public E pop() { // 반환 --> E
		if(isEmpty()) {
			return null;
		} else {
			E result = stack.get(top);
			stack.remove(top);
			top--;
			size--;
			return result;
		}
	}
	
	// peak
	public E peak() {
		return stack.get(top);
	}
	
	// size
	public int size() {
		return size();
	}


}
