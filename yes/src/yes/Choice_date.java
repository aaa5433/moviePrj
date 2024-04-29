package movie;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

// 날짜 및 시간대

//시간대 버튼 클래스

class Time_Button extends JRadioButton {
	private String Time;
	private String date;
	Time_Button(String Time, String date) {
		this.Time = Time;
		this.date = date;
		setText(Time);
		setOpaque(true);
		Font font = this.getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 18));
		//선택 시간 반환
		addActionListener(e -> {
            Your_Choice.updateDate(date);
			Your_Choice.updateDateTime(Time);
			
            
        });
	}
	
	
	public String get_Times() {
		return Time;
	}
}


class date extends JLabel {
	private String date;

	public date(String date) {
		this.date = date;
		setText(date);
		setOpaque(true);
		setBounds(10, 0, 120, 100);
		// 폰트 설정
		Font font = getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 30));
		setHorizontalAlignment(CENTER);

	}

	public String getdate() {
		return date;
	}
}
// 5/2
class date1 extends JPanel {
	public date1(ButtonGroup group) {
		setBounds(0, 180, 900, 100);
		setLayout(null);

		date date = new date("5/2");
		add(date);
		// 시간 선택 버튼

		Time_Button radioButton1 = new Time_Button("9:30 ~ 11:19",date.getdate());
		Time_Button radioButton2 = new Time_Button("12:00 ~ 13:49",date.getdate());
		Time_Button radioButton3 = new Time_Button("16:00 ~ 17:49",date.getdate());
		Time_Button radioButton4 = new Time_Button("19:00 ~ 20:49",date.getdate());

		radioButton1.setOpaque(false);
		radioButton2.setOpaque(false);
		radioButton3.setOpaque(false);
		radioButton4.setOpaque(false);

		radioButton1.setBounds(150, 25, 150, 60);
		radioButton2.setBounds(350, 25, 150, 60);
		radioButton3.setBounds(550, 25, 150, 60);
		radioButton4.setBounds(750, 25, 150, 60);

		// 라디오 버튼을 그룹으로 묶기

		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);

		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		add(radioButton4);

	}
}

//5/3
class date2 extends JPanel {
	public date2(ButtonGroup group) {
		setBounds(0, 300, 900, 100);
		setLayout(null);

		date date = new date("5/3");
		add(date);

		// 시간 선택 버튼

		Time_Button radioButton1 = new Time_Button("8:30 ~ 10 : 19",date.getdate());
		Time_Button radioButton2 = new Time_Button("12:00 ~ 13 : 49",date.getdate());
		Time_Button radioButton3 = new Time_Button("18:00 ~ 19:49",date.getdate());
		Time_Button radioButton4 = new Time_Button("21:00 ~ 22:49",date.getdate());

		radioButton1.setOpaque(false);
		radioButton2.setOpaque(false);
		radioButton3.setOpaque(false);
		radioButton4.setOpaque(false);

		radioButton1.setBounds(150, 25, 150, 60);
		radioButton2.setBounds(350, 25, 200, 60);
		radioButton3.setBounds(550, 25, 200, 60);
		radioButton4.setBounds(750, 25, 150, 60);
		// 라디오 버튼을 그룹으로 묶기

		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);

		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		add(radioButton4);
	}
}

//5/4
class date3 extends JPanel {

	public date3(ButtonGroup group) {
		setBounds(0, 420, 900, 100);
		setLayout(null);

		date date = new date("5/4");
		add(date);

		// 시간 선택 버튼

		Time_Button radioButton1 = new Time_Button("12:30 ~ 14 : 19",date.getdate());
		Time_Button radioButton2 = new Time_Button("15:10 ~ 16 : 59",date.getdate());
		Time_Button radioButton3 = new Time_Button("17:00 ~ 18:49",date.getdate());
		Time_Button radioButton4 = new Time_Button("20:05 ~ 21:54",date.getdate());

		radioButton1.setBounds(150, 25, 150, 60);
		radioButton2.setBounds(350, 25, 200, 60);
		radioButton3.setBounds(550, 25, 200, 60);
		radioButton4.setBounds(750, 25, 150, 60);
		// 라디오 버튼을 그룹으로 묶기

		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);

		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		add(radioButton4);
	}
}

