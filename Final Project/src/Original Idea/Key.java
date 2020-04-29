import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener{
	
	private boolean[] keys;
	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;
	public boolean A;
	public boolean B;
	public boolean C;
	public boolean D;
	
	public Key() {
		keys = new boolean[256];		
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		A = keys[KeyEvent.VK_A];
		B = keys[KeyEvent.VK_B];
		C = keys[KeyEvent.VK_C];
		D = keys[KeyEvent.VK_D];
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

}
