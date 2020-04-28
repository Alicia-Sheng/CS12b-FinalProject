
public class Node {
	// private Question question;
	protected Question question;
	protected Node prev;
	protected Node next;
//	
//	public Node() {
//		QA = new String[3]; // QA[0] is Q, QA[1] is A, and QA[2] is category.
//		//Can also be new String[2] without category.
//		prev = null;
//		next = null;
//	}

	public Node(Question question) {
		this.question = question;
	}


//	public Node(Question question,Node prev,Node next) {
//		this.question=question;
//		this.prev=prev;
//		this.next=next;	
//		
//	}
//	public Question getQuestion() {
//		return this.question;
//	}
//	public Node getPrev() {
//		return this.prev;
//	}
//	public Node getNext() {
//		return this.next;
//	}
//	public void setNext(Node next) {
//		this.next=next;
//	}
}