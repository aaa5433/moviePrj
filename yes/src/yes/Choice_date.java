package yes.src.yes;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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