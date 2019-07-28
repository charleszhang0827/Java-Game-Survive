package Entity.Item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Label.Label;
import Main.Display;

public class HealthLabel extends Label {
	
	private int healthLeft;
	
	public HealthLabel(Display display,int x,int y,int width,int height,String text,Font font,Color color) {
		super(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		healthLeft=display.getRunState().getPlayer().getHealth();
	}
	
	public void render(Graphics2D g) {
		
		int playerX=display.getRunState().getPlayer().getX();
		
		int playerY=display.getRunState().getPlayer().getY();
		
		g.setColor(Color.GRAY);
		g.fillRect(playerX,playerY-15,50,10);
		
		g.setColor(Color.GREEN);
		g.fillRect(playerX,playerY-15,healthLeft,10);
		
		g.setColor(Color.WHITE);
		g.drawRect(playerX,playerY-15,50,10);
		
	}
}
