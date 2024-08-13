package LinkedList_Queue;

class Node<E>{
	E data;
	Node<E> link; // 다음 노드를 가리키는 역할을 하는 변수
	
	Node(E data){
		this.data = data;
		this.link = null;
	}
}

class SinglyLinkedList<E>{
	Node<E> head;
	Node<E> tail;
	int size;
	
	SinglyLinkedList(){
		head = null; // 큐에서 가장 앞에 있는 노드 객체를 가리키는 변수
		tail = null; // 큐에서 가장 뒤에 있는 노드 객체를 가리키는 변수
		size = 0; // 큐에 담긴 요소의 개수
	}
	
	// isEmpty
	boolean isEmpty(String data) {
		return (head==tail);
	}
	
	// 삽입
	
	boolean enQueue(E data) {
	Node<E> newNode = new Node<E>(data);
	
	if(size == 0) {
		head = newNode;
	} else {
		// 큐가 비어있지 않을 경우 마지막 노드(tail)의 다음 노드(link)가 새 노드를 가리키도록 함
		tail.link = newNode;
	}
	
	// tail이 가리키는 노드를 새 노드로 바꿔줌
	tail = newNode;
	size++;
	
	return true;
	
	}
	
	// 삭제	
	E deQueue() {
		
		// 삭제 할 요소가 없을 경우 null 반환
		if (size == 0) {
			return null;
		}
		// 삭제 될 요소의 데이터를 반환하기 위한 임시 변수
		E element = head.data;
		
		// head 노드의 다음 노드
		Node<E> nextNode = head.link;
		
		// head의 모든 데이터를 삭제
		head.data = null;
		head.link = null;
		
		// head가 가리키는 노드를 삭제된 head 노드의 다음 노드를 가리키도록 변경
		head = nextNode;
		size--;
		
		return element;

	}
	
	// 조회
	void printAll() {
		Node<E> curr = head;
		
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.link;
		}
		System.out.println();
	}
}



public class SinglyLinkedList_구현2 {

	public static void main(String[] args) {
		// 스택 구현
		SinglyLinkedList<String> queue = new SinglyLinkedList<>();
		
		queue.enQueue("one");
		queue.enQueue("two");
		queue.enQueue("three");
		queue.printAll();
		queue.deQueue();
		queue.printAll();
		

	}

}
