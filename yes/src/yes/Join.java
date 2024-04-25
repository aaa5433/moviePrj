package yes.src.yes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import yes.src.dao.UserDao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.io.IOException;
import java.net.IDN;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Join extends JFrame implements KeyListener {
	GraphicsDevice scrSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	static String nowTime;
	static String nowTime1;
	static int loop;
	static int x;
	static int y;
	static int width;
	static int height;
	static JLabel idNumLabel = new JLabel("주민번호");
	static JTextField idNumInputTextBox = new JTextField();
	static JTextField idNumInputTextBox1 = new JTextField();
	static JLabel idNumLength = new JLabel("●●●●●●");
	static JFrame joinFrame = new JFrame();
	static JLabel idLabel = new JLabel("ID");
	static JLabel passLabel = new JLabel("비밀번호");
	static JLabel nameLabel = new JLabel("이름");
	static JLabel dash = new JLabel("-");
	static JLabel dash1 = new JLabel("-");
	static JLabel dash2 = new JLabel("-");
	static JLabel mailLabel = new JLabel("메일");
	static JLabel at = new JLabel("@");
	static JLabel PhoneLabel = new JLabel("폰번호");
	static JButton duplCheck = new JButton("중복체크");
	static JLabel ahn = new JLabel("");
	static JPasswordField passInputTextBox = new JPasswordField();
	static JTextField nameInputTextBox = new JTextField();
	static JTextField mailInputTextBox = new JTextField();
	static JPanel panel = new JPanel(); // 프레임에서 컨텐트팬 받아오기
	static JButton JoinCancel = new JButton("취소");
	static JTextField mailInputTextBox1 = new JTextField();
	static JTextField idInputTextBox = new JTextField();
	static JLayeredPane layeredPane = new JLayeredPane();

	static JTextField phoneInputTextBox = new JTextField();
	static JTextField phoneInputTextBox1 = new JTextField();
	static JTextField phoneInputTextBox2 = new JTextField();
	static JButton JoinOK = new JButton("가입");
	static int duplCheckCnt = 0;
	static HashMap<String, String> list = new HashMap<>();
	private static JLabel background = new JLabel(new ImageIcon("img\\joinBackground.jpg"));
	private static JLabel closeBtn = new JLabel(new ImageIcon("img\\close.jpg"));

	public static JFrame getFrame() {
		return joinFrame;
	}
	public Join() {
		String time = timeCheck();
		System.out.println(time);
		textBoxNull();
		main();
	}
	
	private String timeCheck() {
		LocalTime now = LocalTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formatedTime = now.format(formatter);
		return formatedTime;
	}
	
	public void main() {
		addComponentsToLayeredPane();
		joinFrame.removeNotify();
		joinFrame.setUndecorated(true);
		joinFrame.addNotify();
		
		joinFrame.setTitle("MegaBox 회원가입"); // 프레임 제목 설정
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joinFrame.setSize(500, 300); // 프레임 크기 설정
		joinFrame.setLocationRelativeTo(null);
		joinFrame.setResizable(false);
		ahn.setBounds(200, 70, 90, 30);
		
		
		background.setBounds(0, 0, 500, 300);
		layeredPane.setPreferredSize(new Dimension(500, 300));

		joinFrame.getContentPane().add(panel);
//		joinFrame.getContentPane().add(background);

		idLabel.setBounds(20, 40, 124, 30); // id
		passLabel.setBounds(20, 70, 124, 30); // pass
		nameLabel.setBounds(20, 100, 124, 30); // 이름
		idNumLabel.setBounds(20, 130, 124, 30); //
		idNumLength.setBounds(220, 130, 100, 30); // ●
		dash.setBounds(187, 130, 100, 30);
		mailLabel.setBounds(20, 160, 124, 30);
		at.setBounds(184, 160, 100, 30);
		PhoneLabel.setBounds(20, 190, 124, 30);
		// ID
		idInputTextBox.setBounds(80, 40, 100, 30);
		duplCheck.setBounds(200, 40, 90, 30);
		// PASS
		passInputTextBox.setBounds(80, 70, 100, 30);
		nameInputTextBox.setBounds(80, 100, 100, 30);
		idNumInputTextBox.setBounds(80, 130, 100, 30);
		idNumInputTextBox1.setBounds(200, 130, 20, 30);
		mailInputTextBox.setBounds(80, 160, 100, 30);
		mailInputTextBox.setColumns(10);
		mailInputTextBox1.setBounds(200, 160, 100, 30);
		mailInputTextBox1.setColumns(10);
		phoneInputTextBox.setBounds(80, 190, 50, 30);
		phoneInputTextBox1.setBounds(145, 190, 60, 30);
		phoneInputTextBox2.setBounds(220, 190, 60, 30);
		
		dash1.setBounds(135, 190, 80, 30);
		dash2.setBounds(210, 190, 50, 30);
		closeBtn.setBounds(470, 0, 30, 30);
		
		Color color = new Color(70, 70, 80);
		Color join = new Color(75, 70, 170);

		JoinOK.setBounds(80, 250, 70, 30); //+20
		JoinCancel.setBounds(160, 250, 70, 30);
		
		JoinOK.setBorderPainted(false);
		JoinOK.setForeground(Color.white);
		JoinOK.setBackground(join);

		JoinCancel.setBorderPainted(false);
		JoinCancel.setForeground(Color.white);
		JoinCancel.setBackground(color);
		
		duplCheck.setBorderPainted(false);
		duplCheck.setForeground(Color.white);
		duplCheck.setBackground(color);
		
		
//******
		joinFrame.add(layeredPane);
		joinFrame.setVisible(true);
		joinFrame.getContentPane().add(background);
		
		idInputTextBox.addKeyListener(this);
		passInputTextBox.addKeyListener(this);
		nameInputTextBox.addKeyListener(this);
		idNumInputTextBox.addKeyListener(this);
		idNumInputTextBox1.addKeyListener(this);
		mailInputTextBox.addKeyListener(this);
		mailInputTextBox1.addKeyListener(this);
		phoneInputTextBox.addKeyListener(this);
		phoneInputTextBox1.addKeyListener(this);
		phoneInputTextBox2.addKeyListener(this);
		
		
		
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt=0;
				joinFrame.setVisible(false);
				Login.getFrame().setVisible(true);
			}
		});
		duplCheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt++;
				if (idInputTextBox.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}else if(!Pattern.matches("^((?=.*\\d)|(?=.*\\w)).{5,15}+$", idInputTextBox.getText().toString())) {
					JOptionPane.showMessageDialog(null, "ID 길이는 5-15자리 사이입니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idInputTextBox.setText("");
				}else if (Pattern.matches("^[0-9]*$", idInputTextBox.getText().substring(0,1)))  {
					JOptionPane.showMessageDialog(null, "ID 첫번째 문자는 숫자로 시작할 수 없습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idInputTextBox.setText("");
				}else {
					duplCheckCnt=0;
					duplCheck(UserDao.duplCheck(idInputTextBox.getText().toString()));
				}
			}
		});

		JoinOK.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = idInputTextBox.getText();
				String pw = passInputTextBox.getText();
				String name = nameInputTextBox.getText();
				String idNum = idNumInputTextBox.getText();
				String mail = mailInputTextBox.getText() + "@" + mailInputTextBox1.getText();
				String gender;
				if(idNumInputTextBox1.getText().toString() == "")
					gender = "1";
				else {
					gender = idNumInputTextBox1.getText();
				}
				
				String phone = phoneInputTextBox.getText()+phoneInputTextBox1.getText()+phoneInputTextBox2.getText();
				
				if(!(mailFormatCheck(mailInputTextBox1.getText()))) {
					JOptionPane.showMessageDialog(null, "맞지 않는 이메일 형식입니다.\n예) ID@nate.com", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					mailInputTextBox.setText(""); mailInputTextBox1.setText("");
				}else if ((id.isEmpty() || pw.isEmpty() || name.isEmpty() || idNum.isEmpty() || idNum.isEmpty() || mailInputTextBox.getText().isEmpty() || mailInputTextBox1.getText().isEmpty() || phone.isEmpty()))
					JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				else if (duplCheckCnt == 0) {
					JOptionPane.showMessageDialog(null, "ID중복체크를 해주세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
				else if ((idNum.length() != 6 || idNumInputTextBox1.getText().length() != 1 || Integer.parseInt(idNumInputTextBox1.getText()) > 2 || Integer.parseInt(idNumInputTextBox1.getText()) == 0 )) {
					JOptionPane.showMessageDialog(null, "올바른 주민번호가 아닙니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idNumInputTextBox.setText("");
					idNumInputTextBox1.setText("");
				}else if ((Pattern.matches("^[0-9]*$", idInputTextBox.getText().substring(0,1).toString())))  {
					JOptionPane.showMessageDialog(null, "ID 첫번째 문자는 숫자로 시작할 수 없습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idInputTextBox.setText("");
				}else if(!Pattern.matches("^((?=.*\\d)|(?=.*\\w)).{5,15}+$", idInputTextBox.getText().toString())) {
					JOptionPane.showMessageDialog(null, "ID 길이는 5~15자리 사이입니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idNumInputTextBox.setText("");
				}else if(!Pattern.matches("^((?=.*\\d)|(?=.*\\w)).{4,20}+$", passInputTextBox.getText().toString())) {
					JOptionPane.showMessageDialog(null, "비밀번호는 4~20자 사이입니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					passInputTextBox.setText("");
				}
				else {
					try {
						//메일형식체크
						int i = duplCheck(UserDao.duplCheck(idInputTextBox.getText().toString()));
						if(i == 0){
							idInputTextBox.setText(""); //존재하는 ID
						}else {
							list.put("id", id);
							list.put("pw", pw);
							list.put("name", name);
							list.put("idNum", idNum);
							list.put("mail", mail);
							list.put("gender", gender);
							list.put("phone", phone);
							setData(list);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

			public void setData(HashMap<String,String> list) throws SQLException {
				if(!list.get("id").equals("")) {
					UserDao.insertUser(list);
					JOptionPane.showMessageDialog(null, list.get("id")+"님 가입 완료", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
				nowTime = timeCheck();
				loop++;
				duplCheckCnt = 0;
				joinFrame.setVisible(false);
				Login.getFrame().setVisible(true);
				ahn.setText("");
			}
		});

		JoinCancel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt=0;
				joinFrame.setVisible(false);
				Login.getFrame().setVisible(true);
			}
		});

	}// join class
	private void addComponentsToLayeredPane() { //우선순위
		layeredPane.add(background, Integer.valueOf(0));
		layeredPane.add(idNumLabel, Integer.valueOf(1));
		layeredPane.add(idNumInputTextBox1, Integer.valueOf(2));
		layeredPane.add(idNumLength, Integer.valueOf(3));
		layeredPane.add(idLabel, Integer.valueOf(5));
		layeredPane.add(passLabel, Integer.valueOf(6));
		layeredPane.add(nameLabel, Integer.valueOf(7));
		layeredPane.add(dash, Integer.valueOf(8));
		layeredPane.add(mailLabel, Integer.valueOf(9));
		layeredPane.add(at, Integer.valueOf(10));
		layeredPane.add(PhoneLabel, Integer.valueOf(11));
		layeredPane.add(duplCheck, Integer.valueOf(12));
		layeredPane.add(passInputTextBox, Integer.valueOf(13));
		layeredPane.add(nameInputTextBox, Integer.valueOf(14));
		layeredPane.add(mailInputTextBox, Integer.valueOf(15));
		layeredPane.add(panel, Integer.valueOf(16));
		layeredPane.add(JoinOK, Integer.valueOf(17));
		layeredPane.add(JoinCancel, Integer.valueOf(17));
		layeredPane.add(mailInputTextBox1, Integer.valueOf(18));
		layeredPane.add(idInputTextBox, Integer.valueOf(19));
		layeredPane.add(closeBtn, Integer.valueOf(20));
		layeredPane.add(idNumInputTextBox, Integer.valueOf(21));
		layeredPane.add(phoneInputTextBox, Integer.valueOf(22));
		layeredPane.add(phoneInputTextBox1, Integer.valueOf(23));
		layeredPane.add(phoneInputTextBox2, Integer.valueOf(24));
		layeredPane.add(dash1, Integer.valueOf(25));
		layeredPane.add(dash2, Integer.valueOf(26));
		layeredPane.add(ahn, Integer.valueOf(27));
	}
	
	// 주민등록번호 길이 체크
	public static void textBoxNull () {
		list.clear();
		idNumInputTextBox.setText("");
		idNumInputTextBox1.setText("");
		passInputTextBox.setText("");
		nameInputTextBox.setText("");
		mailInputTextBox.setText("");
		mailInputTextBox1.setText("");
		idInputTextBox.setText("");
		phoneInputTextBox.setText("");
		phoneInputTextBox1.setText("");
		phoneInputTextBox2.setText("");
	}

	// ID중복체크
	public int duplCheck(int code) {
		duplCheckCnt++;
		if (code == 0) {
			JOptionPane.showMessageDialog(null, idInputTextBox.getText() + "는 존재하는 아이디입니다.", "경고 메시지",
					JOptionPane.WARNING_MESSAGE);
			return 0;
		}
		else {
			JOptionPane.showMessageDialog(null, idInputTextBox.getText() + "는사용 가능한 ID입니다.", "경고 메시지",
					JOptionPane.WARNING_MESSAGE);
			return 1;
		}
		
	}
	
	public boolean mailFormatCheck(String i) {
		if(duplCheckCnt == 0 && !Pattern.matches("^[0-9a-zA-Z]+\\.[a-z]+$",i))
			return true;
		else if(Pattern.matches("^[0-9a-zA-Z]+\\.[a-z]+$",i)) {
			return true;
		}
		else
			return false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	// 주민등록번호 문자 체크
	public void keyPressed(KeyEvent e) {
		String keychar = String.valueOf(e.getKeyChar()).toString();
		Color color = new Color(255, 200, 0);
		String passInt = "^((?=.*\\d)|(?=.*\\w))";
		list.put("id", idInputTextBox.getText());
		
		//길이 체크
		if(Pattern.matches(passInt+".{11,20}+$", passInputTextBox.getText().toString())){
			ahn.setForeground(Color.green);
			ahn.setText("안전");
		}else if(Pattern.matches(passInt+".{6,10}+$", passInputTextBox.getText().toString())){
			ahn.setForeground(color);
			ahn.setText("보통");
		}else if(Pattern.matches(passInt+".{1,5}+$", passInputTextBox.getText().toString())) {
			ahn.setForeground(Color.red);
			ahn.setText("위험");
		}else {
			ahn.setForeground(Color.red);
			ahn.setText("");
		}
		
		if(idInputTextBox.getText().length() > 10) {
			JOptionPane.showMessageDialog(null, "ID는 15자리를 넘을 수 없습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			idInputTextBox.setText("");
		} else if(!Pattern.matches("^[a-z1-9]*$", idInputTextBox.getText().toString())) {
			JOptionPane.showMessageDialog(null, "ID는 소문자와 숫자로만 이루어져야 합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			idInputTextBox.setText("");
		}else if(nameInputTextBox.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "이름은 20자리를 넘을 수 없습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			nameInputTextBox.setText("");
		}else if(!Pattern.matches("^[0-9]*$", idNumInputTextBox.getText().toString()) || !Pattern.matches("^[0-9]*$", idNumInputTextBox1.getText().toString()) || idNumInputTextBox.getText().length() > 6 || idNumInputTextBox1.getText().length() > 1) {
			JOptionPane.showMessageDialog(null, "주민번호를 정확히 입력하세요.\n예) 생년월일020101", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			idNumInputTextBox.setText("");
			idNumInputTextBox1.setText("");
		}else if(mailInputTextBox.getText().length() > 10 || mailInputTextBox1.getText().length() > 20) {
			JOptionPane.showMessageDialog(null, "이메일 주소가 너무 깁니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			mailInputTextBox.setText(""); mailInputTextBox1.setText("");
		}else if(!Pattern.matches("^[0-9]*$", phoneInputTextBox.getText().toString()) || !Pattern.matches("^[0-9]*$", phoneInputTextBox1.getText().toString()) || !Pattern.matches("^[0-9]*$", phoneInputTextBox2.getText().toString())) {
			JOptionPane.showMessageDialog(null, "숫자만 입력 가능합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			phoneInputTextBox.setText(""); phoneInputTextBox1.setText(""); phoneInputTextBox2.setText("");
		}else if(phoneInputTextBox.getText().length() > 3 || phoneInputTextBox1.getText().length() > 4 || phoneInputTextBox2.getText().length() > 4) {
			JOptionPane.showMessageDialog(null, "휴대폰 번호를 다시 확인해주세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			phoneInputTextBox.setText(""); phoneInputTextBox1.setText(""); phoneInputTextBox2.setText("");
		}
//		else if() {
//			JOptionPane.showMessageDialog(null, "패스워드는 7~20자리 사이여야 합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
//			passInputTextBox.setText("");
//		}//;
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}