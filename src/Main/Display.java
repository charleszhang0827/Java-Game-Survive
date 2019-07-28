package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Handler.KeyActionHandler;
import Handler.MouseActionHandler;
import Handler.MouseMotionHandler;
import State.AboutState;
import State.EndState;
import State.HelpState;
import State.MenuState;
import State.RunState;
import State.StartState;
import State.State;

public class Display implements Runnable {
	private Thread thread;
	
	private boolean running=false;
	
	private Window window;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private double tpt=1000000000/60;
	
	private KeyActionHandler keyActionHandler;
	
	private MouseActionHandler mouseActionHandler;
	
	private MouseMotionHandler mouseMotionHandler;
	
	private StartState startState;
	
	private HelpState helpState;
	
	private AboutState aboutState;
	
	private RunState runState;
	
	private MenuState menuState;
	
	private EndState endState;
	
	public Display(Window window) {
		thread=new Thread(this);
		this.window=window;
		
		createHandler();
		createState();
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
	}
	
	private void createHandler() {
		window.getCanvas().requestFocus();
		
		keyActionHandler=new KeyActionHandler(this);
		window.getCanvas().addKeyListener(keyActionHandler);
		
		mouseActionHandler=new MouseActionHandler();
		window.getCanvas().addMouseListener(mouseActionHandler);
		
		mouseMotionHandler=new MouseMotionHandler();
		window.getCanvas().addMouseMotionListener(mouseMotionHandler);
	}
	
	private void createState() {
		startState=new StartState(this);
		
		helpState=new HelpState(this);
		
		aboutState=new AboutState(this);
		
		runState=new RunState(this);
		
		menuState=new MenuState(this);
		
		endState=new EndState(this);
		
		State.setState(startState);
	}
	
	public synchronized void stop() {
		running=false;
		System.exit(0);
	}
	
	public void run() {
		
		double delta=0;
		
		long last=System.nanoTime();
		
		long now;
		
		while(running) {
			
			now=System.nanoTime();
			
			delta+=(now-last)/tpt;
			
			last=now;
			
			if(delta>=1) {
				tick();
				render();
				delta--;
			
			}
		}
	}
	
	public void tick() {
		
		if(State.getState()==startState) {
			startState.tick();
		}else if(State.getState()==helpState) {
			helpState.tick();
		}else if(State.getState()==aboutState) {
			aboutState.tick();
		}else if(State.getState()==runState) {
			runState.tick();
		}else if(State.getState()==menuState) {
			menuState.tick();
		}else if(State.getState()==endState) {
			endState.tick();
		}
		
		keyActionHandler.tick();
	}
	
	public void render() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		g.fillRect(0,0,getWidth(),getHeight());
		
		if(State.getState()==startState) {
			startState.render((Graphics2D)g);
		}else if(State.getState()==helpState) {
			helpState.render((Graphics2D)g);
		}else if(State.getState()==aboutState) {
			aboutState.render((Graphics2D)g);
		}else if(State.getState()==runState) {
			runState.render((Graphics2D)g);
		}else if(State.getState()==menuState) {
			menuState.render((Graphics2D)g);
		}else if(State.getState()==endState) {
			endState.render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public final void reset() {
		runState=new RunState(this);
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
	
	public KeyActionHandler getKeyActionHandler() {
		return keyActionHandler;
	}
	
	public MouseActionHandler getMouseActionHandler() {
		return mouseActionHandler;
	}
	
	public MouseMotionHandler getMouseMotionHandler() {
		return mouseMotionHandler;
	}
	
	public StartState getStartState() {
		return startState;
	}
	
	public HelpState getHelpState() {
		return helpState;
	}
	
	public AboutState getAboutState() {
		return aboutState;
	}
	
	public RunState getRunState() {
		return runState;
	}
	
	public MenuState getMenuState() {
		return menuState;
	}
	
	public EndState getEndState() {
		return endState;
	}
}
