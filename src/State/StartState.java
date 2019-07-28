package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.StartState.AboutButton;
import Entity.Button.StartState.HelpButton;
import Entity.Button.StartState.PlayButton;
import Entity.Label.Label;
import Main.Display;

public class StartState extends State {
	
	private Label surviveLabel;
	
	private PlayButton playButton;
	
	private HelpButton helpButton;
	
	private AboutButton aboutButton;
	
	public StartState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		createSurviveLabel();
		
		createPlayButton();
		
		createHelpButton();
		
		createAboutButton();
	}
	
	private void createSurviveLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=0;
		int height=display.getHeight()/4*1;
		
		String text="Survive";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/2);
		
		Color color=Color.WHITE;
		
		surviveLabel=new Label(display,x,y,width,height,text,font,color);
		
	}
	
	private void createPlayButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*1;
		int height=display.getHeight()/4*1;
		
		String text="Play";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/3);
		
		Color color=Color.WHITE;
		
		playButton=new PlayButton(display,x,y,width,height,text,font,color);
		
	}
	
	private void createHelpButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*2;
		int height=display.getHeight()/4*1;
		
		String text="Help";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/3);
		
		Color color=Color.WHITE;
		
		helpButton=new HelpButton(display,x,y,width,height,text,font,color);
		
	}
	
	private void createAboutButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/4*3;
		int height=display.getHeight()/4*1;
		
		String text="About";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/3);
		
		Color color=Color.WHITE;
		
		aboutButton=new AboutButton(display,x,y,width,height,text,font,color);
		
	}
	
	public void tick() {
		surviveLabel.tick();
		playButton.tick();
		helpButton.tick();
		aboutButton.tick();
	}
	
	public void render(Graphics2D g) {
		surviveLabel.render(g);
		playButton.render(g);
		helpButton.render(g);
		aboutButton.render(g);
	}
	
	public AboutButton getAboutButton() {
		return aboutButton;
	}
}
