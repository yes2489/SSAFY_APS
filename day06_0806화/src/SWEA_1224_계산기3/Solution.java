package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static ArrayList<Character> stack;
	static int top = -1;
	static String infix;
	static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('+', 1);
		map.put('*', 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			infix = sc.next();
			String postfix = infix(infix);
			
			int result = Postfix(postfix);
			System.out.println("#"+(i+1) + " " + result);
			
		}
	}
	
	static String infix(String infix) {	
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
		
		static int Postfix(String postfix) { // 후위표기식
			
			Stack<Integer> stack = new Stack<>();
			
			for (int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				
				
				if('0' <= c && c <= '9') {
					stack.push(c - '0'); 
				} else {
					int num2 = stack.pop();
					int num1 = stack.pop();
					int result = 0;
					
					if ( c =='+') {
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
