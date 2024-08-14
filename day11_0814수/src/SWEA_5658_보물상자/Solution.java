package SWEA_5658_보물상자;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Solution {
	static List<String> res;
	static char[] list;
	static Queue<Character> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 총 testcase 수

		queue = new LinkedList<>();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 입력받을 숫자의 개수
			int K = sc.nextInt(); // K번째로 큰 수

			String testNum = sc.next(); // N개의 숫자

			list = new char[testNum.length()]; 
			res = new ArrayList<>();

			for (int i = 0; i < testNum.length(); i++) {
				 list[i] = testNum.charAt(i);
			} // list에 N개 숫자 삽입

			for (int i = 0; i < N/4; i++) {
           		 // i번째 회전 상태에 맞게 숫자를 큐에 채우기
                for (int j = 0; j < N; j++) {
               		 // 현재 회전 상태에서의 인덱스를 계산 (시계방향 회전)
                    int index = (j + i) % N;
                    queue.offer(list[index]);
                 }

				String[] arr = new String[4];

				for (int j = 0; j < 4; j++) {
					String pass = "";
					for (int k = 0 ; k < N/4; k++) {
						pass += queue.poll();
					}
					arr[j] = pass;
				}
				for(int j = 0; j < 4; j++) {
					res.add(arr[j]);
				}			
			}// N/4 회전 끝

			// 중복 제거
			Set<String> uniqueNum = new HashSet<>(res);
			
			// 16진수로 변환 후 10진수 리스트로 변환
			List<Integer> sortNum = new ArrayList<>();
            
			for (String s : uniqueNum) {
				sortNum.add(Integer.parseInt(s, 16));
			}

			// 정렬
			Collections.sort(sortNum, Collections.reverseOrder());

			// k번째 큰 수
			int result = sortNum.get(K-1);

			// 출력
			System.out.println("#" + t + " " + result);
		}
	}
}
