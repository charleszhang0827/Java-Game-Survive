package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.HelpState.HelpStateBackButton;
import Entity.Label.Label;
import Main.Display;

public class HelpState extends State {
	
	private Label helpLabel;
	
	private Label moveLabel;
	
	private Label featureLabel;
	
	private Label goalLabel;
	
	private HelpStateBackButton helpStateBackButton;
	
	public HelpState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		createHelpLabel();
		
		createMoveLabel();
		
		createFeatureLabel();
		
		createGoalLabel();
		
		createHelpStateBackButton();
	}
	
	private void createHelpLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=0;
		int height=display.getHeight()/5*1;
		
		String text="Help";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/2);
		
		Color color=Color.WHITE;
		
		helpLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createMoveLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*1;
		int height=display.getHeight()/5*1;
		
		String text="Use W,S,A,D to move your player";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		moveLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createFeatureLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*2;
		int height=display.getHeight()/5*1;
		
		String text="Press space bar to check out menu";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		featureLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createGoalLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*3;
		int height=display.getHeight()/5*1;
		
		String text="Try to survive as long as possible";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		goalLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createHelpStateBackButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*4;
		int height=display.getHeight()/5*1;
		
		String text="Back";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/4);
		
		Color color=Color.WHITE;
		
		helpStateBackButton=new HelpStateBackButton(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		helpLabel.tick();
		moveLabel.tick();
		featureLabel.tick();
		goalLabel.tick();
		helpStateBackButton.tick();
	}
	
	public void render(Graphics2D g) {
		helpLabel.render(g);
		moveLabel.render(g);
		featureLabel.render(g);
		goalLabel.render(g);
		helpStateBackButton.render(g);
	}
}
