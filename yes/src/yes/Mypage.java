package yes.src.yes;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import java.awt.event.*;
import java.awt.*;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class Mypage extends JFrame {
	private JFrame previousFrame;

	public Mypage(JFrame previousFrame) {
		this.previousFrame = previousFrame;

		setTitle("마이 페이지");
		setSize(1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setLayout(null);

		// Back button
		JButton btn1 = new JButton("영화현황");
		JButton btn2 = new JButton("예매영화");
		JButton backButton = new JButton("뒤로");
		btn1.setBounds(1, 10, 1200, 100);
		btn2.setBounds(1, 170, 122, 30);
		backButton.setBounds(1, 580, 100, 30);
		
		getContentPane().add(btn1);
		getContentPane().add(btn2);
		run();
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Close the current frame
				dispose();
				// Show the previous frame
				previousFrame.setVisible(true);
			}
		});
		
		getContentPane().add(backButton, BorderLayout.CENTER);
	}
	
	public void run() {
		// First Frame
		JFrame firstFrame = new JFrame("영화 예매 시스템");
		firstFrame.setSize(1200, 800);
		firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstFrame.setLayout(new FlowLayout());
		firstFrame.setLayout(null);

		// Button to open the second frame
		JButton nextButton = new JButton("마이 페이지 ");
		nextButton.setBounds(1000, 1, 200, 100);

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Close the current frame
				firstFrame.setVisible(false);
				// Open the second frame
				JFrame secondFrame = new Mypage(firstFrame);
				secondFrame.setVisible(true);
			}
		});

		firstFrame.getContentPane().add(nextButton, BorderLayout.CENTER);
		firstFrame.setVisible(true);
	}
}
