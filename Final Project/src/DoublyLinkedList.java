
public class DoublyLinkedList {
	public Node head;
	public Node tail;
	public int size=0;
	
	public DoublyLinkedList() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	public DoublyLinkedList(Node question) {
		this.head=question;
		this.tail=question;
		this.size++;
	}
	public Node getHead() {
		return this.head;
	}
	public Node getTail() {
		return this.tail;
	}
	public int getSize() {
		return this.size;
	}
	
	public void addNode(Question question) {
		if (this.head==null) {
			this.head=new Node(question);
		}else {
			Node current=this.head;
			while (current.getNext()!=null) {
				current=current.getNext();
			}
			current.setNext(new Node(question));
		}
		
	}
}
