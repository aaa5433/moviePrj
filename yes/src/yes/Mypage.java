package yes.src.yes;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import java.awt.event.*;
import java.awt.*;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

class Your_ticket extends JPanel {
	public static Choice_Label movie = new Choice_Label();
	public static  Choice_Label theater= new Choice_Label();
	public static Choice_Label date = new Choice_Label();
	public static Choice_Label time = new Choice_Label();
	public static Choice_Label seat = new Choice_Label();
	
	public Your_ticket() {
		setLayout(null);
		setBackground(Color.white);
		setBorder(new LineBorder(Color.BLACK, 2));
		setBounds(450, 200, 300, 500);

		 
		
		movie.setBounds(41, 20, 300, 100);
		theater.setBounds(41, 50, 140, 100);
		date.setBounds(10, 80, 120, 100);
		time.setBounds(10, 110, 180, 100);
		seat.setBounds(10, 140, 120, 100);
		
		add(movie);
		
		add(theater);
		add(date);
		add(time);
		add(seat);

	}
}

public class Mypage extends JFrame {
	JFrame frame1 = this;

	public Mypage() {

		setTitle("마이 페이지");
		setBounds(350, 150, 1200, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		getContentPane().setLayout(null);

		// Back button
		JPanel Your_Book_Panel = new JPanel();
		Your_Book_Panel.setBounds(0, 0, 1200, 150);
		Your_Book_Panel.setLayout(null);
		Your_Book_Panel.setBackground(Color.white);

		JLabel Your_Book = new JLabel("예매 현황");
		Your_Book.setBounds(500, 0, 300, 150);
		Font font = new Font("Malgun Gothic", Font.BOLD, 30);
		Your_Book.setFont(font);
		Your_Book_Panel.add(Your_Book);

		JButton backButton = new JButton("홈");
		backButton.setBounds(1, 580, 100, 30);

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Homedemo frame2 = new Homedemo();
				frame1.dispose();
				frame2.setVisible(true);

			}
		});

		getContentPane().add(backButton, BorderLayout.CENTER);
		add(Your_Book_Panel);
		add(new Your_ticket());
		setVisible(true);
	}

}