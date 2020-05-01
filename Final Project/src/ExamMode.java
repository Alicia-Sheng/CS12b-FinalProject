import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ExamMode extends the Mode class. It has the same question inventory as Mode
 * has. The difference is that it expands the mode to an exam system, which
 * calculates the user's score over the maximum score in a certain subject.
 * 
 * functions: Q&A; choose subject; check invalid inputs; loop QA's; score
 * system;
 */

public class ExamMode extends Mode {

	protected static double maxScore = 100;
	protected static double scoreEachQ;

	protected static DoublyLinkedList list = new DoublyLinkedList();
	protected static Node node = new Node();

	public static void main(String[] args) throws FileNotFoundException {
		initialize();
		chooseSubject();
		while (run) {
			QA();
		}
		System.out.println("This is the end of your exam. Your score is " + score + ".");
	}

	public static void QA() {
		String question;
		String answer;
		if (node == null) {
			run = false;
		} else if (list.hasNext(node) || list.isTail(node)) {
			question = node.question.getPrompt();
			answer = node.question.getAnswer();
			checkAnswer(question, answer, scoreEachQ);
			node = node.next;
		}
	}

	public static void chooseSubject() {
		Scanner in = new Scanner(System.in);
		boolean correctSubject = false;
		String subject = "";
		String[] subjectList = { "1", "2", "3", "4" };
		loop: while (!correctSubject) {
			System.out.println(
					"Please choose your subject. 1 for biology, 2 for java, 3 for movie, and 4 for encyclopedia (1/2/3/4).");
			subject = in.nextLine();
			for (int i = 0; i < subjectList.length; i++) {
				if (subject.equals(subjectList[i])) {
					correctSubject = true;
					break loop;
				}
			}
			System.out.println("Incorrect input. Please input again.\n");
		}
		if (subject.equals("1")) {
			list = bioQuestion;
			node = nodeBio;
		} else if (subject.equals("2")) {
			list = javaQuestion;
			node = nodeJava;
		} else if (subject.equals("3")) {
			list = movieQuestion;
			node = nodeMovie;
		} else if (subject.equals("4")) {
			list = encyQuestion;
			node = nodeEncy;
		}
		scoreEachQ = maxScore / list.getSize();
		System.out.println("There are in all " + list.getSize() + " questions in this subject. The exam now begins.");
	}

	public static void checkAnswer(String question, String answer, double scoreEachQ) {
		System.out.println(question);
		String userAnswer = chooseAnswer();
		if (userAnswer.equals(answer)) {
			score = score + scoreEachQ;
		}
	}

}
