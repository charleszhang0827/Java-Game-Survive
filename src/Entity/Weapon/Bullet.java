package Entity.Weapon;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.Display;

public class Bullet extends Weapon {
	
	private double angle;
	
	private final Color color=Color.CYAN;
	
	public Bullet(Display display,int x,int y,int width,int height,int damage,int xVelocity,int yVelocity,double angle) {
		super(display,x,y,width,height,damage,xVelocity,yVelocity);
		this.angle=angle;
	}
	
	public void tick() {
		movement();
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,width,height);
	}
	
	private void movement() {
		x+=(int)(Math.cos(angle)*xVelocity);
		y+=(int)(Math.sin(angle)*yVelocity);
		
		if(x+width<0 || x>display.getWidth() || y+height<0 || y>display.getHeight()) {
			display.getRunState().removeBullet(this);
		}
	}
}
