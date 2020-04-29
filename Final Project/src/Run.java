import java.io.FileNotFoundException;
import java.util.Scanner;

public class Run {

	private static String pathBio = "src/Biology.txt";
	private static String pathBioAnswer = "src/BiologyAnswer.txt";
	private static String pathJava = "src/Java.txt";
	private static String pathJavaAnswer = "src/JavaAnswer.txt";
	private static String pathMovie = "src/Movie.txt";
	private static String pathMovieAnswer = "src/MovieAnswer.txt";
	private static String pathEncy = "src/Encyclopedia.txt";
	private static String pathEncyAnswer = "src/EncyAnswer.txt";

	public static DoublyLinkedList bioQuestion;
	public static DoublyLinkedList javaQuestion;
	public static DoublyLinkedList movieQuestion;
	public static DoublyLinkedList encyQuestion;

	public static Node nodeBio;
	public static Node nodeJava;
	public static Node nodeMovie;
	public static Node nodeEncy;

	private static int score;
	private static int qNumEachCat = 5;

	public static void main(String[] args) throws FileNotFoundException {
		boolean win = false;
		initialize();
		print();
		while (!win) {
			QA();
		}
	}

	public static void initialize() throws FileNotFoundException {
		bioQuestion = ReadQA.readFile(pathBio);
		bioQuestion.readAnswerFile(pathBioAnswer);

		javaQuestion = ReadQA.readFile(pathJava);
		javaQuestion.readAnswerFile(pathJavaAnswer);

		movieQuestion = ReadQA.readFile(pathMovie);
		movieQuestion.readAnswerFile(pathMovieAnswer);

		encyQuestion = ReadQA.readFile(pathEncy);
		encyQuestion.readAnswerFile(pathEncyAnswer);

		nodeBio = bioQuestion.head;
		nodeJava = javaQuestion.head;
		nodeMovie = movieQuestion.head;
		nodeEncy = encyQuestion.head;

		score = 0;
	}

	public static void print() {
		System.out.println("Question and answer time!");
		System.out.println("There are four catagories, with each " + qNumEachCat + " questions.");
		System.out.println("You can choose freely to answer the questions from each category for " + qNumEachCat + " times.");
		System.out.println("Everytime you get an answer correct, you get 1 more point.");
		System.out.println("You will win after you get 10 points.");
		System.out.println("==============================");
	}

	public static void QA() {
		Scanner in = new Scanner(System.in);
		String category = "";
		String question = "";
		String answer = "";
		category = chooseCat();

		if (category.equals("1")) {
			question = nodeBio.question.getPrompt();
			answer = nodeBio.question.getAnswer();
			checkAnswer(question, answer);
		} else if (category.equals("2")) {
			question = nodeJava.question.getPrompt();
			answer = nodeJava.question.getAnswer();
			checkAnswer(question, answer);
		} else if (category.equals("3")) {
			question = nodeMovie.question.getPrompt();
			answer = nodeMovie.question.getAnswer();
		} else if (category.equals("4")) {
			question = nodeEncy.question.getPrompt();
			answer = nodeEncy.question.getAnswer();
			checkAnswer(question, answer);
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

	public static String chooseAnswer() {
		Scanner in = new Scanner(System.in);
		boolean correctAnswer = false;
		String userAnswer = "";
		String[] answerList = { "a", "b", "c", "d", "A", "B", "C", "D" };
		loop: while (!correctAnswer) {
			System.out.println("Your answer is (a/b/c/d): ");
			userAnswer = in.nextLine();
			for (int i = 0; i < answerList.length; i++) {
				if (userAnswer.contentEquals(answerList[i])) {
					correctAnswer = true;
					userAnswer = userAnswer.toUpperCase();
					break loop;
				}
			}
			System.out.println("Incorrect input. Please input again.\n");
		}
		return userAnswer;
	}

	public static void checkAnswer(String question, String answer) {
		System.out.println(question);
		String userAnswer = chooseAnswer();
		if (userAnswer.equals(answer)) {
			System.out.println("You are correct!");
			score++;
			System.out.println("score: " + score + "\n");
		} else {
			System.out.println("Oops! The correct answer is " + answer + ".\n");
			System.out.println("score: " + score + "\n");
		}
	}

}
