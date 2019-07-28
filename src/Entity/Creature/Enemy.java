package Entity.Creature;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Weapon.Bullet;
import Entity.Weapon.Wave;
import Main.Display;

public class Enemy extends Creature {
	
	private double angle=Math.random()*360;
	
	public Enemy(Display display,int x,int y,int width,int height,int health,int xVelocity,int yVelocity) {
		super(display,x,y,width,height,health,xVelocity,yVelocity);
	}
	
	public void tick() {
		movement();
		collision();
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x,y,width,height);
	}
	
	private void movement() {
		x+=(int)(Math.cos(angle)*xVelocity);
		y+=(int)(Math.sin(angle)*yVelocity);
		
		if(x<=0 || x+width>=display.getWidth()) {
			xVelocity=-xVelocity;
		}
		
		if(y<=0 || y+height>display.getHeight()) {
			yVelocity=-yVelocity;
		}
	}
	
	private void collision() {
		Player player=display.getRunState().getPlayer();
		
		if(x+width>=player.getX() && x<=player.getX()+player.getWidth()) {
			if(y+height>=player.getY() && y<player.getY()+player.getHeight()) {
				player.setHealth(player.getHealth()-5);
				display.getRunState().removeEnemy(this);
			}
		}
		
		for(int i=0;i<display.getRunState().getBullets().size();i++) {
			Bullet bullet=display.getRunState().getBullets().get(i);
			
			if(bullet.getX()+bullet.getWidth()>=x && bullet.getX()<=x+width) {
				if(bullet.getY()+bullet.getHeight()>=y && bullet.getY()<=y+height) {
					display.getRunState().removeBullet(bullet);
					display.getRunState().removeEnemy(this);
					display.getRunState().setScore(display.getRunState().getScore()+15);
					break;
				}
			}
		}
		
		for(int i=0;i<display.getRunState().getWaves().size();i++) {
			Wave wave=display.getRunState().getWaves().get(i);
			
			if(wave.getX()+wave.getWidth()>=x && wave.getX()<=x+width) {
				if(wave.getY()+wave.getHeight()>=y && wave.getY()<=y+height) {
					wave.touched=true;
					display.getRunState().setScore(display.getRunState().getScore()+15);
					display.getRunState().removeEnemy(this);
					
				}
			}
		}
		
	}
}
