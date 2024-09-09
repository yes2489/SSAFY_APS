package 위상정렬;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬01_Queue {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수 (1번부터 시작)
		int E = sc.nextInt(); // 간선의 개수

		int[][] adjArr = new int[V + 1][V + 1];
		int[] degree = new int[V + 1]; // 진입차수를 저장할 배열

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjArr[A][B] = 1; // 가중치 X -> 1로 표기
			degree[B]++;// 진입차수 증가
		} // 입력끝

		// 위상정렬 큐 
		// 1. 진입차수가 0인 친구들을 몽땅 넣기
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				queue.add(i);
			}
		}

		StringBuilder sb = new StringBuilder();

		// 2. 큐가 공백상태가 될때까지 진행
		// 간선을 제거하고, 진입차수가 0이되면 새롭게 큐에 넣기
		while (!queue.isEmpty()) {
			int curr = queue.poll();
//			System.out.println(cook[curr]); //위상정렬 수행한 결과
			sb.append(cook[curr]).append("\n");

			for (int i = 1; i < V + 1; i++) {
				// 무향에선 인덱스의 순서가 중요치 않음
				// 유향에선 인덱스의 순서가 중요함
				if (adjArr[curr][i] == 1) {
					degree[i]--; // 진입차수 하나 깎기
					adjArr[curr][i] = 0; // 사실 이건 안해도 괜찮음
					// 만약 이번에 i 정점의 진입차수가 0이 되었다면
					if (degree[i] == 0)
						queue.add(i);
				}
			}
		}

		System.out.println(sb);

	}

	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7\r\n" + "";
}
