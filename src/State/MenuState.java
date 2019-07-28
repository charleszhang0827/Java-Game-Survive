package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Entity.Button.MenuState.MenuStateBackButton;
import Entity.Button.MenuState.RefillHealthButton;
import Entity.Button.MenuState.UpdateBulletVelocityButton;
import Entity.Button.MenuState.UpdatePlayerVelocityButton;
import Entity.Item.ScoreLabel;
import Entity.Label.Label;
import Main.Display;

public class MenuState extends State {
	
	private Label menuLabel;
	
	private ScoreLabel scoreLabel;
	
	private RefillHealthButton refillHealthButton;
	
	private UpdatePlayerVelocityButton updatePlayerVelocityButton;
	
	private UpdateBulletVelocityButton updateBulletVelocityButton;
	
	private MenuStateBackButton menuStateBackButton;
	
	public MenuState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		createMenuLabel();
		
		createRefillHealthButton();
		
		createUpdatePlayerVelocityButton();
		
		createUpdateBulletVelocityButton();
		
		createMenuStateBackButton();
		
		scoreLabel=new ScoreLabel(display,60,60,0,0,"",new Font("TimesRoman",Font.ITALIC,40),Color.WHITE);
	}
	
	private void createMenuLabel() {
		int x=0;
		int width=display.getWidth();
		
		int y=0;
		int height=display.getHeight()/5*1;
		
		String text="Menu";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/2);
		
		Color color=Color.WHITE;
		
		menuLabel=new Label(display,x,y,width,height,text,font,color);
		
	}
	
	private void createRefillHealthButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*1;
		int height=display.getHeight()/5*1;
		
		String text="Refill Health (Cost: 1500 Points)";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		refillHealthButton=new RefillHealthButton(display,x,y,width,height,text,font,color);
	}
	
	private void createUpdatePlayerVelocityButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*2;
		int height=display.getHeight()/5*1;
		
		String text="Update Player Velocity (Cost: 2000 Points)";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		updatePlayerVelocityButton=new UpdatePlayerVelocityButton(display,x,y,width,height,text,font,color);
	}
	
	private void createUpdateBulletVelocityButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*3;
		int height=display.getHeight()/5*1;
		
		String text="Update Bullet Velocity (Cost: 3000 Points)";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/6);
		
		Color color=Color.WHITE;
		
		updateBulletVelocityButton=new UpdateBulletVelocityButton(display,x,y,width,height,text,font,color);
	}
	
	private void createMenuStateBackButton() {
		int x=0;
		int width=display.getWidth();
		
		int y=display.getHeight()/5*4;
		int height=display.getHeight()/5*1;
		
		String text="Back";
		
		Font font=new Font("TimesRoman",Font.ITALIC,(width/4+height/4)/4);
		
		Color color=Color.WHITE;
		
		menuStateBackButton=new MenuStateBackButton(display,x,y,width,height,text,font,color);
	}
	
	public void tick() {
		menuLabel.tick();
		scoreLabel.tick();
		refillHealthButton.tick();
		updatePlayerVelocityButton.tick();
		updateBulletVelocityButton.tick();
		menuStateBackButton.tick();
		if(display.getKeyActionHandler().getToRunState()) {
			State.setState(display.getRunState());
			display.getKeyActionHandler().setToRunState(false);
		}
	}
	
	public void render(Graphics2D g) {
		menuLabel.render(g);
		scoreLabel.render(g);
		refillHealthButton.render(g);
		updatePlayerVelocityButton.render(g);
		updateBulletVelocityButton.render(g);
		menuStateBackButton.render(g);
	}
}
