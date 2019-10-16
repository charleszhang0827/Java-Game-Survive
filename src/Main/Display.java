package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import Handler.KeyActionHandler;
import Handler.MouseActionHandler;
import Handler.MouseMotionHandler;
import State.AboutState;
import State.EndState;
import State.HelpState;
import State.PauseState;
import State.RunState;
import State.StartState;
import State.State;

public class Display implements Runnable {
	
	private Thread thread;
	
	private Window window;
	
	private boolean running;
	
	private double tpt=1000000000/60;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private KeyActionHandler keyActionHandler;
	
	private MouseActionHandler mouseActionHandler;
	
	private MouseMotionHandler mouseMotionHandler;
	
	public StartState startState;
	
	private HelpState helpState;
	
	private AboutState aboutState;
	
	private RunState runState;
	
	private PauseState pauseState;
	
	private EndState endState;
	
	public Display(Window window) {
		thread=new Thread(this);
		this.window=window;
		
		setup();
		
		createHandler();
		
		createState();
	}
	
	private void setup() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			setup();
		}
		
		g=bs.getDrawGraphics();
	}
	
	private void createHandler() {
		window.getCanvas().requestFocus();
		
		keyActionHandler=new KeyActionHandler();
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
		pauseState=new PauseState(this);
		endState=new EndState(this);
		
		State.setState(startState);
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
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
	
	private void tick() {
		keyActionHandler.tick();
		
		if(keyActionHandler.getExit()) {
			stop();
		}
		
		if(State.getState()==startState) {
			startState.tick();
		}else if(State.getState()==helpState) {
			helpState.tick();
		}else if(State.getState()==aboutState) {
			aboutState.tick();
		}else if(State.getState()==runState) {
			runState.tick();
		}else if(State.getState()==pauseState) {
			pauseState.tick();
		}else if(State.getState()==endState) {
			endState.tick();
		}
	}
	
	private void render() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0,0,getWidth(),getHeight());
		
		if(State.getState()==startState) {
			startState.render((Graphics2D)g);
		}else if(State.getState()==helpState) {
			helpState.render((Graphics2D)g);
		}else if(State.getState()==aboutState) {
			aboutState.render((Graphics2D)g);
		}else if(State.getState()==runState) {
			runState.render((Graphics2D)g);
		}else if(State.getState()==pauseState) {
			pauseState.render((Graphics2D)g);
		}else if(State.getState()==endState) {
			endState.render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public Window getWindow() {
		return window;
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
	
	public BufferStrategy getBufferStrategy() {
		return bs;
	}
	
	public Graphics getGraphics() {
		return g;
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
		return this.startState;
	}
	
	public HelpState getHelpState() {
		return helpState;
	}
	
	public AboutState getAboutState() {
		return aboutState;
	}
	
	public void resetRunState() {
		runState=new RunState(this);
	}
	
	public RunState getRunState() {
		return runState;
	}
	
	public PauseState getPauseState() {
		return pauseState;
	}
	
	public void resetEndState() {
		endState=new EndState(this);
	}
	
	public EndState getEndState() {
		return endState;
	}
	
	public void resetTick() {
		startState.setTickDelta(1);
		helpState.setTickDelta(1);
		aboutState.setTickDelta(1);
		runState.setTickDelta(1);
		pauseState.setTickDelta(1);
		endState.setTickDelta(1);
	}
}
