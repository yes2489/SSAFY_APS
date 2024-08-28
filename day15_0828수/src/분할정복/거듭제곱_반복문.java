package 분할정복;

public class 거듭제곱_반복문 {
	static int C = 2;
	static int N = 10;
	
	public static void main(String[] args) {
		System.out.println(pow(C, N));
	}
	
	static int pow(int C, int N) {
		int res = 1;
		for (int i = 1; i <= N; i++) {
			res *= C;
		}
		return res;
	}
}
