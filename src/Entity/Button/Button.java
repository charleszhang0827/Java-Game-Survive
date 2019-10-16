package Entity.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Entity.Entity;
import Enum.Action;
import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class Button extends Entity implements Tickable,Renderable {
	
	private Rectangle renderRectangle;
	
	private Rectangle tickRectangle;
	
	private String text;
	
	private Font font;
	
	private Action action;
	
	public Button(Display display,int x,int y,int width,int height,String text,Font font,Action action) {
		super(display,x,y);
		
		renderRectangle=new Rectangle(x,y,width,height);
		
		FontMetrics fontMetrics=display.getGraphics().getFontMetrics(font);
		
		int tickX=renderRectangle.x+(renderRectangle.width-fontMetrics.stringWidth(text))/2;
		
		int tickY=renderRectangle.y+(renderRectangle.height-fontMetrics.getHeight())/2;
		
		tickRectangle=new Rectangle(tickX,tickY,fontMetrics.stringWidth(text),fontMetrics.getAscent());
		
		this.text=text;
		
		this.font=font;
		
		this.action=action;
	}
	
	public void tick() {
		updateAction(display,tickRectangle,action);
	}
	
	public void render(Graphics2D g) {
		this.drawCenterText(g,renderRectangle,font,Color.WHITE,text);
	}
}
