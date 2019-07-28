package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.AboutState.AboutStateBackButton;
import Entity.Label.Label;
import Main.Display;

public class AboutState extends State {
	
	private Label aboutLabel;
	
	private Label authorLabel;
	
	private Label versionLabel;
	
	private Label noteLabel;
	
	private AboutStateBackButton aboutStateBackButton;
	
	public AboutState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		createAboutLabel();
		
		createAuthorLabel();
		
		createVersionLabel();
		
		createNoteLabel();
		
		createAboutStateBackButton();
	}
	
	private void createAboutLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=0;
		int height=display.getHeight()/5*1;
		
		String text="About";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/2);
		
		Color color=Color.WHITE;
		
		aboutLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createAuthorLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*1;
		int height=display.getHeight()/5*1;
		
		String text="Author: Dominic Jiang";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		authorLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createVersionLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*2;
		int height=display.getHeight()/5*1;
		
		String text="Version: 1.0.0.0";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		versionLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createNoteLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*3;
		int height=display.getHeight()/5*1;
		
		String text="For more: Check out dominicjiang on github";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		noteLabel=new Label(display,x,y,width,height,text,font,color);
	}
	
	private void createAboutStateBackButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*4;
		int height=display.getHeight()/5*1;
		
		String text="Back";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/4);
		
		Color color=Color.WHITE;
		
		aboutStateBackButton=new AboutStateBackButton(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		aboutLabel.tick();
		authorLabel.tick();
		versionLabel.tick();
		noteLabel.tick();
		aboutStateBackButton.tick();
	}
	
	public void render(Graphics2D g) {
		aboutLabel.render(g);
		authorLabel.render(g);
		versionLabel.render(g);
		noteLabel.render(g);
		aboutStateBackButton.render(g);
	}
	
	public AboutStateBackButton getAboutStateBackButton() {
		return aboutStateBackButton;
	}
}
