package SWEA_5658_보물상자;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Solution {
	static List<String> resA;
	static char[] list;
	static Queue<Character> queue;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 총 testcase 수
		
		queue = new LinkedList<>();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 입력받을 숫자의 개수
			int K = sc.nextInt(); // K번째로 큰 수
			
			String testnum = sc.next(); // N개의 숫자
			
			list = new char[testnum.length()]; 
			resA = new ArrayList<>();
			
			for (int i = 0; i < testnum.length(); i++) {
				 list[i] = testnum.charAt(i);
			} // list에 N개 숫자 삽입
			
			
			for (int i = 0; i < N/4; i++) {
				// 회전 할 때 마다 queue 채우기
				for (int j = i; j < list.length; j++) {
					queue.offer(list[j]);
				}
				// 1회전부터는 앞에서 빠진 수 끝에 추가하기
				if (i != 0 ) {
					for (int j = 0; j < i; j++) {
						queue.offer(list[j]);
					}
				}
				// 다시 보니...마지막에 추가된 수를 뽑고 맨 앞에 추가해야 하네여....ㅎ..ㅎ.ㅎㅎ.ㅎ.ㅎ.ㅎㅎㅎ....
				
				
				String[] arr = new String[4];
				
				for (int j = 0; j < 4; j++) {
					String pass = "";
					for (int k = 0 ; k < N/4; k++) {
						pass += queue.poll();
					}
					arr[j] = pass;
				}
				for(int j = 0; j < 4; j++) {
					resA.add(arr[j]);
				}			
			}// N/4 회전 끝
			
			// 16진수로...만들기...

			
			// 중복 제거

			
			// 정렬

			
			// k번째 큰 수
			
			
			// 출력
//			for (int i = 0; i < resA.size(); i++) {
//				System.out.print(resA.get(i) + " ");
//			}
//			확인용....하핫

		}
	}

}
