package 배열1차원;

public class Array01_배열의순회 {

	public static void main(String[] args) {
		
		// 배열의 초기화
		int[] arr = new int[6];
		int[] arr2 = {3, 4, 5, 1, 2};
		
//		arr = new int[6];
//		arr2 = {3, 4, 5, 1, 2};  이 방법은 초기화 할 때만 가능
		
		// 정방향 순회
		System.out.print("정방향 순회 : ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print (arr[i] + ", ");
		}
		System.out.println();
		
		// 역방향 순회
		System.out.print("역방향 순회 : ");
		for(int i = arr2.length -1; i >= 0; i--) {
			System.out.print(arr2[i] + ", ");
		}
		System.out.println();
		
		
	}

}
