package Entity.Label;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Entity.Entity;
import Main.Display;

public class Label extends Entity {
	
	protected String text;
	
	protected Font font;
	
	protected Rectangle rectangle;
	
	protected Color color;
	
	private boolean claimed;
	
	protected int wordX;
	
	protected int wordWidth;
	
	protected int wordY;
	
	protected int wordHeight;
	
	public Label(Display display,int x,int y,int width,int height,String text,Font font,Color color) {
		super(display,x,y,width,height);
		this.rectangle=new Rectangle(x,y,width,height);
		this.text=text;
		this.font=font;
		this.color=color;
	}
	
	public void drawCenterText(Graphics2D g) {
		FontMetrics metrics=g.getFontMetrics(font);
		
		int x=rectangle.x+(rectangle.width-metrics.stringWidth(text))/2;
		
		int y=rectangle.y+(rectangle.height-metrics.getHeight())/2+metrics.getAscent();
		
		if(!claimed) {
			wordX=x;
		
			wordWidth=metrics.stringWidth(text);
		
			wordY=y-metrics.getAscent();
		
			wordHeight=metrics.getHeight();
			
			claimed=true;
		}
		
		g.setColor(color);
		
		g.setFont(font);
		
		g.drawString(text,x,y);
	}

	public void tick() {
		
	}

	public void render(Graphics2D g) {
		drawCenterText(g);
	}
}
