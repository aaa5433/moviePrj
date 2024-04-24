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
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Join extends JFrame implements KeyListener {
	GraphicsDevice scrSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int width = scrSize.getDisplayMode().getWidth();
	int height = scrSize.getDisplayMode().getHeight();
	static JLabel idNumLabel = new JLabel("주민번호");
	static JTextField idNumInputTextBox = new JTextField();
	static JTextField idNumInputTextBox1 = new JTextField();
	static JLabel idNumLength = new JLabel("●●●●●●");
	static JFrame joinFrame = new JFrame();
	static JLabel idLabel = new JLabel("ID");
	static JLabel passLabel = new JLabel("비밀번호");
	static JLabel nameLabel = new JLabel("이름");
	static JLabel dash = new JLabel("-");
	static JLabel mailLabel = new JLabel("메일");
	static JLabel at = new JLabel("@");
	static JLabel PhoneLabel = new JLabel("폰번호");
	static JButton duplCheck = new JButton("중복체크");
	static JPasswordField passInputTextBox = new JPasswordField();
	static JTextField nameInputTextBox = new JTextField();
	static JTextField mailInputTextBox = new JTextField();
	static JPanel panel = new JPanel(); // 프레임에서 컨텐트팬 받아오기
	static JButton JoinCancel = new JButton("취소");
	static JTextField mailInputTextBox1 = new JTextField();
	static JTextField idInputTextBox = new JTextField();
	static JLayeredPane layeredPane = new JLayeredPane();

	static JTextField phoneInputTextBox = new JTextField();
	static JButton JoinOK = new JButton("가입");

	static int duplCheckCnt = 0;
	static HashMap<String, String> list = new HashMap<>();
	private static JLabel background = new JLabel(
			new ImageIcon("C:\\source\\moviePrj\\yes\\src\\img\\megaboxLogo.jpg"));
	public static JFrame getFrame() {
		return joinFrame;
	}

	public Join() {
		joinFrame.setTitle("MegaBox 회원가입"); // 프레임 제목 설정
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joinFrame.setSize(500, 300); // 프레임 크기 설정
		joinFrame.setLocationRelativeTo(null);
		joinFrame.setResizable(false);
		
		background.setBounds(0, 0, 500, 300);
		layeredPane.setPreferredSize(new Dimension(500, 300));

		joinFrame.getContentPane().add(panel);
//		joinFrame.getContentPane().add(background);

		idLabel.setBounds(20, 20, 124, 30); // id
		passLabel.setBounds(20, 50, 124, 30); // pass
		nameLabel.setBounds(20, 80, 124, 30); // 이름
		idNumLabel.setBounds(20, 110, 124, 30); //
		idNumLength.setBounds(220, 110, 100, 30); // ●
		dash.setBounds(187, 110, 100, 30);
		mailLabel.setBounds(20, 140, 124, 30);
		at.setBounds(184, 140, 100, 30);
		PhoneLabel.setBounds(20, 170, 124, 30);
		// ID
		idInputTextBox.setBounds(80, 20, 100, 30);
		duplCheck.setBounds(200, 20, 90, 30);
		// PASS
		passInputTextBox.setBounds(80, 50, 100, 30);
		nameInputTextBox.setBounds(80, 80, 100, 30);
		idNumInputTextBox.setBounds(80, 110, 100, 30);
		idNumInputTextBox.setColumns(10);
		idNumInputTextBox.addKeyListener(this);
		idNumInputTextBox1.setBounds(200, 110, 20, 30);
		idNumInputTextBox1.addKeyListener(this);
		mailInputTextBox.setBounds(80, 140, 100, 30);
		mailInputTextBox.setColumns(10);
		mailInputTextBox1.setBounds(200, 140, 100, 30);
		mailInputTextBox1.setColumns(10);
		phoneInputTextBox.setBounds(80, 170, 100, 30);
		JoinOK.setBounds(20, 230, 90, 30);
		JoinCancel.setBounds(120, 230, 90, 30);
		

		addComponentsToLayeredPane();
		
		joinFrame.add(layeredPane);
		joinFrame.setVisible(true);
		joinFrame.getContentPane().add(background);


		duplCheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (idInputTextBox.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				else {
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
				if(idNumInputTextBox1.getText().toString().substring(0, 1) == "")
					gender = "1";
				else
					gender = idNumInputTextBox1.getText().toString().substring(0, 1);
				String phone = phoneInputTextBox.getText();
				if (id.isEmpty() || pw.isEmpty() || name.isEmpty() || idNum.isEmpty() || idNum.isEmpty() || mailInputTextBox.getText().isEmpty() || mailInputTextBox1.getText().isEmpty() || phone.isEmpty())
					JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				else if (duplCheckCnt > 0) {
					JOptionPane.showMessageDialog(null, "ID중복체크를 해야 합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
				else if (idNum.length() != 6 || idNumInputTextBox1.getText().length() != 1 || Integer.parseInt(idNumInputTextBox1.getText()) > 2 || Integer.parseInt(idNumInputTextBox1.getText()) == 0 ) {
					JOptionPane.showMessageDialog(null, "올바른 주민번호가 아닙니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
					idNumInputTextBox.setText("");
					idNumInputTextBox1.setText("");
				}else {
					try {
						//
						int i = duplCheck(UserDao.duplCheck(idInputTextBox.getText().toString()));
						if(i != 0) {
							list.put("id", id);
							list.put("pw", pw);
							list.put("name", name);
							list.put("idNum", idNum);
							list.put("mail", mail);
							list.put("gender", gender);
							list.put("phone", phone);
							setData(list);
							duplCheckCnt = 0;
							joinFrame.setVisible(false);
							Login.getFrame().setVisible(true);
							textBoxNull();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			public void setData(HashMap<String,String> list) throws SQLException {
				UserDao.insertUser(list);
				JOptionPane.showMessageDialog(null, list.get("id")+"님 가입 완료", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				list.clear();
				textBoxNull();
				duplCheckCnt = 0;
			}
		});

		JoinCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt=0;
				textBoxNull();
				joinFrame.setVisible(false);
				Login.getFrame().setVisible(true);
			}
		});

	}// join class
	
	private void addComponentsToLayeredPane() {
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
	}
	
	// 주민등록번호 길이 체크
	public void textBoxNull () {
		idNumInputTextBox.setText("");
		idNumInputTextBox1.setText("");
		nameInputTextBox.setText("");
		mailInputTextBox.setText("");
		mailInputTextBox1.setText("");
		idInputTextBox.setText("");
		passInputTextBox.setText("");
		phoneInputTextBox.setText("");
	}

	public void blankTextBoxCheck() {
		if (idInputTextBox.getText().isEmpty() || passInputTextBox.getText().isEmpty()
				|| nameInputTextBox.getText().isEmpty() || idNumInputTextBox.getText().isEmpty()
				|| idNumInputTextBox1.getText().isEmpty() || mailInputTextBox.getText().isEmpty()
				|| mailInputTextBox1.getText().isEmpty() || phoneInputTextBox.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
	}

	// ID중복체크
	public int duplCheck(int code) {
		duplCheckCnt = 0;
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

	@Override
	public void keyTyped(KeyEvent e) {

	}

	// 주민등록번호 문자 체크
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode(); // 각 키의 키코드를 변수에 대입
		char keychar = e.getKeyChar(); // 각 키의 문자 혹은 숫자를 변수에 대입
		if (!Character.isDigit(keychar)) {
			JOptionPane.showMessageDialog(null, "숫자만 입력하세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			idNumInputTextBox.setText("");
			idNumInputTextBox1.setText("");
		}else if(idNumInputTextBox1.getText().length() > 1)
			JOptionPane.showMessageDialog(null, "주민번호는 1 또는 2 한자리만 입력하세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}