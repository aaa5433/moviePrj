package yes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import dao.DBConnection;
import dao.User;
import dao.UserDao;

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
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Join extends JFrame implements KeyListener {
	static User user = new User();
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

	static JTextField phoneInputTextBox = new JTextField();
	static JButton JoinOK = new JButton("가입");

	static boolean duplCheckCnt = true;
	static HashMap<String, String> list = new HashMap<>();

	public static JFrame getFrame() {
		return joinFrame;
	}

	public Join() {
		panel.revalidate();
		panel.repaint();
		joinFrame.setTitle("MegaBox 회원가입"); // 프레임 제목 설정
		joinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		joinFrame.setSize(500, 300); // 프레임 크기 설정
		joinFrame.setLocationRelativeTo(null);
		joinFrame.setVisible(true); // 화면에 프레임 출력

		panel.setLayout(null);

		joinFrame.getContentPane().add(panel);

		idLabel.setBounds(20, 20, 124, 30); // id
		panel.add(idLabel);

		passLabel.setBounds(20, 50, 124, 30); // pass
		panel.add(passLabel);

		nameLabel.setBounds(20, 80, 124, 30); // 이름
		panel.add(nameLabel);

		idNumLabel.setBounds(20, 110, 124, 30); //
		panel.add(idNumLabel);

		idNumLength.setBounds(220, 110, 100, 30); // ●
		panel.add(idNumLength);

		dash.setBounds(187, 110, 100, 30);
		panel.add(dash);

		mailLabel.setBounds(20, 140, 124, 30);
		panel.add(mailLabel);

		at.setBounds(184, 140, 100, 30);
		panel.add(at);

		PhoneLabel.setBounds(20, 170, 124, 30);
		panel.add(PhoneLabel);
		// ID
		idInputTextBox.setBounds(80, 20, 100, 30);
		panel.add(idInputTextBox);

		duplCheck.setBounds(200, 20, 90, 30);
		panel.add(duplCheck);

		// PASS
		passInputTextBox.setBounds(80, 50, 100, 30);
		panel.add(passInputTextBox);

		nameInputTextBox.setBounds(80, 80, 100, 30);
		panel.add(nameInputTextBox);

		idNumInputTextBox.setBounds(80, 110, 100, 30);
		panel.add(idNumInputTextBox);
		idNumInputTextBox.setColumns(10);
		idNumInputTextBox.addKeyListener(this);

		idNumInputTextBox1.setBounds(200, 110, 20, 30);
		panel.add(idNumInputTextBox1);
		idNumInputTextBox1.setColumns(10);
		idNumInputTextBox1.addKeyListener(this);

		mailInputTextBox.setBounds(80, 140, 100, 30);
		panel.add(mailInputTextBox);
		mailInputTextBox.setColumns(10);

		mailInputTextBox1.setBounds(200, 140, 100, 30);
		panel.add(mailInputTextBox1);
		mailInputTextBox1.setColumns(10);

		phoneInputTextBox.setBounds(80, 170, 100, 30);
		panel.add(phoneInputTextBox);

		JoinOK.setBounds(20, 230, 90, 30);
		panel.add(JoinOK);

		JoinCancel.setBounds(120, 230, 90, 30);
		panel.add(JoinCancel);

		duplCheck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt=false;
				duplCheck(UserDao.duplCheck(idInputTextBox.getText().toString()));
			}
		});

		JoinOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idInputTextBox.getText();
				String pw = passInputTextBox.getText();
				String name = nameInputTextBox.getText();
				String idNum = idNumInputTextBox.getText() + "-" + idNumInputTextBox1.getText();
				String mail = mailInputTextBox.getText() + "@" + mailInputTextBox1.getText();
				String sex = idNumInputTextBox1.getText().toString().substring(0, 1);
				String phone = phoneInputTextBox.getText();
				list.put("id", id);
				list.put("pw", pw);
				list.put("name", name);
				list.put("idNum", idNum);
				list.put("mail", mail);
				list.put("sex", sex);
				list.put("phone", phone);
				System.out.println(id+pw+name+idNum+mail+"/"+sex+"/"+phone);
				
				//공백체크
				if (idInputTextBox.getText().isEmpty() || passInputTextBox.getText().isEmpty() || nameInputTextBox.getText().isEmpty() || idNumInputTextBox.getText().isEmpty() || idNumInputTextBox1.getText().isEmpty() || mailInputTextBox.getText().isEmpty() || mailInputTextBox1.getText().isEmpty() || phoneInputTextBox.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "공백칸을 입력하세요!", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				//ID 중복체크
				else if (duplCheckCnt) {
					JOptionPane.showMessageDialog(null, "ID중복체크를 해야 합니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}
				//ID 길이 체크!
				else if (idNumLengthCheck(idNumInputTextBox.getText().toString(), idNumInputTextBox1.getText().toString()) != 7) {
					JOptionPane.showMessageDialog(null, "올바른 주민번호가 아닙니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				}else {
					try {
						setData(list);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textBoxNull();
					duplCheckCnt = true;
					joinFrame.setVisible(false);
					Login.getFrame().setVisible(true);
					
				}
			}

			public void setData(HashMap<String,String> list) throws SQLException {
				UserDao.insertUser(list);
				JOptionPane.showMessageDialog(null, list.get("id")+"님 가입 완료", "경고 메시지", JOptionPane.WARNING_MESSAGE);
				list.clear();
				textBoxNull();
				duplCheckCnt = true;
			}
		});

		JoinCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				duplCheckCnt=false;
				textBoxNull();
				joinFrame.setVisible(false);
				Login.getFrame().setVisible(true);
			}
		});

	}// join class

	// 주민등록번호 길이 체크
	public int idNumLengthCheck(String idNum, String idNum1) {
		System.out.println(idNum.length() + idNum1.length());
		return idNum.length() + idNum1.length();
	}
	public void textBoxNull () {
		idNumInputTextBox.setText("");
		idNumInputTextBox1.setText("");
		nameInputTextBox.setText("");
		mailInputTextBox.setText("");
		mailInputTextBox1.setText("");
		idInputTextBox.setText("");
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
	public void duplCheck(int code) {
		duplCheckCnt=false;
		if (code == 0)
			JOptionPane.showMessageDialog(null, idInputTextBox.getText() + "는 존재하는 아이디입니다.", "경고 메시지",
					JOptionPane.WARNING_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, idInputTextBox.getText() + "는사용 가능한 ID입니다.", "경고 메시지",
					JOptionPane.WARNING_MESSAGE);
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
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}