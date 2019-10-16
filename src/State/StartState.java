package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class StartState extends State {
	
	private Label title;
	
	private Button play;
	
	private Button help;
	
	private Button about;
	
	public StartState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		
		int start=(display.getHeight()-800)/4;
		
		title=new Label(display,0,start,display.getWidth(),200,"Survive",new Font("TimesRoman",Font.ITALIC,150));
		
		play=new Button(display,0,start+300,display.getWidth(),100,"Play",new Font("TimesRoman",Font.ITALIC,75),Action.run);
		
		help=new Button(display,0,start+500,display.getWidth(),100,"Help",new Font("TimesRoman",Font.ITALIC,75),Action.help);
		
		about=new Button(display,0,start+700,display.getWidth(),100,"About",new Font("TimesRoman",Font.ITALIC,75),Action.about);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			play.tick();
			help.tick();
			about.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		title.render(g);
		play.render(g);
		help.render(g);
		about.render(g);
	}
}
