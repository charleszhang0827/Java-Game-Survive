package State;

import Interface.Renderable;
import Interface.Tickable;
import Main.Display;

public abstract class State implements Tickable,Renderable {
	private static State currentState;
	
	public static void setState(State state) {
		currentState=state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	protected Display display;
	
	protected double tickDelta=1;
	
	public State(Display display) {
		this.display=display;
	}
	
	public void setTickDelta(int tickDelta) {
		this.tickDelta=tickDelta;
	}
}
