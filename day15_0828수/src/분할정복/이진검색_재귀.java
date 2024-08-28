package 분할정복;

public class 이진검색_재귀 {
	static int[] arr = {8, 9, 17, 21, 23, 35, 88, 369};
	static int key = 17;

	public static void main(String[] args) {
		System.out.println(binarySearch(0, arr.length -1));
	}
	
	static boolean binarySearch(int left, int right) {
		// 기저조건
		if (left > right) {
			return false;
		}
		
		// 재귀 부분
		int mid = (left + right) / 2;
		// 같다면
		if (arr[mid] == key) {
			return true;
		} else if (arr[mid] > key) {
			return binarySearch(left, mid - 1);
		} else {
			return binarySearch(mid + 1, right);
		}
	}
}
