package 그래프최소비용2;


import java.util.Scanner;

public class 프림01_반복문 {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int V = sc.nextInt(); // 정점의 번호 0번부터 시작
		int E = sc.nextInt(); // 간선의 수
		
		// 인접행렬 방식으로
		int[][] adjArr = new int[V][V];
		
		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			
			adjArr[A][B] = adjArr[B][A] = W; // 무향
		}// 입력 끝
		
		// 방문체크
		boolean[] visited = new boolean[V]; // 해당 정점 뽑았는지 판별
		int[] p = new int[V]; // 부모 - 사용하지 않을거라면 굳이 작성 x
		int[] dist = new int[V]; // key라고 표현했던 선택한 간선의 가중치
		
		// 프림 1. 초기화
		
		for (int i = 0; i < V; i++) {
			p[i] = -1; // 0번 정점도 사용하니까
			dist[i] = INF;
		}
		
//		Arrays.fill(visited, false); // 위의 반복문과 동일
		
		// 프림 2. 시작정점을 결정
		dist[0] = 0;
		int ans = 0;
		
		// 프림 3. 가중치 배열을 돌면서 가장 값이 낮은 것을 골라서 방문쳌 / 갱신
		for (int i = 0; i < V; i++) { // V번 돌아도 괜찮음
			int min = INF;
			int idx = -1;
			
			// 방문하지 않았으면서 가장 작은 값 가져오기
			for (int j = 0; j < V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} // 해당 반복문이 종료가 되면 idx는 가장 작은 값을 가지고 있음 (방문x)
			visited[idx] = true; // 방문처리
			ans += dist[idx];
			
			// 방문하지 않았고 갱신할 수 있으면 갱신(idx)
			for(int j = 0; j < V; j++) {
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j]) {
					dist[j] = adjArr[idx][j];
					p[j] = idx; // 필요시
				}
			}
		}// 끝
		
//		int ans = 0;
//		for (int i = 0; i < V; i++) {
//			ans += dist[i];
//		} // 위랑 동일
		
		System.out.println(ans);
		
	}
	
	
	
	static String input = "7 11\r\n"
			+ "0 1 32\r\n"
			+ "0 2 31\r\n"
			+ "0 5 60\r\n"
			+ "0 6 51\r\n"
			+ "1 2 21\r\n"
			+ "2 4 46\r\n"
			+ "2 6 25\r\n"
			+ "3 4 34\r\n"
			+ "3 5 18\r\n"
			+ "4 5 40\r\n"
			+ "4 6 51\r\n"
			+ "";
}
