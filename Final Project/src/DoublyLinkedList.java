import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DoublyLinkedList {
	
	public Node head;
	public Node tail;
	public int size = 0;

	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 1;
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
	
	public boolean isTail(Node node) {
		if (node.equals(tail)) {
			return true;
		}
		return false;
	}

	public int getSize() {
		return this.size;
	}

	// readAnswers
	public void readAnswerFile(String fileName) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		Node current = head;

		while (file.hasNextLine()) {
			String line = file.nextLine();
			current.question.setAnswer(line);
			if (this.hasNext(current)) {
				current = current.next;
			}
		}
	}

}