package Interface;

import java.awt.Rectangle;

import Entity.Creature.Player;
import Enum.Action;
import Main.Display;
import State.State;

public interface Tickable {
	public abstract void tick();
	
	public default void updateAction(Display display,Rectangle rectangle,Action action) {
			
		int mouseX=display.getMouseMotionHandler().getX();
			
		int mouseY=display.getMouseMotionHandler().getY();
			
		if(display.getMouseActionHandler().getPressed()) {
			if(mouseX>rectangle.x && mouseX<rectangle.x+rectangle.width) {
				if(mouseY>rectangle.y && mouseY<rectangle.y+rectangle.height) {
					if(action==Action.start) {
						State.setState(display.getStartState());
					}else if(action==Action.help) {
						State.setState(display.getHelpState());
					}else if(action==Action.about) {
						State.setState(display.getAboutState());
					}else if(action==Action.run) {
						State.setState(display.getRunState());
					}else if(action==Action.end) {
						display.resetEndState();
						State.setState(display.getEndState());
					}else if(action==Action.restart) {
						display.resetRunState();
						State.setState(display.getRunState());
					}else if(action==Action.healthRefill) {
						Player player=display.getRunState().getPlayer();
						
						if(player.getHealth()!=player.getHealthRange()) {
							if(display.getRunState().getScore()>600) {
								player.setHealth(player.getHealthRange());
								display.getRunState().setScore(display.getRunState().getScore()-600);
							}
						}
					}
					display.resetTick();
				}
			}
		}
	}
}
