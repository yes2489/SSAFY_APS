package SWEA_1228_암호문1;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// I (삽입) x y s => 앞에서부터 x의 위치 바로 다음에 y개의 숫자 삽입 s는 덧붙일 숫자
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt(); // 원본 암호문 길이
			
			LinkedList<Integer> line = new LinkedList<>();
			
			for (int i = 0; i < T; i++) {
				line.add(sc.nextInt());
			} // 원본 암호문 받기
			
			int N = sc.nextInt(); // 명령어 개수
			
			for (int i = 0; i < N; i++) {
				sc.next(); // 삽입 I 버림
				int x = sc.nextInt(); // 삽입 위치
				int y = sc.nextInt(); // y개 삽입
				for (int s = 0; s < y; s++) {
					line.add(x+s, sc.nextInt());
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(line.get(i) + " ");
			}
			System.out.println();
			
		}
	}
}