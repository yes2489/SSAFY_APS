package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
    static int N; // 밑수
    static int M; // 지수
   
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        for (int t = 0; t < 10; t++) {
        	int T = sc.nextInt();
            N = sc.nextInt(); 
            M = sc.nextInt(); 

            System.out.println("#" + T + " " + pow(N, M));
        }
    }

    // 재귀 함수를 이용하여 N의 M제곱을 계산하는 함수
    static int pow(int N, int M) {
        // 기저 조건
    	if (M == 1) {
    		return N;
    	}
    	
    	// 재귀부분 : 짝수인 경우 | 홀수인 경우
    	if (M % 2 == 0) {
    		int tmp = pow(N, M/2);
    		return tmp * tmp;
    	} else {
    		int tmp = pow(N, (M-1)/2);
    		return tmp*tmp*N;
    	}
    }
    
}
