//jhmoon
package yes.src.yes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import yes.src.dao.UserDao;

public class Login implements KeyListener {
	private static JFrame loginFrame = new JFrame();
	private static JLabel idText = new JLabel("ID");
	private static JLabel passText = new JLabel("비밀번호");
	private static JTextField idInputTextBox = new JTextField("");
	private static JPasswordField passInputTextBox = new JPasswordField("");
	private static JButton LoginBtn = new JButton("Login");
	private static JLabel join = new JLabel("회원가입");
	private static JLayeredPane layeredPane = new JLayeredPane();
	private static JLabel background = new JLabel(new ImageIcon("img\\megaboxlogo.jpg"));
	private static JLabel closeBtn = new JLabel(new ImageIcon("img\\close.jpg"));

	public static JFrame getFrame() {
		return loginFrame;
	}

	public Login() throws IOException {
		idInputTextBox.setNextFocusableComponent(passInputTextBox);
		passInputTextBox.setNextFocusableComponent(LoginBtn);

		loginFrame.setSize(500, 300);
		loginFrame.setTitle("MegaBox Login"); // 프레임 제목 설정
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setResizable(false);

		background.setBounds(0, 0, 500, 300);
		layeredPane.setPreferredSize(new Dimension(500, 300));

		idText.setBounds(60, 50, 56, 30);
		passText.setBounds(60, 100, 56, 30);

		idInputTextBox.setBounds(130, 50, 180, 30);
		passInputTextBox.setBounds(130, 100, 180, 30);
		LoginBtn.setBounds(330, 50, 100, 80);
		LoginBtn.setBorderPainted(false);
		
		closeBtn.setBounds(470, 0, 30, 30);

		join.setBounds(80, 250, 100, 38);
		join.setForeground(Color.white);

		addComponentsToLayeredPane();
		Color color = new Color(70, 70, 80);
		LoginBtn.setText("로그인");
		LoginBtn.setForeground(Color.white);
		LoginBtn.setBackground(color);
		loginFrame.add(layeredPane);
		loginFrame.setUndecorated(true);
		loginFrame.setVisible(true);
		loginFrame.getContentPane().add(background);

		
		
		LoginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginCheck(idInputTextBox.getText(), passInputTextBox.getPassword());
			}
		});

		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(false);
				new Join();
				idInputTextBox.setText("");
				passInputTextBox.setText("");
			}
		});

		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                System.exit(0);
			}
		});
		
		passInputTextBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					loginCheck(idInputTextBox.getText(), passInputTextBox.getPassword());
				}
			}
		});
	}

	private void addComponentsToLayeredPane() {
		layeredPane.add(background, Integer.valueOf(0));
		layeredPane.add(idText, Integer.valueOf(1));
		layeredPane.add(passText, Integer.valueOf(2));
		layeredPane.add(idInputTextBox, Integer.valueOf(3));
		layeredPane.add(passInputTextBox, Integer.valueOf(4));
		layeredPane.add(LoginBtn, Integer.valueOf(5));
		layeredPane.add(join, Integer.valueOf(6));
		layeredPane.add(closeBtn, Integer.valueOf(7));
	}
	   
	public void loginCheck(String id, char[] cs) {
		LocalTime now = LocalTime.now();
		LocalDateTime now1 = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String formatedTime = now.format(formatter);

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // 포맷 적용
		String dateFormated = now1.format(dateFormatter);

		String pw = new String(cs);
		int loginCode = UserDao.login(id, pw);
		System.out.println(loginCode);
		try {
			if (loginCode == 0) {
				JOptionPane.showMessageDialog(null, id + "님 " + "로그인 일자\n" + dateFormated + " " + formatedTime,
						"경고 메시지", JOptionPane.WARNING_MESSAGE);
				loginFrame.setVisible(false);
				new Homedemo();
			} else if (loginCode == 1)
				JOptionPane.showMessageDialog(null, "비밀번호가 맞지 않습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			else if (loginCode == 2)
				JOptionPane.showMessageDialog(null, "ID가 존재하지 않습니다.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			else if (id.equals(""))
				JOptionPane.showMessageDialog(null, "ID를 입력하세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			else if (pw.equals(""))
				JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.", "경고 메시지", JOptionPane.WARNING_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "로그인 정보가 맞지 않습니다.\n카운터에 문의하세요.", "경고 메시지",
						JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		System.out.println(keycode);
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 10) {
			System.out.println("enter");
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("enter");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}