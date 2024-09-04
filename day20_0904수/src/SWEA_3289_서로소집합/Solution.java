package SWEA_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String ans = "";
			
			// 집합 만들기
			p = new int[n+1];
			
			for (int i = 1; i < p.length; i++) {
				p[i] = i;
			} // makeSet 끝
			
			int[][] cal = new int[m][3];
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 3; j++) {
					cal[i][j] = sc.nextInt();
				}
			}// 입력 끝
			
			
			
			for (int i = 0; i < m; i++) {
				int x = cal[i][1];
				int y = cal[i][2];
				
				if (cal[i][0] == 0) { // 0으로 시작하면 합집합
					union(x, y);					
				} else { // 1로 시작하면 같은 집합에 속해있는지 확인
					if(findSet(x) == findSet(y)) {
						ans += 1;
					} else {
						ans += 0;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		}// tc
		
	}
	
	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
			return p[x];
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
