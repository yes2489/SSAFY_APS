package SWEA_1989_초심자의외문검사;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		// 단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.
		// 각 단어의 길이는 3 이상 10 이하
		
		// 가장 첫 줄에는 테스트 케이스 개수 T가 주어지고 그 아래로 각 테스트 케이스가 주어짐
		// 각 테스트 케이스의 첫 번째 줄에 하나의 단어가 주어짐
		
		// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			String str = sc.next();
			
			// 문자열 쪼개기
			char[] ch = new char[str.length()];
			char[] hc = new char[str.length()]; // 문자 거꾸로 넣을 배열
			
			if (2 < str.length() && str.length() < 11) {
				for (int j = 0; j < str.length(); j++) {
					ch[j] = str.charAt(j);
					hc[(str.length())-1-j] = str.charAt(j); // 뒤에서부터 입력
				}
				
				if (Arrays.equals(ch, hc)) { // 배열이 일치하면?
					System.out.println("#" + (i+1) + " " + 1);
				} else {
					System.out.println("#" + (i+1) + " " + 0);
				}
			}

		}

	}
}