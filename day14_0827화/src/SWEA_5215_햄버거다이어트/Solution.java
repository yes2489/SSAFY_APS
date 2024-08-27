package SWEA_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	static int[] kcal;
	static int[] taste;
	static int N, L;
	static int max; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			kcal = new int[N];
			taste = new int[N];
			
			for (int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				kcal[i] = sc.nextInt();
			} // 입력 끝
			
			max = 0;
			
			getTasteMax(0, 0, 0);
			
			System.out.println("#" + t + " " + max);
			
		}
	}
	
	static void getTasteMax(int idx, int sKcal, int sTaste) {
		// 기저조건
		if (sKcal > L) { // sKcal : sum kcal;
			// 제한 칼로리 초과
			return;
		}
		if (idx == N) {
			// 조합 별 맛 평가점수 -> max값 갱신
			if (sTaste > max) { // sTaste : sumTaste;
				max = sTaste;
			}
			System.out.println("sTaste : " + sTaste + " max : " + max);
			return;
		}
		
		// 재귀 호출
		getTasteMax(idx + 1, sKcal + kcal[idx], sTaste + taste[idx]);
		getTasteMax(idx + 1, sKcal, sTaste);
		
	}
}
