package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class AboutState extends State {
	
	private Label about;
	
	private Label version;
	
	private Label developer;
	
	private Label github;
	
	private Button back;
	
	public AboutState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		int start=(display.getHeight()-800)/4;
		
		about=new Label(display,0,start,display.getWidth(),200,"About",new Font("TimesRoman",Font.ITALIC,150));
		
		version=new Label(display,0,start+250,display.getWidth(),100,"Version: Nov.26.2017",new Font("TimesRoman",Font.ITALIC,50));
		
		developer=new Label(display,0,start+400,display.getWidth(),100,"Developer: Dominic Jiang",new Font("TimesRoman",Font.ITALIC,50));
		
		github=new Label(display,0,start+550,display.getWidth(),100,"Github: Java-Game-Survive",new Font("TimesRoman",Font.ITALIC,50));
		
		back=new Button(display,0,start+700,display.getWidth(),100,"Back",new Font("TimesRoman",Font.ITALIC,75),Action.start);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			back.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		about.render(g);
		version.render(g);
		developer.render(g);
		github.render(g);
		back.render(g);
	}
}
