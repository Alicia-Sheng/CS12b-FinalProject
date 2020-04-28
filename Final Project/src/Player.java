import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;

public class Player {

	private Game game;
	private String path = "src/biology.txt";
	public DoublyLinkedList question;
	public Node node;
	String show;
	public int health;
	
	public Player(Game game) {
		this.game = game;
		health = 3;
		try {
			question = ReadQA.readFile(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		node = question.head;
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