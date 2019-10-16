package Entity.Creature;

import java.awt.Color;
import java.awt.Graphics2D;

import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class TrackingEnemy extends Creature implements Tickable,Renderable {
	
	public static final int TRACKINGENEMYSIZE=40;
	
	private static final int TRACKINGENEMYVELOCITY=4;
	
	public TrackingEnemy(Display display,int x,int y,int health) {
		super(display,x,y,health);
	}
	
	public void tick() {
		move();
		
		collideTick();
	}
	
	private void move() {
		Player player=display.getRunState().getPlayer();
		double angle=Math.toRadians(calculateAngle(x,y,player.getX(),player.getY()));
		x+=Math.cos(angle)*TRACKINGENEMYVELOCITY;
		y+=Math.sin(angle)*TRACKINGENEMYVELOCITY;
	}
	
	private void collideTick() {
		Player player=display.getRunState().getPlayer();
		if(x+TRACKINGENEMYSIZE>player.getX() && x<player.getX()+Player.PLAYERSIZE) {
			if(y+TRACKINGENEMYSIZE>player.getY() && y<player.getY()+Player.PLAYERSIZE) {
				player.setHealth(player.getHealth()-5);
				display.getRunState().removeTrackingEnemy(this);
				return;
			}
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x,y,TRACKINGENEMYSIZE,TRACKINGENEMYSIZE);
	}
	
	private double calculateAngle(int x,int y,int targetX,int targetY) {
		double angle=Math.toDegrees(Math.atan2(targetY-y,targetX-x));
		
		if(angle<0) {
			return (angle+360);
		}else {
			return angle;
		}
	}
}
