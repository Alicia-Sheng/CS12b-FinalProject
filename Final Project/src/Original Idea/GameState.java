import java.awt.Graphics;

public class GameState {
	
	private static GameState currentState = null;
	protected Game game;
	private Player player;
	
	public static void setState(GameState state){
		currentState = state;
	}
	
	public static GameState getState(){
		return currentState;
	}
	
	public GameState(Game game){
		this.game = game;
		player = new Player(game);
	}
	
	public void tick() {
		player.tick();
	}

	public void render(Graphics graphics) {
		player.render(graphics);
	}

}
