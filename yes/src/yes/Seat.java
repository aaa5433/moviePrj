package yes.src.yes;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

class PersonPanel extends JPanel {
    private JLabel personCountLabel;
    private static int totalPersonCount = 0;
    static int checked = 0;
    static String tickets = "";

    public PersonPanel() {
        setLayout(new FlowLayout());
        setBounds(80, 0, 120, 50);
        JButton decreaseButton = new JButton("-");
        Font font = new Font("Malgun Gothic", Font.BOLD, 20);
        decreaseButton.setFont(font);
        personCountLabel = new JLabel("0");
        Font font1 = new Font("Malgun Gothic", Font.BOLD, 20);
        personCountLabel.setFont(font);
        JButton increaseButton = new JButton("+");
        Font font2 = new Font("Malgun Gothic", Font.BOLD, 20);
        increaseButton.setFont(font);

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalPersonCount > 0) {
                    totalPersonCount--;
                    updatePersonCount();
                    total_panel.update();
                }
            }
        });

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (totalPersonCount < 5) {
                    totalPersonCount++;
                    updatePersonCount();
                    total_panel.update();
                }
            }
        });

        add(decreaseButton);
        add(personCountLabel);
        add(increaseButton);
    }

    private void updatePersonCount() {
        personCountLabel.setText(Integer.toString(totalPersonCount));
    }

    public static int get_Person() {
        return totalPersonCount;
    }

}

class Adult_Panel extends JPanel {
    static PersonPanel Adult_count;

    public Adult_Panel() {
        setLayout(null);

        setBounds(40, 625, 200, 50);

        JLabel Adult = new JLabel("인원");
        Adult.setBounds(10, 0, 50, 50);
        Font font = new Font("Malgun Gothic", Font.BOLD, 20);
        Adult.setFont(font);
        add(Adult);

        Adult_count = new PersonPanel();
        add(Adult_count);
    }

    public static int get_Person() {
        return Adult_count.get_Person();
    }
}

class total_panel extends JPanel {
    static JLabel total;

    public total_panel() {
        setBounds(250, 600, 300, 80);
        setLayout(null);
        setBackground(Color.white);
        JLabel amount = new JLabel();
        amount.setText("금액: ");
        amount.setBounds(20, 15, 100, 50);
        Font amount_Font = new Font("Malgun Gothic", Font.BOLD, 25);
        amount.setFont(amount_Font);
        total = new JLabel();
        total.setBounds(100, 15, 100, 50);
        Font font = new Font("Malgun Gothic", Font.BOLD, 25);
        total.setFont(font);

        update(); // 초기화 시에도 한번 업데이트 호출

        add(amount);
        add(total);
    }

