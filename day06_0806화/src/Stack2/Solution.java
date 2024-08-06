package Stack2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	
	
	static Map<Character, Integer> map = new HashMap<>();
	
	static {
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
//		map.put('(', 0);
	} // 전역변수로 고정
	
	public static void main(String[] args) {
		// (6+5*(2-8)/2)
		
		String expression = "(6+5*(2-8)/2)";
		String postfix = infixToPostfix(expression);
		System.out.println(postfix);
		
		int result = evalPostfix(postfix);
		System.out.println(result);
		int result2 = evaluate(expression);
		System.out.println(result2);
		
	}
	
	static int evaluate (String expression) {
		String postfix = infixToPostfix(expression);
		return evalPostfix(postfix);
	}
	
	
	
	static String infixToPostfix(String infix) {	
		// 중위표기식을 후위표기식으로 변환
		
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			
			// 피연산자가 나오는 경우 바로 출력
			if('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				// 여는 괄호는 stack에 push
				stack.push(c);
			} else if (c == ')') {
				// 닫는 괄호는 여는 괄호가 나올 때 까지 pop
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
					
				}
			} else {
				// 연산자
				// 스택의 top에
				// 우선순위가 낮은 연산자가 올 때 까지 pop
				while(!stack.isEmpty() && 
						stack.peek() !='(' &&
						map.get(stack.peek()) >= map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				} 
				stack.push(c);
			}
		}
		// 스택 비워주기
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}
		
		return postfix;
	}
	
	static int evalPostfix(String postfix) {
		// 후위표기식 계산
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);
			
			
			if('0' <= c && c <= '9') {
				stack.push(c - '0'); // c는 문자이기 때문에 '0'을 빼줘야 정수화 됨
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int result;
				
				if ( c =='+') {
					result = num1 + num2;
				} else if (c == '-') {
					result = num1 - num2;
				} else if (c == '*') {
					result = num1 * num2;
				} else {
					result = num1 / num2;
				}
				
				stack.push(result);
			}
		}
		return stack.pop();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
