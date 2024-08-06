package Stack2;

public class 피보나치 {
	public static void main(String[] args) {
		
		int result2 = fibo2(45);
		System.out.println(result2);
		
		int result3 = mFibo(45);
		System.out.println(result3);
		
		int result = fibo(45);
		System.out.println(result);
		
		
		
	}
	
	static int fibo (int N) {
		if (N <= 1)
			return N;
		return fibo(N - 1) + fibo(N - 2);
	}
	
	static int fibo2 (int N) {
		int[] arr = new int[100];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[N];
	}
	
	static int[] dp = new int[500]; // dp -> 다이나믹프로그래밍 약자
//	static {
//		dp[1] = 1;
//	}
	
	static int mFibo (int N) {
		if (N <= 1)
			return N;
		
		if (dp[N] > 0)
			return dp[N]; // 저장된 값이 있으면 그것을 반환
		
		return dp[N] = mFibo(N - 1) + mFibo(N - 2); // 저장된 값이 없으면 계산
	}
	
	
	
}
