package 위상정렬;

import java.util.Scanner;
import java.util.Stack;

public class 위상정렬02_Stack {
	static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };
	static int V, E; 
	static int[][] adjArr; //인접행렬
	static int[] degree; // 진입차수를 저장할 배열
	static boolean[] visited; //방문체크
	static Stack<Integer> ans; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 정점의 개수 (1번부터 시작)
		E = sc.nextInt(); // 간선의 개수

		adjArr = new int[V + 1][V + 1];
		degree = new int[V + 1]; 
		visited= new boolean[V+1];
		ans = new Stack<>();
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = 1; // 가중치 X -> 1로 표기
			degree[B]++;// 진입차수 증가
		} // 입력 끝
		
		for(int i = 1; i <V+1; i++) {
			if(degree[i] == 0)
				dfs(i);
		}//위상 정렬 완료
		
		while(!ans.empty()) {
			System.out.println(cook[ans.pop()]);
		}
		
		
		


	}

	private static void dfs(int curr) {
		visited[curr] =  true; //방문
		// 아직 선행 조건이 남아 있을 수 있기때문에 바로 출력 X
		for(int i = 1; i<V+1; i++) {
			if(adjArr[curr][i]==1 && !visited[i])
				dfs(i);
		}
		
		ans.push(curr); //연결되어 있는 모든 정점을 다 방문
		
	}

	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7\r\n" + "";
}
