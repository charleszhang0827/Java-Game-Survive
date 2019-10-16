package State;

import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.Button;
import Entity.Label.Label;
import Enum.Action;
import Main.Display;

public class PauseState extends State {
	
	private Label pause;
	
	private Button healthRefill;
	
	private Button restart;
	
	private Button back;
	
	public PauseState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		
		int start=(display.getHeight()-800)/4;
		
		pause=new Label(display,0,start,display.getWidth(),200,"Pause",new Font("TimesRoman",Font.ITALIC,150));
		
		healthRefill=new Button(display,0,start+300,display.getWidth(),100,"RefillHealth (Cost: 600 pts)",new Font("TimesRoman",Font.ITALIC,50),Action.healthRefill);
		
		restart=new Button(display,0,start+500,display.getWidth(),100,"Restart",new Font("TimesRoman",Font.ITALIC,75),Action.restart);
		
		back=new Button(display,0,start+700,display.getWidth(),100,"Back",new Font("TimesRoman",Font.ITALIC,75),Action.run);
	}
	
	public void tick() {
		if(tickDelta<=0) {
			healthRefill.tick();
			restart.tick();
			back.tick();
		}
		tickDelta-=0.1;
	}
	
	public void render(Graphics2D g) {
		pause.render(g);
		healthRefill.render(g);
		restart.render(g);
		back.render(g);
	}
}
