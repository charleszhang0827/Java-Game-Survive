package Entity.Creature;

import Entity.Entity;
import Main.Display;

public abstract class Creature extends Entity {
	protected int health;
	
	public Creature(Display display,int x,int y,int health) {
		super(display,x,y);
		this.health=health;
	}
	
	public void setHealth(int health) {
		this.health=health;
	}
	
	public int getHealth() {
		return health;
	}
}
