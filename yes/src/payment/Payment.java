package yes.src.payment;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Payment extends JFrame implements ActionListener{
   Container paymentPage;
   JPanel panel = new JPanel();
   JButton btn1, btn2, btn3, btn4;
   JCheckBox jcb1, jcb2, jcb3, jcb4;

   public Payment (String title) throws HeadlessException{
      super(title);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      paymentPage = this.getContentPane();
      this.setBounds(200, 100, 400, 300);
      paymentPage.setBackground(new Color(255, 255, 255));
      paymentPage.setLayout(new FlowLayout());
      setDesign();
      setVisible(true);
   }

   private void setDesign() {
      this.setLayout(new FlowLayout());
      
      btn1 = new JButton("신용카드/체크카드");
      btn2 = new JButton("계좌이체");
      btn3 = new JButton("휴대폰 결제");
      btn4 = new JButton("쿠폰");
      jcb1 = new JCheckBox();
      jcb2 = new JCheckBox();
      jcb3 = new JCheckBox();
      jcb4 = new JCheckBox();

      
      	btn1.setBackground(Color.WHITE); // 색상
        btn1.setOpaque(true); // 투명
        btn1.setBorderPainted(true); // 외곽선
        btn1.setPreferredSize(new Dimension(150, 60)); // 버튼 사이즈
        btn1.setContentAreaFilled(false); // 내용영역 채우기
        btn1.setFocusPainted(false); // 포커스 표시 설정

        
        btn2.setBackground(Color.WHITE);
        btn2.setOpaque(true);
        btn2.setBorderPainted(true);
        btn2.setPreferredSize(new Dimension(150, 60));
        btn2.setContentAreaFilled(false);
        btn2.setFocusPainted(false);
        
        btn3.setBackground(Color.WHITE);
        btn3.setOpaque(true);
        btn3.setBorderPainted(true);
        btn3.setPreferredSize(new Dimension(150, 60));
        btn3.setContentAreaFilled(false);
        btn3.setFocusPainted(false);
        
        btn4.setBackground(Color.WHITE);
        btn4.setOpaque(true);
        btn4.setBorderPainted(true);
        btn4.setPreferredSize(new Dimension(150, 60));
        btn4.setContentAreaFilled(false);
        btn4.setFocusPainted(false);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);

        this.paymentPage.add(btn1);
        this.paymentPage.add(btn2);
        this.paymentPage.add(btn3);
        this.paymentPage.add(btn4);
        this.add(btn1);
        this.add(jcb1);
        this.add(btn2);
        this.add(jcb2);
        this.add(btn3); 
        this.add(jcb3);
        this.add(btn4); 
        this.add(jcb4); 
   }
   
   @Override
    public void actionPerformed(ActionEvent e) {
	    String a;
        Object ob = e.getSource();
        
        if (ob == this.btn1) {
           String[] cardOption = {"확인", "취소"};
           JOptionPane.showInputDialog(btn1, "카드 번호를 입력하세요.");
           JOptionPane.showOptionDialog(paymentPage, "결제 금액?", "결제 금액 확인", JOptionPane.CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null,cardOption,cardOption[0]);
           JOptionPane.showMessageDialog(btn1, "결제가 완료되었습니다.");
        }
        else if (ob == this.btn2) {
        	String[] title = {"은행선택", "국민은행", "신한은행", "하나은행", "농협은행", "우리은행"};
   			JComboBox<String> jcm1 = new JComboBox<>(title);
   			JOptionPane.showInputDialog(btn2, jcm1, "계좌번호를 입력하세요", JOptionPane.PLAIN_MESSAGE);
   			JOptionPane.showInputDialog(btn2, a = "송금할 금액");
   			if(a != null) {
   				JOptionPane.showMessageDialog(btn2, "결제가 완료되었습니다.", "결제 완료", JOptionPane.PLAIN_MESSAGE);
   			}
        }
        else if (ob == this.btn3) {
        	JOptionPane.showInputDialog(btn3, "휴대폰 번호를 입력해주세요.");
        	JOptionPane.showMessageDialog(btn3, "결제가 완료되었습니다.");
        }
        else if (ob == this.btn4) {
        	JOptionPane.showMessageDialog(btn4, "");
        }
    }
}