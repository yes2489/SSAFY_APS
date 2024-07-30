package SWEA_1984_중간평균값구하기;

import java.util.Arrays;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		
		// 제약사항 : 각 수는 0 이상 10000 이하의 정수
		
		// 입력  : 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고,
		Scanner sc = new Scanner(System.in);
			
		int t = sc.nextInt();
		// 그 아래로 각 테스트 케이스가 주어진다. (10개의 수를 입력받기)
		for (int i = 0; i < t; i++) {
			int[] arr = new int[10];
			for (int j = 0; j < 10; j++) {
			arr[j] = sc.nextInt();
			}

			// 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라
			Arrays.sort(arr); // 배열 정렬
					
			double sum = 0;
					
				for(int k = 1; k < 9; k++) { // 인덱스 1 ~ 8 까지만 sum에 추가 -> 최대값, 최소값 제외
				sum += arr[k];
			}
		
			// Math.round() => 값을 가장 가까운 정수나 지정된 소수 자릿수로 반올림
			// (소수점 첫째 자리에서 반올림한 정수를 출력한다)
			int avg = (int) Math.round(sum/8);
			
			System.out.println("#" + (i+1) + " " + avg);
		}
			
	}
}