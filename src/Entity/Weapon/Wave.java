package Entity.Weapon;

import java.awt.Color;
import java.awt.Graphics2D;

import Main.Display;

public class Wave extends Weapon {
	
	private double angle;
	
	public boolean touched;
	
	private final Color color=Color.YELLOW;
	
	public Wave(Display display,int x,int y,int width,int height,int damage,int xVelocity,int yVelocity,double angle) {
		super(display,x,y,width,height,damage,xVelocity,yVelocity);
		this.angle=angle;
	}
	
	public void tick() {
		movement();
		
		if(touched) {
			for(int i=0;i<10;i++) {
				display.getRunState().addWave(new Wave(display,x,y,width,height,damage,xVelocity,yVelocity,Math.random()*360));
			}
			touched=false;
			display.getRunState().removeWave(this);
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,width,height);
	}
	
	private void movement() {
		x+=(int)(Math.cos(angle)*xVelocity);
		y+=(int)(Math.sin(angle)*yVelocity);
		
		if(x+width<0 || x>display.getWidth() || y+height<0 || y>display.getHeight()) {
			display.getRunState().removeWave(this);
		}
	}
	
}
