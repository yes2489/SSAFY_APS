package SWEA_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	static String[] arr1;
	static String[] arr2;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			if (N % 2 == 0) {
				// 짝수일 때 반으로 나눠서 배열에 저장
				int a = N/2;
				int b = N/2;
				arr1 = new String[a];
				arr2 = new String[b];
				for(int n = 0; n < N/2; n++) {
					arr1[n] = sc.next();
				} 
				for(int n = 0; n < N/2; n++) {
					arr2[n] = sc.next();
				}
				// 각 배열에서 하나씩 뽑아서 프린트
				System.out.print("#"+t+" ");
				for(int i = 0; i < a; i++) {
					System.out.print(arr1[i] + " " + arr2[i] + " ");
				}
				System.out.println();
			} else { // 홀수일 때 먼저놓는 쪽이 한 장 더 들어감
				int a = N/2 + 1;
				int b = N/2;
				arr1 = new String[a];
				arr2 = new String[b];
				for (int n = 0; n < N/2 + 1; n++) {
					arr1[n] = sc.next();
				}
				for(int n = 0; n < N/2; n++) {
					arr2[n] = sc.next();
				}
				System.out.print("#"+t+" ");
				for(int i = 0; i < b; i++) {
					System.out.print(arr1[i] + " ");
					System.out.print(arr2[i] + " ");
					}
				System.out.println(arr1[b]);
				}
			}
			
		}
	}
