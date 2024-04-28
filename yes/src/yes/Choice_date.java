package yes.src.yes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
// 날짜 및 시간대

// 5/2
class date extends JLabel{
	private String date;
	public date(String date) {
		this.date = date;
		setText(date);
		setOpaque(true);
		setBackground(Color.white);
		setBounds(10, 0, 120, 100);
		//폰트 설정
		Font font = getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 20));
		setHorizontalAlignment(CENTER);
		
		
	}
	
	public String getdate() {
		return date;
	}
}

class date1 extends JPanel{
	public date1() {
		setBounds(0, 180, 1200, 100);
		setBackground(Color.red);
		setLayout(null);
		
		date date = new date("5/2");
		add(date);
		//시간 선택 버튼
		
		JRadioButton radioButton1 = new JRadioButton();
		JRadioButton radioButton2 = new JRadioButton();
		JRadioButton radioButton3 = new JRadioButton();
		
		radioButton1.setOpaque(false);
		radioButton2.setOpaque(false);
		radioButton3.setOpaque(false);
		
		radioButton1.setBounds(150, 25, 150, 60);
		radioButton1.setText("9:30 ~ \n11 : 19");
		Font font1 = radioButton1.getFont();
		radioButton1.setFont(new Font(font1.getFontName(), Font.BOLD,18));
		radioButton2.setBounds(300, 25, 200, 60);
		radioButton2.setText("12:00 ~ 13 : 49");
		Font font2 = radioButton2.getFont();
		radioButton2.setFont(new Font(font2.getFontName(), Font.BOLD,18));
		radioButton3.setBounds(450, 25, 200, 60);
		radioButton3.setText("16:00 ~ 17:49");
		Font font3 = radioButton3.getFont();
		radioButton3.setFont(new Font(font3.getFontName(), Font.BOLD,18));
		// 라디오 버튼을 그룹으로 묶기
		ButtonGroup group = new ButtonGroup();
		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		
		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		System.out.println(date.getdate());
	}
}


//5/3
class date2 extends JPanel{
	public date2() {
		setBounds(0, 300, 1200, 100);
		setBackground(Color.red);
		setLayout(null);
		
		
		date date = new date("5/3");
		add(date);
		
		//시간 선택 버튼
		
				JRadioButton radioButton1 = new JRadioButton();
				JRadioButton radioButton2 = new JRadioButton();
				JRadioButton radioButton3 = new JRadioButton();
				
				radioButton1.setOpaque(false);
				radioButton2.setOpaque(false);
				radioButton3.setOpaque(false);
				
				radioButton1.setBounds(150, 25, 150, 60);
				radioButton1.setText("8:30 ~ 10 : 19");
				Font font1 = radioButton1.getFont();
				radioButton1.setFont(new Font(font1.getFontName(), Font.BOLD,18));
				radioButton2.setBounds(300, 25, 200, 60);
				radioButton2.setText("12:00 ~ 13 : 49");
				Font font2 = radioButton2.getFont();
				radioButton2.setFont(new Font(font2.getFontName(), Font.BOLD,18));
				radioButton3.setBounds(450, 25, 200, 60);
				radioButton3.setText("18:00 ~ 19:49");
				Font font3 = radioButton3.getFont();
				radioButton3.setFont(new Font(font3.getFontName(), Font.BOLD,18));
				// 라디오 버튼을 그룹으로 묶기
				ButtonGroup group = new ButtonGroup();
				group.add(radioButton1);
				group.add(radioButton2);
				group.add(radioButton3);
				
				add(radioButton1);
				add(radioButton2);
				add(radioButton3);
	}
}

//5/4
class date3 extends JPanel{
	public date3() {
		setBounds(0, 420, 1200, 100);
		setBackground(Color.red);
		setLayout(null);
		
		
		date date = new date("5/4");
		add(date);
	}
}

//5/5
class date4 extends JPanel{
	public date4() {
		setBounds(0, 540, 1200, 100);
		setBackground(Color.red);
		setLayout(null);
		
		
		date date = new date("5/5");
		add(date);
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
		
		
		
		
	}
}






public class Choice_date {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		
		f.setBounds(350, 150, 1200, 800);
		
		
		f.add(new Thearter());
		f.add(new date1());
		f.add(new date2());
		f.add(new date3());
		f.add(new date4());
		f.setVisible(true);
		
	}
}