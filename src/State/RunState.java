package State;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.LinkedList;

import Entity.Creature.Enemy;
import Entity.Creature.Player;
import Entity.Item.HealthLabel;
import Entity.Item.ScoreLabel;
import Entity.Weapon.Bullet;
import Entity.Weapon.Wave;
import Main.Display;

public class RunState extends State {
	
	private int playerWidth=50;
	
	private int playerHeight=50;
	
	private int playerXVelocity=6;
	
	private int playerYVelocity=6;
	
	private int playerHealth=50;
	
	private Player player;
	
	private int enemyWidth=30;
	
	private int enemyHeight=30;
	
	private int enemyXVelocity=4;
	
	private int enemyYVelocity=4;
	
	private int enemyHealth=20;
	
	private double enemyDelta=0;
	
	private LinkedList<Enemy> enemies=new LinkedList<Enemy>();
	
	private HealthLabel healthLabel;
	
	private ScoreLabel scoreLabel;
	
	private LinkedList<Bullet> bullets=new LinkedList<Bullet>();
	
	private LinkedList<Wave> waves=new LinkedList<Wave>();
	
	private int score=0;
	
	public RunState(Display display) {
		super(display);
		
		createObject();
	}
	
	private void createObject() {
		
		int playerX=display.getWidth()/2-playerWidth/2;
		
		int playerY=display.getHeight()/2-playerHeight/2;
		
		player=new Player(display,playerX,playerY,playerWidth,playerHeight,playerHealth,playerXVelocity,playerYVelocity);
		
		healthLabel=new HealthLabel(display,0,0,0,0,"",null,null);
		
		scoreLabel=new ScoreLabel(display,20,20,0,0,"",new Font("TimesRoman",Font.ITALIC,20),Color.WHITE);
		
	}
	
	public void tick() {
		player.tick();
		
		enemySpawn();
		
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).tick();
		}
		
		healthLabel.tick();
		
		scoreLabel.tick();
		
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).tick();
		}
		
		for(int i=0;i<waves.size();i++) {
			waves.get(i).tick();
		}
		
		if(display.getKeyActionHandler().getToMenuState()) {
			State.setState(display.getMenuState());
			display.getKeyActionHandler().setToMenuState(false);
		}
		
	}
	
	private void enemySpawn() {
		enemyDelta+=0.05;
		
		if(enemyDelta>=1) {
			
			int enemyX=(int)(Math.random()*(display.getWidth()-2*enemyWidth)+enemyWidth);
			
			int enemyY=(int)(Math.random()*(display.getHeight()-2*enemyHeight)+enemyHeight);
			
			int gaps=80;
			
			if(enemyX+enemyWidth+gaps<player.getX() || enemyX-gaps>player.getX()) {
				if(enemyY+enemyHeight+gaps<player.getY() || enemyY-gaps>player.getY()) {
			
					enemies.add(new Enemy(display,enemyX,enemyY,enemyWidth,enemyHeight,enemyHealth,enemyXVelocity,enemyYVelocity));
			
					enemyDelta--;
				}
			}
		}
	}
	
	public void render(Graphics2D g) {
		player.render(g);
		
		for(int i=0;i<enemies.size();i++) {
			enemies.get(i).render(g);
		}
		
		healthLabel.render(g);
		
		scoreLabel.render(g);
		
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).render(g);
		}
		
		for(int i=0;i<waves.size();i++) {
			waves.get(i).render(g);
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public LinkedList<Enemy> getEnemies(){
		return enemies;
	}
	
	public void addEnemy(Enemy enemy) {
		enemies.add(enemy);
	}
	
	public void removeEnemy(Enemy enemy) {
		enemies.remove(enemy);
	}
	
	public LinkedList<Bullet> getBullets(){
		return bullets;
	}
	
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}
	
	public LinkedList<Wave> getWaves(){
		return waves;
	}
	
	public void addWave(Wave wave) {
		waves.add(wave);
	}
	
	public void removeWave(Wave wave) {
		waves.remove(wave);
	}
	
	public void setScore(int score) {
		this.score=score;
	}
	
	public int getScore() {
		return score;
	}
}
