package yes;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.util.prefs.BackingStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;

public class MyPanel extends JPanel{

	private static JFrame frame = new JFrame();

	private ImageIcon backIc = new ImageIcon("C:\\Users\\aaa54\\eclipse-workspace\\yes\\src\\img\\logo.jpg");
	private Image backImg = backIc.getImage();
	private static JTextField textbox = new JTextField();
	private int backX = 0;
	
	public static void main(String[] args) {

		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new MyPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.add(textbox);
		textbox.setBounds(60, 50, 56, 30);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPanel window = new MyPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the application.
	 */
	public MyPanel() {
		setFocusable(true);
		new Thread(new Runnable() {
			
			public void run() {
				while (true) {
					backX--;
					repaint();
					try {
					Thread.sleep(100);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
				).start();

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backImg, backX, 0, this);
	}


}
