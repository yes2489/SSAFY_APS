package 배열2차원;

public class Array3_순회연습2 {

	public static void main(String[] args) {
		int n = 5;
		int m = 5;
		int[][] arr = new int[n][m];
		int num = 1;
		
		// 초기화
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				arr[r][c] = num++;
			}
		}
		
		// 행 우선 순회
		System.out.println("[행 우선 순회]");
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("==================================");
		
		// 열 우선 순회
		System.out.println("[열 우선 순회]");
		for (int c = 0; c < arr[0].length; c++) {
			for (int r = 0; r < arr.length; r++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println("==================================");
		
		// 지그재그 순회
		System.out.println("[지그재그 순회]");
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (r%2 == 0) { // 짝수행
					System.out.print(arr[r][c] + " "); // 정방향
				} else { // 짝수행
					System.out.print(arr[r][m-1-c] + " "); // 역방향
				}
			}
			System.out.println();
		}
	}

}
