package Entity.Creature;

import Entity.Entity;
import Main.Display;

public abstract class Creature extends Entity {
	
	protected int health;
	
	protected int xVelocity;
	
	protected int yVelocity;
	
	public Creature(Display display,int x,int y,int width,int height,int health,int xVelocity,int yVelocity) {
		super(display,x,y,width,height);
		this.health=health;
		this.xVelocity=xVelocity;
		this.yVelocity=yVelocity;
	}
	
	public void setHealth(int health) {
		this.health=health;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setXVelocity(int xVelocity) {
		this.xVelocity=xVelocity;
	}
	
	public int getXVelocity() {
		return xVelocity;
	}
	
	public void setYVelocity(int yVelocity) {
		this.yVelocity=yVelocity;
	}
	
	public int getYVelocity() {
		return yVelocity;
	}
}
