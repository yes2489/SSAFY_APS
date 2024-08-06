package SWEA_1224_계산기3;

import java.util.ArrayList;

public class OpStack<E> {
	private int top; 
	private int size;
	private ArrayList<E> stack;
	
	// 생성자
	public OpStack() {
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
	
	// peek
	public E peek() {
		return stack.get(top);
	}
	
	// size
	public int getSize() {
		return size;
	}


}
