package yes.src.yes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Payment extends JFrame implements ActionListener {
	JFrame frame1 = this;
	private Container paymentPage;
	private JButton btn1, btn2;
	private JRadioButton r1, r2, r3, r4;
	private ButtonGroup group = new ButtonGroup();
	private boolean bl = false;
	private JLabel label = new JLabel("        ※결제 방법을 선택해주세요※        ");
	private ImageIcon icon = new ImageIcon("image/logo.jpg");
	private Image img = icon.getImage();
	private Image changeImg = img.getScaledInstance(350, 80, Image.SCALE_SMOOTH);
	private ImageIcon changeIcon = new ImageIcon(changeImg);
	private JLabel imagelabel = new JLabel(changeIcon);

	public Payment() throws HeadlessException {
		super("결제 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		paymentPage = this.getContentPane();
		this.setBounds(200, 100, 350, 317);
		paymentPage.setBackground(new Color(99, 55, 192));
		paymentPage.setLayout(new FlowLayout());
		setDesign();
		setVisible(true);
	}

	private void setDesign() {
		this.setLayout(new FlowLayout());

		r1 = new JRadioButton("신용카드/체크카드");
		r2 = new JRadioButton("계좌이체");
		r3 = new JRadioButton("휴대폰 결제");
		r4 = new JRadioButton("쿠폰사용");
		btn1 = new JButton("결제");

		r1.setBackground(new Color(240, 245, 247)); // 색상
		r1.setBorderPainted(true); // 외곽선
		r1.setPreferredSize(new Dimension(150, 60)); // 버튼 사이즈
		r1.setFocusPainted(false); // 포커스 표시 설정

		r2.setBackground(new Color(240, 245, 247));
		r2.setBorderPainted(true);
		r2.setPreferredSize(new Dimension(150, 60));
		r2.setFocusPainted(false);

		r3.setBackground(new Color(240, 245, 247));
		r3.setBorderPainted(true);
		r3.setPreferredSize(new Dimension(150, 60));
		r3.setFocusPainted(false);

		r4.setBackground(new Color(240, 245, 247));
		r4.setBorderPainted(true);
		r4.setPreferredSize(new Dimension(150, 60));
		r4.setFocusPainted(false);

		btn1.setBackground(new Color(240, 245, 247));
		btn1.setBorderPainted(true);
		btn1.setPreferredSize(new Dimension(130, 30));
		btn1.setFocusPainted(false);
		btn1.setFont(btn1.getFont().deriveFont(14.0f));

		label.setFont(label.getFont().deriveFont(18.0f));
		label.setForeground(Color.WHITE);

		paymentPage.add(label, BorderLayout.NORTH);
		this.add(r1);
		this.add(r2);
		this.add(r3);
		this.add(r4);
		this.add(btn1);
		btn1.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		paymentPage.add(imagelabel);

		// btn1의 버튼 마우스 이벤트
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				// 마우스가 해당 컴포넌트 영역 안으로 들어올때 발생
				btn1.setBackground(new Color(225, 226, 245));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// 마우스가 해당 컴포넌트 영역 밖으로 나갈때 발생
				btn1.setBackground(new Color(240, 245, 247));
			}
		});

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Homedemo frame2 = new Homedemo();
				frame1.dispose();
				frame2.setVisible(true);

			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (r1 == ob || r2 == ob || r3 == ob || r4 == ob) {
			bl = true;
		}
		if (btn1 == ob) {
			if (bl == true) {
				JOptionPane.showMessageDialog(btn1, "결제 완료");
			} else {
				JOptionPane.showMessageDialog(btn1, "결제 수단을 선택해주세요.");
			}
		}
	}
}