
/**
 * 
 * @author Emma Xu, Alicia Sheng
 *
 */

public class Node {
	
	protected Question question;
	protected Node prev;
	protected Node next;

	public Node(Question question) {
		this.question = question;
		prev = null;
		next = null;
	}

}