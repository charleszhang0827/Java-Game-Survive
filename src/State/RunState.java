package State;

import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;

import Entity.Creature.NormalEnemy;
import Entity.Creature.Player;
import Entity.Creature.TrackingEnemy;
import Entity.Tracker.Tracker;
import Entity.Weapon.NormalBullet;
import Enum.Variable;
import Main.Display;

public class RunState extends State {
	
	private int score=0;
	
	private Tracker scoreTracker;
	
	private Tracker healthTracker;
	
	private Player player;
	
	private LinkedList<NormalEnemy> normalEnemies=new LinkedList<NormalEnemy>();
	
	private int normalEnemyTick;
	
	private int normalEnemyDelta=60;
	
	private LinkedList<TrackingEnemy> trackingEnemies=new LinkedList<TrackingEnemy>();
	
	private int trackingEnemyTick;
	
	private int trackingEnemyDelta=120;
	
	private LinkedList<NormalBullet> normalBullets=new LinkedList<NormalBullet>();
	
	public RunState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		int playerX=(display.getWidth()-50)/2;
		int playerY=(display.getHeight()-50)/2;
		player=new Player(display,playerX,playerY,50);
		
		Font font=new Font("TimesRoman",Font.ITALIC,50);
		
		healthTracker=new Tracker(display,0,50,display.getWidth()/2,50,"Health"+player.getHealth(),font,Variable.health);
		scoreTracker=new Tracker(display,display.getWidth()/2,50,display.getWidth()/2,50,"Score: "+score,font,Variable.score);
	}
	
	public void tick() {
		
		gameEndTick();
		
		scoreTracker.tick();
		
		healthTracker.tick();
		
		player.tick();
		
		generateNormalEnemy();
		
		generateTrackingEnemy();
		
		pauseTick();
		
		for(int i=0;i<normalEnemies.size();i++) {
			normalEnemies.get(i).tick();
		}
		
		for(int i=0;i<trackingEnemies.size();i++) {
			trackingEnemies.get(i).tick();
		}
		
		for(int i=0;i<normalBullets.size();i++) {
			normalBullets.get(i).tick();
		}
	}
	
	private void gameEndTick() {
		if(player.getHealth()<=0) {
			display.resetEndState();
			display.resetRunState();
			State.setState(display.getEndState());
		}
	}
	
	private void generateNormalEnemy() {
		if(normalEnemyTick%normalEnemyDelta==0 && normalEnemyTick!=0) {
			
			int x=(int)(Math.random()*(display.getWidth()-NormalEnemy.NORMALENEMYSIZE));
			
			int y=(int)(Math.random()*(display.getHeight()-NormalEnemy.NORMALENEMYSIZE));
			
			normalEnemies.add(new NormalEnemy(display,x,y,10));
			
			normalEnemyTick=0;
		}
		normalEnemyTick++;
	}
	
	private void generateTrackingEnemy() {
		if(trackingEnemyTick%trackingEnemyDelta==0 && trackingEnemyTick!=0) {
			int x=(int)(Math.random()*(display.getWidth()-TrackingEnemy.TRACKINGENEMYSIZE));
			
			int y=(int)(Math.random()*(display.getHeight()-TrackingEnemy.TRACKINGENEMYSIZE));
			
			trackingEnemies.add(new TrackingEnemy(display,x,y,10));
			
			trackingEnemyTick=0;
		}
		trackingEnemyTick++;
	}
	
	private void pauseTick() {
		if(display.getKeyActionHandler().getPause()) {
			State.setState(display.getPauseState());
		}
	}
	
	public void render(Graphics2D g) {
		
		scoreTracker.render(g);
		
		healthTracker.render(g);
		
		player.render(g);
		
		for(int i=0;i<normalEnemies.size();i++) {
			normalEnemies.get(i).render(g);
		}
		
		for(int i=0;i<trackingEnemies.size();i++) {
			trackingEnemies.get(i).render(g);
		}
		
		for(int i=0;i<normalBullets.size();i++) {
			normalBullets.get(i).render(g);
		}
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public LinkedList<NormalBullet> getNormalBullets() {
		return normalBullets;
	}
	
	public void addNormalBullet(NormalBullet normalBullet) {
		normalBullets.add(normalBullet);
	}
	
	public void removeNormalBullet(NormalBullet normalBullet) {
		normalBullets.remove(normalBullet);
	}
	
	public LinkedList<NormalEnemy> getNormalEnemies() {
		return normalEnemies;
	}
	
	public void addNormalEnemy(NormalEnemy normalEnemy) {
		normalEnemies.add(normalEnemy);
	}
	
	public void removeNormalEnemy(NormalEnemy normalEnemy) {
		normalEnemies.remove(normalEnemy);
	}
	
	public LinkedList<TrackingEnemy> getTrackingEnemies() {
		return trackingEnemies;
	}
	
	public void addTrackingEnemy(TrackingEnemy trackingEnemy) {
		trackingEnemies.add(trackingEnemy);
	}
	
	public void removeTrackingEnemy(TrackingEnemy trackingEnemy) {
		trackingEnemies.remove(trackingEnemy);
	}
}
