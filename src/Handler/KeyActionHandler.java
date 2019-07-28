package Handler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Display;
import State.State;

public class KeyActionHandler implements KeyListener {
	
	private Display display;
	
	private boolean[] keys;
	
	private boolean left;
	
	private boolean right;
	
	private boolean up;
	
	private boolean down;
	
	private boolean toMenuState;
	
	private boolean toRunState;
	
	private boolean weaponOne=true;
	
	private boolean weaponTwo;
	
	public KeyActionHandler(Display display) {
		this.display=display;
		keys=new boolean[256];
	}

	public void keyPressed(KeyEvent event) {
		keys[event.getKeyCode()]=true;
		
		if(event.getKeyCode()==KeyEvent.VK_SPACE && State.getState()==display.getRunState()) {
			toMenuState=true;
		}else if(event.getKeyCode()==KeyEvent.VK_SPACE && State.getState()==display.getMenuState()) {
			toRunState=true;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_1) {
			weaponOne=true;
			weaponTwo=false;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_2) {
			weaponOne=false;
			weaponTwo=true;
		}
		
		if(event.getKeyCode()==KeyEvent.VK_ESCAPE) {
			display.stop();
		}
	}

	public void keyReleased(KeyEvent event) {
		keys[event.getKeyCode()]=false;
	}
	
	public void tick() {
		left=keys[KeyEvent.VK_A];
		
		right=keys[KeyEvent.VK_D];
		
		up=keys[KeyEvent.VK_W];
		
		down=keys[KeyEvent.VK_S];
	}
	
	public void keyTyped(KeyEvent event) {
		
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public boolean getUp() {
		return up;
	}
	
	public boolean getDown() {
		return down;
	}
	
	public void setToMenuState(boolean toMenuState) {
		this.toMenuState=toMenuState;
	}
	
	public boolean getToMenuState() {
		return toMenuState;
	}
	
	public void setToRunState(boolean toRunState) {
		this.toRunState=toRunState;
	}
	
	public boolean getToRunState() {
		return toRunState;
	}
	
	public boolean getWeaponOne() {
		return weaponOne;
	}
	
	public boolean getWeaponTwo() {
		return weaponTwo;
	}

}
