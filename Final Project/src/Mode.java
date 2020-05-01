import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Mode class basically reads the files which store the questions and answers to
 * doubly linked lists, which a chooseAnswer method that get the user's input.
 */

public abstract class Mode {
	protected static String pathBio = "src/Biology.txt";
	protected static String pathBioAnswer = "src/BiologyAnswer.txt";
	protected static String pathJava = "src/Java.txt";
	protected static String pathJavaAnswer = "src/JavaAnswer.txt";
	protected static String pathMovie = "src/Movie.txt";
	protected static String pathMovieAnswer = "src/MovieAnswer.txt";
	protected static String pathEncy = "src/Encyclopedia.txt";
	protected static String pathEncyAnswer = "src/EncyAnswer.txt";

	public static DoublyLinkedList bioQuestion;
	public static DoublyLinkedList javaQuestion;
	public static DoublyLinkedList movieQuestion;
	public static DoublyLinkedList encyQuestion;

	public static Node nodeBio;
	public static Node nodeJava;
	public static Node nodeMovie;
	public static Node nodeEncy;

	protected static double score;
	protected static int qNumEachCat;
	protected static boolean run;

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
		qNumEachCat = 5;
		run = true;
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
}
