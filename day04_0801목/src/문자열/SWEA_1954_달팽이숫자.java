import java.util.Scanner;

public class SWEA_1954_달팽이숫자 {

	//델타 배열
	//					0  1  2  3
	//				    우  하  좌  상
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	static int r = 0;
	static int c = 0;
	
	public static void main(String[] args) {
		
		
		// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] testCase = new int[T];
		// 각 테스트 케이스에는 N이 주어진다.
		for(int i = 0; i < T; i++) { // 테스트 케이스 N -> testCase 배열에 삽입
			testCase[i] = sc.nextInt();
		}
		
		for(int i = 0; i < T; i++) {
			int n = testCase[i];
			if (n <= 1 && n <= 10) {
				int[][] snail = new int[n][n]; // n*n 달팽이 배열
				int d = 0; // 방향 전환
				for (int num = 1; num < n*n ; num++) {
					snail[r][c] = num;
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nr < n || nc < 0 || nc < n || snail[nr][nc] != 0) {
						// 범위를 벗어나거나 다음 배열이 초기값이 아닐경우 방향 전환
						d = (d+1)%4;
					}
					r = nr;
					c = nc;
				}
				System.out.println("#"+(i+1));
				for(int row = 0; row < n; row++) {
					for(int col = 0; col < n; col++) {
						System.out.print(snail[row][col]);
					}
					System.out.println();
				}
			}
		}
		
	}

}
