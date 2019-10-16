package Entity.Creature;

import java.awt.Color;
import java.awt.Graphics2D;

import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class NormalEnemy extends Creature implements Tickable,Renderable {
	
	public static final int NORMALENEMYSIZE=40;
	
	private int normalEnemyXVelocity=6;
	
	private int normalEnemyYVelocity=6;
	
	private final double angle=Math.random()*360;
	
	public NormalEnemy(Display display,int x,int y,int health) {
		super(display,x,y,health);
	}
	
	public void tick() {
		move();
		collideTick();
	}
	
	private void move() {
		x+=Math.cos(Math.toRadians(angle))*normalEnemyXVelocity;
		y+=Math.sin(Math.toRadians(angle))*normalEnemyYVelocity;
		
		if(x<=0 || x+NORMALENEMYSIZE>=display.getWidth()) {
			normalEnemyXVelocity=-normalEnemyXVelocity;
		}
		
		if(y<=0 || y+NORMALENEMYSIZE>=display.getHeight()) {
			normalEnemyYVelocity=-normalEnemyYVelocity;
		}
	}
	
	private void collideTick() {
		Player player=display.getRunState().getPlayer();
		if(x+NORMALENEMYSIZE>player.getX() && x<player.getX()+Player.PLAYERSIZE) {
			if(y+NORMALENEMYSIZE>player.getY() && y<player.getY()+Player.PLAYERSIZE) {
				player.setHealth(player.getHealth()-5);
				display.getRunState().removeNormalEnemy(this);
				return;
			}
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x,y,NORMALENEMYSIZE,NORMALENEMYSIZE);
	}
}
