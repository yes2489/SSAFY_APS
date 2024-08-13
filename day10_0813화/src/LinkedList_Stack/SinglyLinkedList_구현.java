package LinkedList_Stack;

class Node{
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
	void push(String data) { 
		size++;
		// 새 노드 생성
		Node newNode = new Node();
		newNode.data = data;
		
		// 맨 앞에 삽입
		Node curr = head; // head 다음 노드 추적용
		
		// 새 노드 연결
		newNode.link = curr.link;
		curr.link = newNode;
	}
	
	
	// 삭제
	void pop() {
		Node curr = head;
		if (curr == null) {
			System.out.println("스택이 비어있음");
			return;
		}
		size--;
		curr.link = curr.link.link;
	}
	

	
	// 조회
	void printAll() {
		Node curr = head;
		
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.link;
		}
		System.out.println();
	}
	
}



public class SinglyLinkedList_구현 {

	public static void main(String[] args) {
		// 스택 구현
		SinglyLinkedList stack = new SinglyLinkedList();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		stack.printAll();
		stack.pop();
		stack.printAll();

	}

}
