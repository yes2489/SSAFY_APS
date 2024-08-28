package 분할정복;

import java.util.Arrays;

public class 퀵정렬_hoare파티션 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length; // 배열의 길이
	
	public static void main(String[] args) {
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
		
	}

	static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		
		while(L <= R) {
			// L : pivot보다 큰 값을 찾을 때까지 이동
			while(L <= R && arr[L] <= pivot) {
				L++;
			}
			while(arr[R] > pivot) {
				R--;
			}
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		// R의 위치는 pivot이 가야 할 위치
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		
		
		return R;
	}

}
