package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import State.GameState;
import State.State;

public class Display implements Runnable {
	private Thread thread;
	
	private boolean running=false;
	
	private Window window;
	
	private BufferStrategy bs;
	
	private Graphics g;
	
	private double tpt=1000000000/60;
	
	private GameState gameState;
	
	public Display(Window window) {
		thread=new Thread(this);
		this.window=window;
		
		createState();
	}
	
	public synchronized void start() {
		running=true;
		thread.start();
	}
	
	private void createState() {
		gameState=new GameState(this);
		
		State.setState(gameState);
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
		if(State.getState()==gameState) {
			gameState.tick();
		}
	}
	
	public void render() {
		bs=window.getCanvas().getBufferStrategy();
		
		if(bs==null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		if(State.getState()==gameState) {
			gameState.render((Graphics2D)g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public int getWidth() {
		return window.getWidth();
	}
	
	public int getHeight() {
		return window.getHeight();
	}
}
