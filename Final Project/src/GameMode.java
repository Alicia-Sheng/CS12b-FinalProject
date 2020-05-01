import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * GameMode extends the Mode class. It mainly conducts a QA game which the
 * player can switch categories each time. It would give a final score to the
 * player as well as the win and lose situation.
 * 
 * functions: Q&A; choose category; check invalid inputs; loop QA's; score
 * system; win and lose;
 *
 */

public class GameMode extends Mode {

	private static int winPoints = 15;

	public static void main(String[] args) throws FileNotFoundException {
		initialize();
		print();
		while (run) {
			QA();
			if (score >= winPoints) {
				System.out.println("Congratulations! You win!");
				run = false;
			}
		}
	}

	public static void print() {
		System.out.println("Question and answer time!");
		System.out.println("There are four catagories, with each " + qNumEachCat + " questions.");
		System.out.println(
				"You can choose freely to answer the questions from each category for " + qNumEachCat + " times.");
		System.out.println("Everytime you get an answer correct, you get 1 more point.");
		System.out.println("You will win after you get " + winPoints + " points.");
		System.out.println("============================================================");
	}

	public static void QA() {
		Scanner in = new Scanner(System.in);
		String category = "";
		String question = "";
		String answer = "";
		category = chooseCat();

		if (nodeBio != null || nodeJava != null || nodeMovie != null || nodeEncy != null) {
			if (category.equals("1")) {
				if (nodeBio == null) {
					System.out.println(
							"There are no more questions in category of Biology. Please choose another category.\n");
				} else if (bioQuestion.hasNext(nodeBio) || bioQuestion.isTail(nodeBio)) {
					question = nodeBio.question.getPrompt();
					answer = nodeBio.question.getAnswer();
					checkAnswer(question, answer);
					nodeBio = nodeBio.next;
				}
			} else if (category.equals("2")) {
				if (nodeJava == null) {
					System.out.println(
							"There are no more questions in category of Java. Please choose another category.\n");
				} else if (javaQuestion.hasNext(nodeJava) || javaQuestion.isTail(nodeJava)) {
					question = nodeJava.question.getPrompt();
					answer = nodeJava.question.getAnswer();
					checkAnswer(question, answer);
					nodeJava = nodeJava.next;
				}
			} else if (category.equals("3")) {
				if (nodeMovie == null) {
					System.out.println(
							"There are no more questions in category of Movie. Please choose another category.\n");
				} else if (movieQuestion.hasNext(nodeMovie) || movieQuestion.isTail(nodeMovie)) {
					question = nodeMovie.question.getPrompt();
					answer = nodeMovie.question.getAnswer();
					checkAnswer(question, answer);
					nodeMovie = nodeMovie.next;
				}
			} else if (category.equals("4")) {
				if (nodeEncy == null) {
					System.out.println(
							"There are no more questions in category of Encyclopedia. Please choose another category.\n");
				} else if (encyQuestion.hasNext(nodeEncy) || encyQuestion.isTail(nodeEncy)) {
					question = nodeEncy.question.getPrompt();
					answer = nodeEncy.question.getAnswer();
					checkAnswer(question, answer);
					nodeEncy = nodeEncy.next;
				}
			}
		} else {
			System.out.println("There are no more questions in all categories. You failed.");
			System.out.println("final score: " + score);
			run = false;
		}

	}

	public static String chooseCat() {
		Scanner in = new Scanner(System.in);
		boolean correctCat = false;
		String category = "";
		String[] catList = { "1", "2", "3", "4" };
		loop: while (!correctCat) {
			System.out.println(
					"Please choose a category. 1 for biology, 2 for java, 3 for movie, and 4 for encyclopedia (1/2/3/4).");
			category = in.nextLine();
			for (int i = 0; i < catList.length; i++) {
				if (category.equals(catList[i])) {
					correctCat = true;
					break loop;
				}
			}
			System.out.println("Incorrect input. Please input again.\n");
		}
		return category;
	}

	public static void checkAnswer(String question, String answer) {
		System.out.println(question);
		String userAnswer = chooseAnswer();
		if (userAnswer.equals(answer)) {
			System.out.println("You are correct!");
			score++;
			System.out.println("score: " + score + "\n");
		} else {
			System.out.println("Oops! The correct answer is " + answer + ".");
			System.out.println("score: " + score + "\n");
		}
	}

}
