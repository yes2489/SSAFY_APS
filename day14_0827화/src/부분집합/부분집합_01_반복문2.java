package 부분집합;

import java.util.Arrays;

public class 부분집합_01_반복문2 {
	static String[] items = {"단무지", "햄", "오이", "시금치"};
	static int N = 4; // 재료의 수
	static int[] sel = new int[N]; // 해당 인덱스의 재료를 사용 했는지의 유무를 저장하는 배열
			
	public static void main(String[] args) {
		// 재료가 4개
		for (int i = 0; i <= 1; i++) {
			sel[0] = i;
			for (int j = 0; j <= 1; j++) {
				sel[1] = j;
				for (int k = 0; k <= 1; k++) {
					sel[2]= k;
					for (int l = 0; l <= 1; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}
		

	}

}
