package 분할정복;

import java.util.Arrays;

public class 병합정렬 {
	static int[] arr = {7, 5, 13, 2, 79, 12, 35, 42};
	static int N = arr.length; // 배열의 길이
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));

	}

	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
		
	}
	
	// left : 시작 구간 | right : 끝 구간 | mid : 왼쪽 끝
	static void merge(int left, int mid, int right) {
		int L = left; // 왼쪽 구간 시작
		int R = mid + 1; // 오른쪽 구간 시작
		int idx = left; // 임시배열 tmp의 index
		
		while(L <= mid && R <= right) {
			if(arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			} 
		}
		
		
		// 왼쪽 구간의 값이 남았을 경우
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[L++];
			}
		}
		
		// 오른쪽 구간의 값이 남았을 경우
		if (R <= right) {
			for (int i = R; i <=right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		// 원본 배열에 반영
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}

}
