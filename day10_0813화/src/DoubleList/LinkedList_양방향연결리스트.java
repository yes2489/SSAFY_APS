package DoubleList;

class Node{
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList{
	Node head;
	Node tail;
	int size;
	
	public DoublyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	
	// 삽입
	void addData(int i, String data) {
		// 0 : 제일 앞에 삽입
		// size : 제일 뒤에 삽입
		if(i < 0 || i > size) {
			System.out.println("삽입할 수 없는 범위입니다.");
			return;
		}
		size++;
		
		// 삽입 위치 앞의 노드를 찾기
		Node curr = head;
		
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}
		
		// 새 노드 만들기
		Node newNode = new Node();
		newNode.data = data;
		
		// 새 노드 연결
		newNode.next = curr.next;
		newNode.prev = curr;
		
		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;		
	}
	
	// 삭제
	void removeData(int i) {
		// 0번 : 제일 앞의 데이터 삭제
		// (size - 1)번 : 제일 뒤의 데이터 삭제
		
		if(i < 0 || i >= size) {
			System.out.println("삭제불가범위");
			return;
		}
		
		size--;
		
		// 삭제 할 위치 찾기
		// rmNode는 지역변수이므로 메서드 리턴과 동시에 접근 불가
		Node rmNode = head.next;
		
		for (int k = 0; k < i; k++) {
			rmNode = rmNode.next;
		}
		
		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
	}
	
	void printReverse() {
		Node curr = tail.prev;
		String str = "";
		while (curr != head) {
			str = " <- " + curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
	
	
}

public class LinkedList_양방향연결리스트 {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		
		list.addData(0, "대전 4반");
		list.addData(0, "서울 5반");
		list.addData(0, "대전 6반");
		list.addData(0, "서울 7반");
		
		list.printReverse();
		System.out.println(list.size);
		list.removeData(1);
		list.removeData(1);
		list.printReverse();
		System.out.println(list.size);
	}

}
