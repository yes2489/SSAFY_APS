package SWEA_1267_작업순서;

import java.util.Scanner;

public class Solution {
	static int V, E; // V : 정점개수, E : 간선개수
	static int[][] graph; // 관계 그래프
	static int[] visit; // 방문
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			graph = new int[V+1][V+1];
			visit = new int[V+1];
			
			// 그래프 반대로 연결
			for (int i = 0; i < E; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				graph[y][x] = 1;
			}
			
			System.out.print("#" + t + " ");
			
			for (int i = 1; i <= V; i++) {
				if(visit[i] == 0) {
					dfs(i);
				}
			}
			System.out.println();
		} // testcase
	} // main
	
	static void dfs(int x) {
		visit[x] = 1;
		
		for (int i = 1; i <= V; i++) {
			if(graph[x][i] == 1 && visit[i] == 0) {
				dfs(i);
			}
		}
		
		System.out.print(x + " ");
	} // dfs
}