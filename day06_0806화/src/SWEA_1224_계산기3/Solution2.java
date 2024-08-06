package SWEA_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

public class Solution2 {
	
	static Map<Character, Integer> map = new HashMap<>();
	//전역변수로 고정
	static {
		map.put('+', 1);
		map.put('*', 2);
	} 
	
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 for (int i = 0; i < 10; i++) {
			 int T = sc.nextInt(); // 테스트케이스 길이
			 String infix = sc.next();
			 String postfix = infix(infix);
			 System.out.println(postfix);
			 
			 int res = postfix(postfix);
			 System.out.println(res);
		 }

	}
	
	
	static String infix(String N) {
		String postfix = "";
		OpStack<Character> stack = new OpStack<>();
		
		for (int i = 0; i < N.length(); i++) {
			char c = N.charAt(i);
			
			// 피연산자가 나오는 경우 바로 출력
			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(' ) { // 열린괄호 -> stack에 push
				stack.push(c);
			} else if(c == ')') { //
				while(!stack.isEmpty() && stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop(); // '(' 제거
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' 
						&& map.get(stack.peek()) >= map.get(c)){
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		return postfix.toString();
	}
	
	
	static int postfix(String postfix) {
		OpStack<Integer> stack = new OpStack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			
			if('0' <= c && c <= '9') {
				stack.push(c - '0'); // c는 문자이기 때문에 '0'을 빼줘야 정수화 됨
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result = 0;
				
				if ( c == '+') {
					result = num1 + num2;
				} else if (c == '*') {
					result = num1 * num2;
				}
				
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
}