//5/5
class date4 extends JPanel {
	public date4(ButtonGroup group) {
		setBounds(0, 540, 900, 100);
		setLayout(null);

		date date = new date("5/5");
		add(date);
		// 시간선택버튼
		Time_Button radioButton1 = new Time_Button("07:00 ~ 08:49",date.getdate());
		Time_Button radioButton2 = new Time_Button("11:30 ~ 13:19",date.getdate());
		Time_Button radioButton3 = new Time_Button("17:20 ~ 19:09",date.getdate());
		Time_Button radioButton4 = new Time_Button("23:00 ~ 24:49",date.getdate());

		radioButton1.setOpaque(false);
		radioButton2.setOpaque(false);
		radioButton3.setOpaque(false);
		radioButton4.setOpaque(false);

		radioButton1.setBounds(150, 25, 150, 60);
		radioButton2.setBounds(350, 25, 200, 60);
		radioButton3.setBounds(550, 25, 200, 60);
		radioButton4.setBounds(750, 25, 150, 60);
		// 라디오 버튼을 그룹으로 묶기

		group.add(radioButton1);
		group.add(radioButton2);
		group.add(radioButton3);
		group.add(radioButton4);

		add(radioButton1);
		add(radioButton2);
		add(radioButton3);
		add(radioButton4);
	}
}
//예매현황 라벨
class info extends JLabel{
	public info(String info) {
		setText(info);
		Font font = this.getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 25));
	}
}
//극장, 날짜, 시간 라벨
class Choice_Label extends JLabel{
	

	public void Set_Text(String text) {
		setText(text);
		Font font = this.getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 15)); 
	}
}

//선택 극장 및 날짜와 시간 대 표시 패널
class Your_Choice extends JPanel {
    private info info;
	private static Choice_Label theaterLabel;
    private static Choice_Label dateLabel;
    private static Choice_Label TimeLabel;

    public Your_Choice() {
        setBounds(950, 180, 200, 300);
    	setLayout(null);
        setBackground(Color.white);
        setBorder(new LineBorder(Color.BLACK, 2));
        
        theaterLabel = new Choice_Label();
        dateLabel = new Choice_Label();
        TimeLabel = new Choice_Label();
        info = new info("예매현황");
        
        
        info.setBounds(48, 0, 200, 50);
        theaterLabel.setBounds(41, 50, 140, 100);
        dateLabel.setBounds(10, 80, 120, 100);
        TimeLabel.setBounds(10, 110, 180, 100);
        
        add(info);
        add(theaterLabel);
        add(dateLabel);
        add(TimeLabel);
    }

    public static void updateTheater(String theaterName) {
        theaterLabel.Set_Text("극장: " + theaterName);
    }

    public static void updateDate(String date) {
        dateLabel.Set_Text("상영일자: " + date);
    }

    public static  void updateDateTime(String dateTime) {
        TimeLabel.Set_Text("상영시간: " + dateTime);
    }
}

//극장 선택 버튼
class Thearter_Button extends JButton {
	private String Thearter_Name;

	public Thearter_Button(String Thearter) {
		Thearter_Name = Thearter;
		setText(Thearter_Name);
		
		addActionListener(e -> {
            
            Your_Choice.updateTheater(Thearter_Name);
			
            
        });
	}

	public String get_Thearter_Name() {
		return Thearter_Name;
	}
}

class Thearter extends JPanel {
	public Thearter() {
		setBounds(0, 0, 1200, 165);
		setLayout(null);

		Thearter_Button bucheon = new Thearter_Button("부천 스타필드");
		Thearter_Button incheon = new Thearter_Button("인천 논현");
		Thearter_Button chungla = new Thearter_Button("청라 지젤");
		Thearter_Button hwagok = new Thearter_Button("화곡");
		// 극장 버튼

		bucheon.setBounds(125, 30, 200, 100);
		incheon.setBounds(375, 30, 200, 100);
		chungla.setBounds(625, 30, 200, 100);
		hwagok.setBounds(875, 30, 200, 100);

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

		ButtonGroup timeGroup = new ButtonGroup();

		
		
		f.add(new Thearter());
		f.add(new date1(timeGroup));
		f.add(new date2(timeGroup));
		f.add(new date3(timeGroup));
		f.add(new date4(timeGroup));
		f.add(new Your_Choice());
		f.setVisible(true);

	}
}