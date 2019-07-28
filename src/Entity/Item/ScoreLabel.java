package Entity.Item;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Label.Label;
import Main.Display;

public class ScoreLabel extends Label {
	
	private int score;
	
	public ScoreLabel(Display display,int x,int y,int width,int height,String text,Font font,Color color) {
		super(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		score=display.getRunState().getScore();
	}
	
	public void render(Graphics2D g) {
		g.setFont(font);
		g.setColor(color);
		g.drawString("Score: "+score,x,y);
	}
}
