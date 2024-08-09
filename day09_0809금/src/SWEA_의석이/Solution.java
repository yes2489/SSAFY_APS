package SWEA_의석이;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			char[][] arr = new char[5][15];
			for (int i = 0; i < 5; i++) {
				String line = sc.next();{
					for(int j = 0; j < line.length(); j++) {
						arr[i][j] = line.charAt(j);
					}
				}
			}// 글자 만들기

			// 열 탐색
			String charList = "";
			for (int c = 0; c < 15; c++) {
				for (int r = 0; r < 5; r++) {
					if ('0' <= arr[r][c] && arr[r][c] <= '9' || 
						'a' <= arr[r][c] && arr[r][c] <= 'z' || 
						'A' <= arr[r][c] && arr[r][c] <= 'Z') {
						charList += arr[r][c];
					} else {
						continue;
					}
				}
			}
			System.out.println("#" + t + " " + charList);
		}

	}

}
