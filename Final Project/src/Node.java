
public class Node {
	
	protected Question question;
	protected Node prev;
	protected Node next;
	
	public Node() {
		question = null;
		prev = null;
		next = null;
	}
	
	public Node(Question question) {
		this.question = question;
		prev = null;
		next = null;
	}

}