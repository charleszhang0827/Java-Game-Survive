package Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyActionHandler implements KeyListener {
	
	private boolean keys[];
	
	private boolean up;
	
	private boolean down;
	
	private boolean left;
	
	private boolean right;
	
	private boolean exit;
	
	private boolean pause;
	
	private boolean normalBullet=true;
	
	public KeyActionHandler() {
		keys=new boolean[256];
	}

	public void keyPressed(KeyEvent event) {
		keys[event.getKeyCode()]=true;
		
		if(event.getKeyCode()==KeyEvent.VK_1) {
			normalBullet=true;
		}
	}
	
	public void keyReleased(KeyEvent event) {
		keys[event.getKeyCode()]=false;
	}
	
	public void keyTyped(KeyEvent event) {
		
	}
	
	public void tick() {
		up=keys[KeyEvent.VK_W];
		down=keys[KeyEvent.VK_S];
		left=keys[KeyEvent.VK_A];
		right=keys[KeyEvent.VK_D];
		exit=keys[KeyEvent.VK_ESCAPE];
		pause=keys[KeyEvent.VK_SPACE];
	}
	
	public boolean getUp() {
		return up;
	}
	
	public boolean getDown() {
		return down;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public boolean getExit() {
		return exit;
	}
	
	public boolean getPause() {
		return pause;
	}
	
	public boolean getNormalBullet() {
		return normalBullet;
	}
}
