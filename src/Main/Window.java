package Main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private String title;
	
	private int width;
	
	private int height;
	
	private JFrame frame;
	
	private Canvas canvas;
	
	public Window(String title,int width,int height) {
		this.title=title;
		this.width=width;
		this.height=height;
		
		createWindow();
	}
	
	private void createWindow() {
		frame=new JFrame();
		frame.setSize(width,height);
		frame.setTitle(title);
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		frame.getContentPane().add(canvas,BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getGraphicsConfiguration().getDevice().setFullScreenWindow(frame);	
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
}
