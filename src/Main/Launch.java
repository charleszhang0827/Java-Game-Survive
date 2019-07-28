package Main;

import java.awt.Toolkit;

public class Launch {
	
	private final String title="Survive";
	
	private final int width;
	
	private final int height;
	
	public Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new Launch();
	}
	
	public Launch() {
		
		Toolkit toolKit=Toolkit.getDefaultToolkit();
		
		width=(int)(toolKit.getScreenSize().getWidth());
		
		height=(int)(toolKit.getScreenSize().getHeight());
		
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
}