    public static void update() {
        total.setText(Integer.toString(Seat.Adult_ticket * Adult_Panel.get_Person()));
    }
}
class Seat_Button extends JButton{
	public Seat_Button(String seat) {
		setText(seat);
	}
}
class Seat_Panel extends JPanel{
	public Seat_Panel() {
		setLayout(null);
		setBounds(130, 30, 950, 400);
		setBackground(Color.white);
		
		JLabel title = new JLabel("좌석 선택");
		title.setBounds(160, 20, 200, 60);
		Font font = new Font("Malgun Gothic",Font.BOLD,30);
		title.setFont(font);

		int abccnt = 0;
		int cnt = 0;
		int seatNum = 0;
		int seatcnt = Integer.parseInt(String.valueOf(150));
		final JCheckBox[] seats = new JCheckBox[seatcnt];
		int x = (int) Math.ceil(seatcnt / 20.0);
		int y = (int) Math.ceil(seatcnt / Math.ceil(seatcnt / 20.0));
		JPanel panel = new JPanel(new GridLayout(x, y));
		String[] abc = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };
		for (int i = 0; i < seats.length; i++) {
			if (cnt % y == 0 && i != 0) {
				abccnt++;
				seatNum = 1;
				seats[i] = new JCheckBox(abc[abccnt] + String.valueOf(seatNum));
				panel.add(seats[i]);
			} else {
				String check = abc[abccnt];
				seats[i] = new JCheckBox(abc[abccnt] + String.valueOf(seatNum));
				if (check.equals("A")) {
					seats[i] = new JCheckBox(abc[abccnt] + String.valueOf(seatNum + 1));
					panel.add(seats[i]);
				}
				panel.add(seats[i]);
				seats[i].addItemListener(new ItemListener() {
					@Override
					public void itemStateChanged(ItemEvent e) {
						int end = 0;
						end = e.paramString().indexOf("],stateChange");
						String a = e.paramString().charAt(end-3) +""+ e.paramString().charAt(end-2) + e.paramString().charAt(end-1)+"/";
						a = a.replaceAll("=", "");
						
						if(e.getStateChange() == 1) {
							PersonPanel.checked++;
							if(PersonPanel.checked > 5) {
				  				JOptionPane.showMessageDialog(null, "티켓은 5명까지만 선택 가능합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
							}
							PersonPanel.tickets = PersonPanel.tickets += a;
							System.out.println(PersonPanel.tickets);
						}else {
							PersonPanel.checked--;
							PersonPanel.tickets = PersonPanel.tickets.replaceAll(a, "");
							System.out.println(PersonPanel.tickets);
						}
						
						Your_Choice1.updateSeat1(PersonPanel.tickets);

					}
				});
			}
			cnt++;
			seatNum++;
			seats[i].setBorderPainted(false);
		}
		add(panel);
//        getContentPane().setLayout(null);
//        setLocation(null);
//		repaint();
		
		setLayout(new FlowLayout());
//		getFrame().setVisible(true);
	}
}

//극장, 날짜, 시간 라벨
class Count {
	public static String Count(String text) {
		return text;
	}
}

//극장, 날짜, 시간 라벨
class Seat_Label extends JLabel {
	public void Set_Text(String text) {
		setText(text);
		Font font = this.getFont();
		setFont(new Font(font.getFontName(), Font.BOLD, 15));
	}
}

//좌석표시
class Your_Choice1 extends JPanel {
	   private info info;
	   
	   private static Seat_Label a1;

	   public Your_Choice1() {
	      setBounds(950, 450, 200, 300);
	      setLayout(null);
	      setBackground(Color.white);
	      setBorder(new LineBorder(Color.BLACK, 2));

	      a1 = new Seat_Label();
	      
	      
	      info = new info("선택한 좌석");

	      info.setBounds(25, 0, 200, 50);
	      
	      
	      a1.setBounds(10, 80, 120, 200);
	      
	      
	      add(info);
	      add(a1);
	   }
	 

	   public static void updateSeat1(String seat) {
	      a1.Set_Text(seat);
	      Your_ticket.seat.Set_Text("좌석: "+seat);
	   }
	   
	   public static String get_seat() {
		   return a1.getText();
	   }

	  
	}


public class Seat extends JFrame {
    public static int Adult_ticket = 15000;
    JFrame frame = this;
    public Seat() {
        setLayout(null);
//이전으로 가기
        JButton previous = new JButton("이전");
        previous.setBounds(20, 50, 100, 50);
        previous.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
              Choice_date frame1 = new Choice_date();
              frame.dispose(); // 현재 프레임 종료
           }
        });
        
        // 결제창 넘어가기
        JButton payment = new JButton("결제하기");
        payment.setBounds(600, 625, 200, 50);
        payment.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	  if(Adult_Panel.get_Person() != PersonPanel.checked) {
  				JOptionPane.showMessageDialog(null, "인원과 티켓 장수가 맞지 않습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
        	  }else {
              Payment frame1 = new Payment();
              frame.dispose();
        	  }
           }
        });
        
        
        add(payment);
        add(previous);
        add(new Adult_Panel());
        add(new Seat_Panel());
        add(new Your_Choice1());
        add(new total_panel());

        setBounds(350, 150, 1200, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Seat();
    }
}
