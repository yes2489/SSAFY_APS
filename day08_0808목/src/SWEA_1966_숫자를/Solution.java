package SWEA_1966_숫자를;

import java.util.Scanner;

public class Solution {
	static int[] nums;
	
	public static void main(String[] args) {
		// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.
		// - 삽입정렬로 풀어보기
		
		// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
		// 각 테스트 케이스의 첫 번째 줄에 N 이 주어지고, 다음 줄에 N 개의 숫자가 주어진다.
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 가장 첫 줄 테스트 케이스 T
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 테스트케이스 정렬해야하는 수 N개
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			} // 입력받은 n개 숫자로 배열 완성
			
			
			
			// 삽입정렬
			for (int i = 1; i < nums.length; i++) {
				int data = nums[i];
				int j;
				for (j = i-1; j >= 0 && nums[j] > data; j--) {
					nums[j + 1] = nums[j];
				}
				nums[j + 1] = data;
			}
			System.out.print("#" + t + " ");
			// 출력
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
		
	}
	
	
}