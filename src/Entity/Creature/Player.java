package Entity.Creature;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Weapon.NormalBullet;
import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class Player extends Creature implements Tickable,Renderable {
	
	public static final int PLAYERSIZE=50;
	
	private int playerVelocity=8;
	
	private final int healthRange;
	
	private int normalBulletTick;
	
	private static final int normalBulletsDelta=10;
	
	public Player(Display display,int x,int y,int health) {
		super(display,x,y,health);
		healthRange=health;
	}
	
	public void tick() {
		move();
		
		shoot();
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect(x,y,PLAYERSIZE,PLAYERSIZE);
	}
	
	private void move() {
		if(display.getKeyActionHandler().getUp() && y>=0) {
			y-=playerVelocity;
		}
		
		if(display.getKeyActionHandler().getDown() && y+PLAYERSIZE<=display.getHeight()) {
			y+=playerVelocity;
		}
		
		if(display.getKeyActionHandler().getLeft() && x>=0) {
			x-=playerVelocity;
		}
		
		if(display.getKeyActionHandler().getRight() && x<=display.getWidth()) {
			x+=playerVelocity;
		}
		
		if(y<=0) {
			y=0;
		}else if(y+PLAYERSIZE>=display.getHeight()) {
			y=display.getHeight()-PLAYERSIZE;
		}
		
		if(x<=0) {
			x=0;
		}else if(x+PLAYERSIZE>=display.getWidth()) {
			x=display.getWidth()-PLAYERSIZE;
		}
	}
	
	private void shoot() {
		if(display.getMouseActionHandler().getPressed() && normalBulletTick%normalBulletsDelta==0) {
		
			int mouseX=display.getMouseMotionHandler().getX();
			
			int mouseY=display.getMouseMotionHandler().getY();
			if(display.getKeyActionHandler().getNormalBullet()) {
				display.getRunState().addNormalBullet(new NormalBullet(display,x+25,y+25,10,Math.toRadians(calculateAngle(x+25,y+25,mouseX,mouseY))));
			}
		
			normalBulletTick-=normalBulletsDelta;
		}
		
		if(normalBulletTick<normalBulletsDelta) {
			normalBulletTick++;
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
	
	public int getHealthRange() {
		return healthRange;
	}
}
