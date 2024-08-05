package SWEA_1208_flatten;

import java.util.Arrays;

public class Solution {
  static void countingSort(){
    
        // 카운팅정렬
    
        // 1. 배열을 순회하며 각 값이 나올 때 마다 해당 값을 index로 하는 새로운 배열(counting)의 값을 1 증가
        int[] arr = {1, 3, 3, 2, 5, 1, 5, 4, 3, 1}; // 정렬 대상 배열
        int[] cnt = new int[6]; // 누적합 배열
        int[] res = new int[10]; // 정렬 후 배열
        
        for (int i = 0; i < arr.length; i++){
            cnt[arr[i]]++; // arr[i]에 해당하는 숫자의 출현 빈도를 cnt[] 배열의 해당 값의 인덱스에 누적 표기
        }
        System.out.println("arr= " + Arrays.toString(arr)); // arr= [1, 3, 3, 2, 5, 1, 5, 4, 3, 1]
        System.out.println("cnt= " + Arrays.toString(cnt)); // cnt= [0, 3, 1, 3, 1, 2]
        
        // 2. counting 배열의 각 값을 누적합으로 변환
        for(int i = 1; i < cnt.length; i++){
            cnt[i] = cnt[i] + cnt[i-1];
            // cnt[i] += cnt[i-1];
        }
        System.out.println("cnt= " + Arrays.toString(cnt)); // cnt= [0, 3, 4, 7, 8, 10]

        // 3. 최종 정렬
        for(int i = arr.length - 1; i >= 0; i--){ 
            // i번째 원소를 인덱스로 하는 cnt 배열을 1 감소시킨 후
            // cnt 배열의 값을 인덱스로 하여 result에 value 값을 저장
            int value = arr[i];
            cnt[value]--;
            res[cnt[value]] = value;
        }
        System.out.println("res= " + Arrays.toString(res)); // res= [1, 1, 1, 2, 3, 3, 3, 4, 5, 5]
        System.out.println("cnt= " + Arrays.toString(cnt)); // cnt= [0, 0, 3, 4, 7, 8]

        // counting 정렬 => 뒤에서부터 정렬 -> 안정정렬 보장
  }
}
