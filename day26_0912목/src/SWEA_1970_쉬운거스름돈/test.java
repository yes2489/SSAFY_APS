package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int t=1; t<=T; t++) {
            int[] m = {50000, 10000, 5000, 1000, 500, 100, 50, 10}; //0 = 오만원, 1= 만원, 2= 천원권
            int[] cnt = new int[8];
            int input = sc.nextInt();
             
            int idx=0;
            for(int i:m) {
                cnt[idx] = input/i; //몫이 저장됨
                input = input - cnt[idx++]*i; // 인풋값 리뉴얼.
            }
            System.out.println("#"+t);
            for(int o:cnt) {
                System.out.print(o+" ");
            }
            System.out.println();
        }
 
    }
 
}