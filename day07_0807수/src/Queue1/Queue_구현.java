package Queue1;

public class Queue_구현 {
	static String[] queue = new String[10]; // 10개 삽입할 수 있는 queue 생성
	static int front = -1; // 마지막으로 삭제된 원소의 위치
	static int rear = -1; // 저장된 원소 중 마지막 원소
	
	// 공백상태
	static boolean isEmpty() {
		return front == rear;
	}
	
	// 포화상태
	static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	// 삽입
	static void enQueue(String item) {
		if(isFull()) {
			System.out.println("큐가 가득 찼습니다.");
			return;
		}
		queue[++rear] = item;
	}
	
	// 삭제
	static String deQueue() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[++front];
	}
	
	// 큐의 앞쪽에서 원소를 삭제없이 반환하는 연산
	static String Qpeek() {
		if(isEmpty()) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return queue[front+1];
	}
	
	// 큐의 사이즈 확인 (현재 들어있는 데이터의 수)
	static int size() {
		return rear - front;
	}
	
}