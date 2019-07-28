package Entity;

import java.awt.Graphics2D;

import Main.Display;

public abstract class Entity {
	
	protected Display display;
	
	protected int x;
	
	protected int y;
	
	protected int width;
	
	protected int height;
	
	public Entity(Display display,int x,int y,int width,int height) {
		this.display=display;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWidth(int width) {
		this.width=width;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}
	
	public int getHeight() {
		return height;
	}
}
