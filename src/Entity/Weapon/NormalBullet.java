package Entity.Weapon;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Creature.NormalEnemy;
import Entity.Creature.TrackingEnemy;
import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class NormalBullet extends Weapon implements Tickable,Renderable {
	
	public static int BULLETSIZE=10;
	
	public static int BULLETVELOCITY=20;
	
	private double angle;
	
	private Color color=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	
	public NormalBullet(Display display,int x,int y,int damage,double angle) {
		super(display,x,y,damage);
		this.angle=angle;
	}
	
	public void tick() {
		x+=Math.cos(angle)*BULLETVELOCITY;
		y+=Math.sin(angle)*BULLETVELOCITY;
		
		deleteTick();
		collideTick();
	}
	
	private void deleteTick() {
		if(x+BULLETSIZE<=0 || x>=display.getWidth()) {
			display.getRunState().removeNormalBullet(this);
		}
		
		if(y+BULLETSIZE<=0 || y>=display.getHeight()) {
			display.getRunState().removeNormalBullet(this);
		}
	}
	
	private void collideTick() {
		for(int i=0;i<display.getRunState().getNormalEnemies().size();i++) {
			NormalEnemy enemy=display.getRunState().getNormalEnemies().get(i);
			
			if(enemy.getX()+NormalEnemy.NORMALENEMYSIZE>x && enemy.getX()<x+BULLETSIZE) {
				if(enemy.getY()+NormalEnemy.NORMALENEMYSIZE>y && enemy.getY()<y+BULLETSIZE) {
					display.getRunState().removeNormalEnemy(enemy);
					display.getRunState().setScore(display.getRunState().getScore()+10);
					display.getRunState().removeNormalBullet(this);
					return;
				}
			}
		}
		
		for(int i=0;i<display.getRunState().getTrackingEnemies().size();i++) {
			TrackingEnemy enemy=display.getRunState().getTrackingEnemies().get(i);
			
			if(enemy.getX()+NormalEnemy.NORMALENEMYSIZE>x && enemy.getX()<x+BULLETSIZE) {
				if(enemy.getY()+NormalEnemy.NORMALENEMYSIZE>y && enemy.getY()<y+BULLETSIZE) {
					display.getRunState().removeTrackingEnemy(enemy);
					display.getRunState().setScore(display.getRunState().getScore()+10);
					display.getRunState().removeNormalBullet(this);
					return;
				}
			}
		}
	}
	
	public void render(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,BULLETSIZE,BULLETSIZE);
	}
}
