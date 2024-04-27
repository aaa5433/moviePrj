package yes.src.yes;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
// 날짜 및 시간대


class date1 extends JLabel{
	
	public date1() {
		setBounds(0, 0, 100, 100);
		setBackground(Color.white);
		
	}
}

class date extends JPanel{
	public date() {
		setBounds(0, 180, 1200, 100);
		setBackground(Color.red);
		setLayout(null);
	}
}


class Thearter extends JPanel{
	public Thearter() {
		setBounds(0, 0, 1200, 165);
		setBackground(Color.black);
		setLayout(null);
		
		
		JButton bucheon = new JButton("부천 스타필드");
		JButton incheon = new JButton("인천 논현");
		JButton chungla = new JButton("청라 지젤");
		JButton hwagok = new JButton("화곡");
		//극장 버튼 
		bucheon.setBounds(125, 30, 200, 100);
		incheon.setBounds(375, 30, 200, 100);
		chungla.setBounds(625, 30, 200, 100);
		hwagok.setBounds(875, 30, 200, 100);
		
		bucheon.setBackground(Color.yellow);
		incheon.setBackground(Color.white);
		chungla.setBackground(Color.green);
		hwagok.setBackground(Color.blue);
		
		
		add(bucheon);
		add(incheon);
		add(chungla);
		add(hwagok);
		
		add(new date1());
		
		
	}
}






public class Choice_date {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		
		f.setBounds(350, 150, 1200, 800);
		
		
		f.add(new Thearter());
		f.add(new date());
		f.setVisible(true);
		
	}
}