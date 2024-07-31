package SWEA_1954_달팽이숫자;

import java.util.Scanner;

public class Solution { 
  
  // 델타배열
  //               0  1  2  3
  //              우 하  좌 상  
  static int dr[] = {0, 1, 0, -1};
  static int dc[] = {1, 0, -1, 0};
  
  
  public static void main (String[] args) {
    // 달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
    // 다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); // testcase cnt
    
    for (int i = 1; i <= t; i++){
      // 달팽이의 크기 s는 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10) <- 이것만 설정하면.....프로그램이 멈추는 이유는......ㅠㅠㅠㅠ [24/07/31]
      int s = sc.nextInt();
      int[][] arr = new int[s][s]; // 달팽이 배열 생성
      
      int d = 0; // 현재 방향
      int r = 0;
      int c = 0;
      for(int num = 1; num <= s*s; num++){// 배열에 넣을 숫자 (s*s만큼만!!!!!!)
        arr[r][c] = num;
        int nr = r + dr[d];
        int nc = c + dc[d];
        if(nr < 0 || nr >= s || nc < 0 || nc >= s || arr[nr][nc] != 0){
          // 범위를 벗어남 OR 다음 칸에 숫자가 있음
          d = (d+1)%4; // 방향 전환 (우->하->좌->상)
          nr = r + dr[d];
          nc = c + dc[d];
        }
        r = nr;
        c = nc;
      }
    System.out.println("#" + i); // testcase num 출력
    // 배열 출력
    for(int j = 0; j < s; j++){
      for (int k = 0; k < s; k++){
        System.out.print(arr[j][k]+" ");
        }
        System.out.println();
      }
    }
  }
}