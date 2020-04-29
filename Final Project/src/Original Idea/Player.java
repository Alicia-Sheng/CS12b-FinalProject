import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;

public class Player {

		private Game game;
	
	private String pathBio = "src/Biology.txt"; private String pathBioAnswer="src/BiologyAnswer.txt";
	private String pathJava = "src/Java.txt"; private String pathJavaAnswer="src/JavaAnswer.txt";
	private String pathMovie = "src/Biology.txt"; private String pathMovieAnswer="src/BiologyAnswer.txt";
	private String pathEncy = "src/Java.txt"; private String pathEncyAnswer="src/JavaAnswer.txt";
	
	public DoublyLinkedList bioQuestion;
	public DoublyLinkedList javaQuestion;
	public DoublyLinkedList movieQuestion;
	public DoublyLinkedList encyQuestion;
	
	public Node nodeBio; 
	public Node nodeJava; 
	public Node nodeMovie; 
	public Node nodeEncy;
	
	String show;
	public int health;
	
	public Player(Game game) {
		this.game = game;
		health = 3;
		try {
			bioQuestion = ReadQA.readFile(pathBio);
			bioQuestion.readAnswerFile(pathBioAnswer);
			
			javaQuestion = ReadQA.readFile(pathJava);
			javaQuestion.readAnswerFile(pathJavaAnswer);
			
			movieQuestion = ReadQA.readFile(pathMovie);
			movieQuestion.readAnswerFile(pathMovieAnswer);
			
			encyQuestion = ReadQA.readFile(pathEncy);
			encyQuestion.readAnswerFile(pathEncyAnswer);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		nodeBio = bioQuestion.head;
		nodeJava = javaQuestion.head;
		nodeMovie = movieQuestion.head;
		nodeEncy = encyQuestion.head;
	}

	public void tick() {

//		if(game.getKey().down)
//		if(game.getKey().left)
//		if(game.getKey().right)
	}
	
	public void render(Graphics graphics) {
		if(game.getKey().up) {
			show = node.question.getPrompt();
	        graphics.setColor(Color.black); 
	        graphics.setFont(new Font("Bold", 1, 20)); 
	        graphics.drawString(show, 100, 100); 
		}
	}

}
