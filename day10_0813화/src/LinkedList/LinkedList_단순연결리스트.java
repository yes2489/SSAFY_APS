package LinkedList;

class Node {
	String data;
	Node link; // 다음 노드의 주소를 저장할 필드
}

class SinglyLinkedList{
	Node head;
	int size;
	
	SinglyLinkedList(){
		head = new Node(); // 비어있는 head 노드 생성
	}
	
	// 삽입
	void addData(int i, String data) { 
		// i 인덱스에 데이터 삽입
		// 0 이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		// -> 범위 체크 필요
		if (0 > i || i > size) {
			System.out.println("삽입 할 위치가 잘못되었습니다.");
			return;
		}
		
		size++;
		
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 삽입 할 위치 앞에 있는 노드 찾기
		Node curr = head; // head 다음 노드 추적
		for(int k = 0; k < i; k++) {
			curr = curr.link; // 다음 노드 (head부터 시작)
		}
		
		// 새 노드부터 연결
		newNode.link = curr.link;
		curr.link = newNode;
		
		
	}
	
	// 삭제
	void removeData(int i) {
		// 0번 : 제일 앞에 있는 데이터 삭제
		// (size - 1)번 : 마지막 데이터 삭제
		
		if (i < 0 || i >= size) {
			System.out.println("삭제 할 수 없는 범위입니다.");
			return;
		}
		
		size--;
		
		// 삭제할 노드의 앞 노드로 이동
		Node curr = head;
		
		for(int k = 0; k < i; k++) {
			curr = curr.link;
		}
		
		curr.link = curr.link.link;
		
	}
	
	// 조회
	void printAll() { 
		Node curr = head;
		
		while (curr != null) {
			System.out.println(curr.data + "->");
			curr = curr.link;
		}
		System.out.println();
	}
	
}

public class LinkedList_단순연결리스트 {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addData(0, "1");
		list.printAll();
		list.addData(0, "2");
		list.addData(0, "3");
		list.printAll();
		list.addData(0, "4");
		list.addData(0, "5");
		list.addData(0, "6");
		list.printAll();
	}

}
