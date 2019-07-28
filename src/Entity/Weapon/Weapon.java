package Entity.Weapon;

import Entity.Entity;
import Main.Display;

public abstract class Weapon extends Entity {
	
	protected int damage;
	
	protected int xVelocity;
	
	protected int yVelocity;
	
	public Weapon(Display display,int x,int y,int width,int height,int damage,int xVelocity,int yVelocity) {
		super(display,x,y,width,height);
		this.damage=damage;
		this.xVelocity=xVelocity;
		this.yVelocity=yVelocity;
	}
	
	public void setDamage(int damage) {
		this.damage=damage;
	}
	
	public int getDamage() {
		return damage;
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
