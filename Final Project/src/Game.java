import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.*;
import java.util.*;

public class Game implements Runnable {

	private Display display;
	public String title;
	public int width;
	public int height;
	private Thread thread;
	private boolean run;
	private BufferStrategy bufferStrategy;
	private Graphics graphics;
	private Key key;
	private GameState gameState;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		key = new Key();
		//player = new Player();
	}

	private void initialize() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(key);
		gameState = new GameState(this);
		GameState.setState(gameState);
	}

	private void tick() {
		key.tick();
		if(GameState.getState() != null) {
			GameState.getState().tick();	
		}
	}

	private void render() {
		bufferStrategy = display.getCanvas().getBufferStrategy();
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		graphics = bufferStrategy.getDrawGraphics();
		graphics.clearRect(0, 0, width, height); // clears the whole screen
		
		if(GameState.getState() != null) {
			GameState.getState().render(graphics);	
		}

		bufferStrategy.show();
		graphics.dispose();
	}

	public void run() {
		initialize();

		while (run) {
			tick();
			render();
		}
		stop();
	}

	public synchronized void start() {
		if (run) {
			return;
		}
		run = true;
		thread = new Thread(this); // passes in the "this" game class
		thread.start(); // calls the run() method above
	}

	public synchronized void stop() {
		if (!run) {
			return;
		}
		run = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Key getKey() {
		return key;
	}

}
