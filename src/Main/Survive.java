package Main;

import java.awt.Toolkit;

public class Survive {
	
	private final String title="Survive";
	
	private int width;
	
	private int height;
	
	private Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new Survive();
	}
	
	private Survive() {
		getDimension();
		
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
	
	private void getDimension() {
		Toolkit toolKit=Toolkit.getDefaultToolkit();
		
		width=(int)(toolKit.getScreenSize().getWidth());
		
		height=(int)(toolKit.getScreenSize().getHeight());	
	}
	
}
