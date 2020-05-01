import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadQA {

	// readQuestion
	public static DoublyLinkedList readFile(String fileName) throws FileNotFoundException {
		Scanner file = new Scanner(new File(fileName));
		DoublyLinkedList storeQuestion = new DoublyLinkedList();

		while (file.hasNextLine()) {
			String onePrompt = "";
			for (int i = 0; i <= 4; i++) {
				String line = file.nextLine();
				onePrompt += line + "\n";
			}
			Question question = new Question(onePrompt, "a", "b");
			storeQuestion.insertEnd(question);
		}
		
		return storeQuestion;
	}

	public static void main(String[] arg) throws FileNotFoundException {
		DoublyLinkedList questions = readFile("src/a.txt");
		// traverse to test code
		Node current = questions.head;
		while (current != null) {
			current.question.printQuestion();
			current = current.next;
		}
	}
}