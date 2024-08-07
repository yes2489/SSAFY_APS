package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
    static int N; // 밑수
    static int M; // 지수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) { // 10개의 테스트 케이스 반복
            int T = sc.nextInt(); // 테스트 케이스 번호
            N = sc.nextInt();
            M = sc.nextInt();

            // 계산 결과 출력
            System.out.println("#" + T + " " + NM(M));
        }
    }

    // 재귀 함수를 이용하여 N의 M제곱을 계산하는 함수
    static int NM(int m) {
        // 기저 조건
        if (m == 0) {
            return 1;
        } else {
            // 재귀 호출
            return N * NM(m - 1);
        }
    }
    
}
