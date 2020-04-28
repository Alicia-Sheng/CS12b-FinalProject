
public class DoublyLinkedList {
	public Node head;
	public Node tail;
	public int size = 0;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public DoublyLinkedList(Question question) {
		Node node = new Node(question);
		head = node;
		tail = node;
		size = 1;
	}

	public void insertNext(Node node, Question question) {
		Node newNode = new Node(question);
		if (node.next == null) {
			tail.next = node;
			node.prev = tail;
			tail = node;
		} else {
			newNode.next = node.next;
			node.next.prev = newNode;
			node.next = newNode;
			newNode.prev = node;
		}
		size++;
	}

	public void insertEnd(Question question) {
		Node node = new Node(question);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
			size++;
		}
	}

	public boolean hasPrev(Node node) {
		if (node.prev == null) {
			return false;
		}
		return true;
	}

	public boolean hasNext(Node node) {
		if (node.next == null) {
			return false;
		}
		return true;
	}

//	public DoublyLinkedList(Node question) {
//		this.head=question;
//		this.tail=question;
//		this.size++;
//	}
//	public Node getHead() {
//		return this.head;
//	}
//	public Node getTail() {
//		return this.tail;
//	}
	public int getSize() {
		return this.size;
	}

//	public void addNode(Question question) {
//		if (this.head==null) {
//			this.head=new Node(question);
//		}else {
//			Node current=this.head;
//			while (current.getNext()!=null) {
//				current=current.getNext();
//			}
//			current.setNext(new Node(question));
//		}
//		
//	}
}