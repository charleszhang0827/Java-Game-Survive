package Entity.Creature;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Weapon.Bullet;
import Entity.Weapon.Wave;
import Main.Display;
import State.State;

public class Player extends Creature {
	
	private final Color color=Color.WHITE;
	
	private int bulletWidth=10;
	
	private int bulletHeight=10;
	
	private int bulletDamage=10;
	
	private int bulletXVelocity=10;
	
	private int bulletYVelocity=10;
	
	private double bulletDelta=0;
	
	private double waveDelta=0;
	
	public Player(Display display,int x,int y,int width,int height,int health,int xVelocity,int yVelocity) {
		super(display,x,y,width,height,health,xVelocity,yVelocity);
	}
	
	public void tick() {
		movement();
		
		shoot();
		
		if(health<=0) {
			display.getEndState().setScoreLabel();
			State.setState(display.getEndState());
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		
		g.fillRect(x,y,width,height);
	}
	
	private void movement() {
		if(display.getKeyActionHandler().getLeft()) {
			x-=xVelocity;
		}
		
		if(display.getKeyActionHandler().getRight()) {
			x+=xVelocity;
		}
		
		if(display.getKeyActionHandler().getUp()) {
			y-=yVelocity;
		}
		
		if(display.getKeyActionHandler().getDown()) {
			y+=yVelocity;
		}
		
		if(x<=0) {
			x=0;
		}
		
		if(x+width>=display.getWidth()) {
			x=display.getWidth()-width;
		}
		
		if(y<=0) {
			y=0;
		}
		
		if(y+height>=display.getHeight()) {
			y=display.getHeight()-height;
		}
	}
	
	private void shoot() {
		if(display.getMouseActionHandler().getPressed()) {
			
			if(display.getKeyActionHandler().getWeaponOne()) {
				if(bulletDelta>=1) {
				
					double angle=Math.toRadians(calculateAngle(x,y,display.getMouseMotionHandler().getX(),display.getMouseMotionHandler().getY()));
					
					int x=this.x+width/2-bulletWidth/2;
					
					int y=this.y+height/2-bulletHeight/2;
					
					int width=bulletWidth;
					
					int height=bulletHeight;
					
					int damage=bulletDamage;
					
					int xVelocity=bulletXVelocity;
					
					int yVelocity=bulletYVelocity;
					
					display.getRunState().addBullet(new Bullet(display,x,y,width,height,damage,xVelocity,yVelocity,angle));
					
					bulletDelta--;
				}
			}else if(display.getKeyActionHandler().getWeaponTwo()) {
				if(waveDelta>=1) {
					double angle=Math.toRadians(calculateAngle(x,y,display.getMouseMotionHandler().getX(),display.getMouseMotionHandler().getY()));
					
					int x=this.x+width/2-bulletWidth/2;
					
					int y=this.y+height/2-bulletHeight/2;
					
					int width=bulletWidth;
					
					int height=bulletHeight;
					
					int damage=bulletDamage;
					
					int xVelocity=bulletXVelocity;
					
					int yVelocity=bulletYVelocity;
					
					display.getRunState().addWave(new Wave(display,x,y,width,height,damage,xVelocity,yVelocity,angle));
					
					waveDelta--;
				}
			}
		}
		
		if(bulletDelta<1) {
			bulletDelta+=0.16;
		}
		
		if(waveDelta<1) {
			waveDelta+=0.04;
		}
	}
	
	private double calculateAngle(int x,int y,int targetX,int targetY) {
		
		double angle=Math.toDegrees(Math.atan2(targetY-y,targetX-x));
		
		if(angle<0) {
			return (angle+360);
		}else {
			return angle;
		}
	}
	
	public void setBulletXVelocity(int bulletXVelocity) {
		this.bulletXVelocity=bulletXVelocity;
	}
	
	public int getBulletXVelocity() {
		return bulletXVelocity;
	}
	
	public void setBulletYVelocity(int bulletYVelocity) {
		this.bulletYVelocity=bulletYVelocity;
	}
	
	public int getBulletYVelocity() {
		return bulletYVelocity;
	}
}
