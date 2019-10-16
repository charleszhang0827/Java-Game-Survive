package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface Renderable {
	public abstract void render(Graphics2D g);
	
	public default void drawCenterText(Graphics2D g,Rectangle rectangle,Font font,Color color,String text) {
		FontMetrics fontMetrics=g.getFontMetrics(font);
		
		int x=rectangle.x+(rectangle.width-fontMetrics.stringWidth(text))/2;
		
		int y=rectangle.y+(rectangle.height- fontMetrics.getHeight())/2+fontMetrics.getAscent();
		
		g.setColor(color);
		
		g.setFont(font);
		
		g.drawString(text,x,y);
	}
}
