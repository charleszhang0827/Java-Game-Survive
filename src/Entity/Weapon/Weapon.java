package Entity.Weapon;

import Entity.Entity;
import Main.Display;

public abstract class Weapon extends Entity {
	protected int damage;
	
	public Weapon(Display display,int x,int y,int damage) {
		super(display,x,y);
		this.damage=damage;
	}
	
	public void setDamage(int damage) {
		this.damage=damage;
	}
	
	public int getDamage() {
		return damage;
	}
}
