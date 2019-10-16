package Entity.Label;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Entity.Entity;
import Interface.Renderable;
import Main.Display;

public class Label extends Entity implements Renderable {
	
	private Rectangle renderRectangle;
	
	private String text;
	
	private Font font;
	
	public Label(Display display,int x,int y,int width,int height,String text,Font font) {
		super(display,x,y);
		
		renderRectangle=new Rectangle(x,y,width,height);
		
		this.text=text;
		
		this.font=font;
	}

	public void render(Graphics2D g) {
		drawCenterText(g,renderRectangle,font,Color.WHITE,text);
	}
}
