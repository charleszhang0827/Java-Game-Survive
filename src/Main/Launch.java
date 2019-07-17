package Main;

public class Launch {
	
	private final String title="Survive";
	
	private final int width=600;
	
	private final int height=600;
	
	public Window window;
	
	private Display display;
	
	public static void main(String[]args) {
		new Launch();
	}
	
	public Launch() {
		window=new Window(title,width,height);
		display=new Display(window);
		display.start();
	}
}
