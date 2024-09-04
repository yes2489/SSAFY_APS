package SWEA_7465_창용;

import java.util.Scanner;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // n = 마을에 사는 사람의 수
			int m = sc.nextInt(); // m = 서로 알고 있는 사람의 관계 수
			int ans = 0; // 무리의 수
			
			p = new int[n+1];
			
			for (int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			int[][] arr = new int[m][2];
			
			for (int i = 0; i < m; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
				int x = arr[i][0];
				int y = arr[i][1];
				union(x, y);
			}
			
			
			for (int i = 1; i <= n; i++) {
				if(p[i] == i) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
		}
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
