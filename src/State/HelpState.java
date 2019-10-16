package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class HelpState extends State {
	
	private Label help;
	
	private Label one;
	
	private Label two;
	
	private Label three;
	
	private Button back;
	
	public HelpState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		
		int start=(display.getHeight()-800)/4;
		
		help=new Label(display,0,start,display.getWidth(),200,"Help",new Font("TimesRoman",Font.ITALIC,150));
		
		one=new Label(display,0,start+250,display.getWidth(),100,"Use w,s,a,d to move your player",new Font("TimesRoman",Font.ITALIC,50));
		
		two=new Label(display,0,start+400,display.getWidth(),100,"Press spacebar to pause the game",new Font("TimesRoman",Font.ITALIC,50));
		
		three=new Label(display,0,start+550,display.getWidth(),100,"Try to survive as long as possible",new Font("TimesRoman",Font.ITALIC,50));
		
		back=new Button(display,0,start+700,display.getWidth(),100,"Back",new Font("TimesRoman",Font.ITALIC,75),Action.start);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			back.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		help.render(g);
		one.render(g);
		two.render(g);
		three.render(g);
		back.render(g);
	}
}
