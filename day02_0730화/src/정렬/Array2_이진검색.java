package 정렬;

public class Array2_이진검색 {

	public static void main(String[] args) {
		
		int[] nums = {2, 4, 7, 9, 11, 19, 23};
		
		int result = binarySearch(nums, 11);
		System.out.println(result);

	}
	
	static int binarySearch(int[] arr, int key) {
		int left = 0; // 구간의 시작 index
		int right = arr.length - 1; // 구간의 끝 index
		while(left <= right) {
			// left == right -> 데이터 하나
			int mid = (left + right) / 2; // 가운데 인덱스 확인 (int라서 소수점 아래는 버림 -> 홀수 짝수 상관X)
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid + 1; 
				// mid값보다 key가 더 크니까 구간의 시작을 mid+1로 이동
			} else {
				right = mid - 1;
				// mid값이 key보다 크니까 구간의 끝을 mid - 1로 이동
			}
		}
		return -1;
	}

}
