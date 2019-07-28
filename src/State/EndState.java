package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.EndState.RestartButton;
import Entity.Button.EndState.ToStartStateButton;
import Entity.Label.Label;
import Main.Display;

public class EndState extends State {
	
	private Label endLabel;
	
	private Label scoreLabel;
	
	private RestartButton restartButton;
	
	private ToStartStateButton toStartStateButton;
	
	public EndState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		createEndLabel();
		
		createScoreLabel();
		
		createRestartButton();
		
		createToStartStateButton();
	}
	
	private void createEndLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=0;
		int height=display.getHeight()/4*1;
		
		String text="The last survivor is down";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/4);
		
		Color color=Color.WHITE;
		
		endLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createScoreLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*1;
		int height=display.getHeight()/4*1;
		
		String text="Your score: "+display.getRunState().getScore();
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/4);
		
		Color color=Color.WHITE;
		
		scoreLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createRestartButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*2;
		int height=display.getHeight()/4*1;
		
		String text="Restart";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/3);
		
		Color color=Color.WHITE;
		
		restartButton=new RestartButton(display,x,y,width,height,text,font,color);
	}
	
	private void createToStartStateButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*3;
		int height=display.getHeight()/4*1;
		
		String text="Menu";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/3);
		
		Color color=Color.WHITE;
		
		toStartStateButton=new ToStartStateButton(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		endLabel.tick();
		scoreLabel.tick();
		restartButton.tick();
		toStartStateButton.tick();
	}
	
	public void render(Graphics2D g) {
		endLabel.render(g);
		scoreLabel.render(g);
		restartButton.render(g);
		toStartStateButton.render(g);
	}
	
	public void setScoreLabel() {
		createScoreLabel();
	}
}
