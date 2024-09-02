package SWEA_2383_점심식사시간;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution{

    // 사람, 계단의 위치를 저장할 리스트
    private static List<int[]> people, stairs;
    private static int T, N, P, answer; // T : testcase, N : 지도 크기, P : 사람 수, answer : 최소 시간

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            
            N = sc.nextInt(); // map 크기 입력

            // 사람, 계단 저장할 리스트 초기화
            people = new ArrayList<>();
            stairs = new ArrayList<>();

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                	
                    int value = sc.nextInt();

                    // 사람 위치
                    if (value == 1) {
                        people.add(new int[]{r, c});
                    }
                    
                    // 계단 위치
                    else if (value > 1) {
                        stairs.add(new int[]{r, c, value}); // 행, 열, 계단 길이 (시간)
                    }
                }
            }

            // 사람 수 초기화
            P = people.size();
            
            // 최소 시간을 큰 값으로 초기화
            answer = Integer.MAX_VALUE;

            // 모든 사람들의 계단 선택 경우를 계산
            separate(0, new int[P]);

            // 결과 출력
            System.out.println("#" + t + " " + answer);
        }
    }

    
    // 완전 탐색
    private static void separate(int i, int[] cases) { // i = index, cases = 어떤 계단? (0/1)
    	// 기저 조건
        // 모든 사람에 대해 계단 선택이 완료된 경우
        if (i == P) {
            // 현재 선택에 대한 결과를 계산하고 최소 시간 갱신
            answer = Math.min(answer, simulate(cases));
            return;
        }
        
        // 재귀 부분
        // 첫 번째 계단을 선택한 경우에 대해 재귀 호출
        cases[i] = 0;
        separate(i + 1, cases);

        // 두 번째 계단을 선택한 경우에 대해 재귀 호출
        cases[i] = 1;
        separate(i + 1, cases);
    }

    
    
    // 현재 사람들의 계단 선택에 따른 시뮬레이션
    private static int simulate(int[] cases) {
    	
        // 각 계단으로 향하는 사람들의 도착 시간을 저장할 우선순위 큐
        PriorityQueue<Integer> first = new PriorityQueue<>(P);
        PriorityQueue<Integer> second = new PriorityQueue<>(P);

        // 각 계단의 사용 시간
        int firstT = stairs.get(0)[2]; 
        int secondT = stairs.get(1)[2];

        
        for (int i = 0; i < P; i++) {
            int[] person = people.get(i); // 각 사람에 대해
            int[] stair = stairs.get(cases[i]); // 현재 사람이 이용할 계단의 위치와 정보
            PriorityQueue<Integer> target = cases[i] == 0 ? first : second; //현재 사람이 첫 번째 계단을 이용하면 first 큐를, 두 번째 계단을 이용하면 second 큐를 선택

            // 사람의 위치에서 계단까지의 거리를 계산하고 큐에 추가
            target.add(Math.abs(person[0] - stair[0]) + Math.abs(person[1] - stair[1]));
        }

        // 두 계단의 최대 소요 시간을 반환
        return Math.max(total(first, firstT), total(second, secondT));
    }

    

    // 계단을 모두 내려가는 데 걸리는 시간
    private static int total(PriorityQueue<Integer> waiting, int cost) { // cost : 계단 사용 시간 
    	
        // 계단을 사용하는 사람들의 시간을 저장할 우선순위 큐
        PriorityQueue<Integer> using = new PriorityQueue<>(3); // 계단 위에는 동시에 최대 3명까지만 올라가 있을 수 있다.
        int time = 0;

        // 대기 중인 사람이 있을 동안
        while (!waiting.isEmpty()) {
        	
            // 계단을 이미 3명이 사용 중이면
            if (using.size() == 3) {
                time = using.poll(); //가장 빨리 끝나는 시간을 가져옴
            }

            // 현재 사람의 도착 시간과 계단 사용 시간을 계산해 큐에 추가
            using.add(Math.max(time, waiting.poll()) + cost);
        }

        
        while (!using.isEmpty()) {
            time = using.poll(); // 모든 사람이 계단을 사용할 때까지 최종시간 업데이트
        }

        // 최종적으로 모든 사람이 내려가는 데 걸린 시간 반환
        return time + 1;
    }
}