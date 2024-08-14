package SWEA_1218_괄호짝짓기;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> stack;
	static Map<Character, Character> map = new HashMap<>();
	
	public static int findPair(String str) {
		stack = new Stack<>(); // stack 새로 생성
		for (int i = 0; i < str.length(); i++) {
			if(map.containsKey(str.charAt(i))) { // 닫는 괄호 나오면 스택에 넣기
				stack.push(str.charAt(i)); 
			} else {
				if (map.get(stack.pop()) != str.charAt(i)) { // 가장 상단에 있는 (최근에 넣은 괄호)와 비교했을 때 짝이 맞지 않으면 0 반환
					return 0;
				}
			}
		}
		if (!stack.isEmpty()) { 
			return 0;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		map.put('<', '>');
		
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 1; t++) {
			int N = sc.nextInt();
			int res = findPair(sc.next());
			System.out.println("#" + t + " " + res);
		}
		
		
	}
}