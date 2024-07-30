package SWEA_2068_최대수구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		// 10개의 수를 입력 받아, 그 중에서 가장 큰 수를 출력하는 프로그램을 작성하라.
		
		// 제약사항 : 각 수는 0 이상 10000 이하의 정수
		
		// 입력 : 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] arr = new int[T][10];
		
		// 각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
			// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
			System.out.println("#"+(i+1) +" "+ max);
			max = 0;
		}
		
	}
}