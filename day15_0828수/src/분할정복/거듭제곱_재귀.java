package 분할정복;

public class 거듭제곱_재귀 {
	static int C = 2;
	static int N = 10;
	
	public static void main(String[] args) {
		System.out.println(pow(C, N));
	}
	
	static int pow(int C, int N) {
		// 기저 조건
		if (N == 1) {
			return C;
		}
		
		// 재귀 호출 (짝수 | 홀수)
		if (N % 2 == 0) {
			int tmp = pow(C, N/2);
			return tmp * tmp;
		} else {
			int tmp = pow(C, (N-1)/2);
			return tmp * tmp * C;
		}
	}
}
