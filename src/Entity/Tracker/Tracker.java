package Entity.Tracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Entity.Entity;
import Enum.Variable;
import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public class Tracker extends Entity implements Tickable,Renderable {
	private Rectangle renderRectangle;
	
	private String text;
	
	private Font font;
	
	private Variable variable;
	
	public Tracker(Display display,int x,int y,int width,int height,String text,Font font,Variable variable) {
		super(display,x,y);
		
		renderRectangle=new Rectangle(x,y,width,height);
		
		this.text=text;
		
		this.font=font;
		
		this.variable=variable;
	}
	
	public void tick() {
		if(variable==Variable.score) {
			text="Score: "+display.getRunState().getScore();
		}else if(variable==Variable.health) {
			text="Health: "+display.getRunState().getPlayer().getHealth()+"/"+display.getRunState().getPlayer().getHealthRange();
		}
	}
	
	public void render(Graphics2D g) {
		this.drawCenterText(g,renderRectangle,font,Color.WHITE,text);
	}
}
