package SWEA_2805_농작물;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

//주말동안 다시 풀어보기 -08/09
public class Solution2 { // 중앙지점과 거리 차이가 N/2 이하인 칸만 더해주기
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("input.txt"));

		int T = sc.nextInt(); // 테스트케이스
		
		for(int test = 1; test <= T; test++) {
			
			int N  = sc.nextInt(); // 한 변의 길이
			
			int[][] board = new int[N][N];
			
			// 배열 채우기
			for (int r = 0; r < N; r++) {
				String line = sc.next();
				for(int c = 0; c < N; c++) {
					board[r][c] = line.charAt(c) - '0'; //문자열에서 정수로 만들려면 - '0' 필수
				}
			}
			
			// 마름모 형태로 순회
			int sum = 0;
			int start = N / 2;
			int end = N / 2;
			
			for (int r = 0; r < N; r++) {
				for(int c = start; c <= end; c++) {
					sum += board[r][c];
				}
				if(r < N /2) { // 한 행을 돌고나서 행 번호가 절반보다 작을 경우 start--, end++
					start--;
					end++;
				} else { // 행 번호가 절반보다 클 경우 start++, end--
					start++;
					end--;
				}
			}
			System.out.println("#"+test+" "+sum);
		}
	}
}