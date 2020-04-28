
public class Node { 
	private Question question;
	private Node prev;
	private Node next;
	
	public Node(Question question) {
		this.question=question;
	}
	public Node(Question question,Node prev,Node next) {
		this.question=question;
		this.prev=prev;
		this.next=next;	
		
	}
	public Question getQuestion() {
		return this.question;
	}
	public Node getPrev() {
		return this.prev;
	}
	public Node getNext() {
		return this.next;
	}
	public void setNext(Node next) {
		this.next=next;
	}
}
