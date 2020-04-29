import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Display{

	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private Canvas canvas;
	private String title;
	private int width;
	private int height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		window();
	}
	
	private void window() {		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
//		panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		
//		label = new JLabel("Hello World!");
//		
//        ImageIcon image = new ImageIcon("C:\\Users\\lione\\Pictures\\BnS\\170627_000.jpg");
//        label = new JLabel(image);
//		
//		panel.add(label);
//		
//		frame.add(panel);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		

		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
