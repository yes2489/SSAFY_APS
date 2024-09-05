package SWEA_1238_Contact;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    // 좌표를 나타내는 pos 클래스 정의
    public static class pos{
        int x,y;
        
        pos(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    // N:배열 크기, ans:최소값, dir:방향
    static int N, ans;
    static int dir[][] = new int[][] {{1,0},{0,-1},{-1,0},{0,1}};  // 하, 좌, 상, 우 방향

    static boolean[][] visited; //방문 여부 체크
    static int[][] sum; // 각 위치까지의 최소 합을 저장
    static int [][] arr; // 입력받을 배열

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            ans = Integer.MAX_VALUE; // 최소값을 최대값으로 초기화
            N = sc.nextInt(); // 배열 크기 N
            arr = new int[N][N];
            visited = new boolean[N][N];
            sum = new int[N][N];

            for(int i = 0; i < N; i++) {
                Arrays.fill(sum[i], Integer.MAX_VALUE);
            }

            for(int i = 0; i < N; i++) {
                String str = sc.next(); // 한 줄의 문자열 입력받기
                for(int j = 0; j < N; j++) {
                    arr[i][j] = str.charAt(j) - '0';
                }
            }// 입력 끝

            // 시작점(0,0)의 최소 합을 0
            sum[0][0] = 0;

            // bfs로 최소 경로를 계산
            bfs(0, 0);

            System.out.println("#" + t + " " + sum[N-1][N-1]);
        }
    }

    public static void bfs(int x, int y) {
       
        Queue<pos> q = new LinkedList<>(); // 좌표를 저장할 큐
        q.offer(new pos(x, y));

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            pos next = q.poll();

            // 4방향(상, 하, 좌, 우)으로 이동 가능한지 확인
            for(int i = 0; i < 4; i++) {
                int nx = next.x + dir[i][0];
                int ny = next.y + dir[i][1];

                // 새로운 좌표가 배열 범위 내에 있는지 확인
                if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    // 새로운 좌표에서의 경로 합이 현재 경로 합보다 작은 경우 갱신
                    if(sum[nx][ny] > arr[nx][ny] + sum[next.x][next.y]) {
                        sum[nx][ny] = arr[nx][ny] + sum[next.x][next.y]; // 최소 경로 합 갱신
                        q.offer(new pos(nx, ny)); // 새로운 좌표 큐에 넣기
                    }
                }
            }
        }
    }
}
