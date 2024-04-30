package yes.src.yes;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homedemo extends JFrame{
   public Homedemo() {
      JFrame frame = this;
      setTitle("영화예매");
      setLayout(null);

      // 카드레이아웃

      JPanel card = new JPanel(new CardLayout());

      card.setBounds(0, 100, 1200, 800);
      card.setBackground(Color.yellow);

      // 첫 번째 창

      JPanel topPanel = new JPanel();
      topPanel.setLayout(null);
      topPanel.setBounds(0, 0, 1200, 600);

      // 첫 번째 버튼패널

      JPanel buttonPanel = new JPanel(); // 버튼

      buttonPanel.setBounds(1080, 250, 100, 100);

      buttonPanel.setLayout(null);

      // 첫 번째 다음버튼

      JButton nextButton = new JButton("다음");

      nextButton.setBounds(0, 20, 100, 50);
      buttonPanel.add(nextButton);

      // 두 번째 창

      JPanel middlePanel = new JPanel();

      middlePanel.setLayout(null);

      middlePanel.setBounds(0, 0, 1080, 455);

      // 두 번째 버튼패널

      JPanel buttonPanel2 = new JPanel(); // 버튼

      buttonPanel2.setBounds(1080, 250, 100, 100);

      buttonPanel2.setLayout(null);

      // 두 번째 다음버튼

      JButton nextButton2 = new JButton("다음");

      nextButton2.setBounds(0, 20, 100, 50);
      buttonPanel2.add(nextButton2);

      // 세 번째 창

      JPanel bottomPanel = new JPanel();

      bottomPanel.setLayout(null);

      bottomPanel.setBounds(0, 0, 1080, 455);

      // 버튼패널
      JPanel buttonPanel3 = new JPanel(); // 버튼
      buttonPanel3.setBounds(1080, 250, 100, 100);
      buttonPanel3.setLayout(null);

      // 다음버튼
      JButton nextButton3 = new JButton("다음");
      nextButton3.setBounds(0, 20, 100, 50);
      buttonPanel3.add(nextButton3);

      // 1~4번째 영화--------------------------------------------

      // -----패널1

      JPanel panel1 = new JPanel();
      panel1.setBounds(110, 150, 200, 300);
      JLabel imglabel1 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon1 = new ImageIcon("img\\criminal.PNG");// 이미지 주소
      Image img1 = icon1.getImage();
      Image updateImg1 = img1.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon1 = new ImageIcon(updateImg1);
      imglabel1.setIcon(updateIcon1);
      panel1.add(imglabel1);

      // ------패널2

      JPanel panel2 = new JPanel();
      panel2.setBounds(370, 150, 200, 300);
      JLabel imglabel2 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon2 = new ImageIcon("img\\panda.png");// 이미지 주소
      Image img2 = icon2.getImage();
      Image updateImg2 = img2.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon2 = new ImageIcon(updateImg2);
      imglabel2.setIcon(updateIcon2);
      panel2.add(imglabel2);

      // ------패널 3

      JPanel panel3 = new JPanel();
      panel3.setBounds(620, 150, 200, 300);
      JLabel imglabel3 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon3 = new ImageIcon("img\\sugar.jpg");// 이미지 주소
      Image img3 = icon3.getImage();
      Image updateImg3 = img3.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon3 = new ImageIcon(updateImg3);
      imglabel3.setIcon(updateIcon3);
      panel3.add(imglabel3);

      // --------패널 4

      JPanel panel4 = new JPanel();
      panel4.setBounds(870, 150, 200, 300);
      JLabel imglabel4 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon4 = new ImageIcon("img\\pamyo.jpg");// 이미지 주소
      Image img4 = icon4.getImage();
      Image updateImg4 = img4.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon4 = new ImageIcon(updateImg4);
      imglabel4.setIcon(updateIcon4);
      panel4.add(imglabel4);

      // -------------------------------------------------

      // 5~8 영화------------------------------------------

      // 패널 5 ---------------------------

      JPanel panel5 = new JPanel();
      panel5.setBounds(110, 150, 200, 300);
      JLabel imglabel5 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon5 = new ImageIcon("img\\challengers.jpg");// 이미지 주소
      Image img5 = icon5.getImage();
      Image updateImg5 = img5.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon5 = new ImageIcon(updateImg5);
      imglabel5.setIcon(updateIcon5);
      panel5.add(imglabel5);
      

      // 패널 6------------------------

      JPanel panel6 = new JPanel();
      panel6.setBounds(370, 150, 200, 300);
      JLabel imglabel6 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon6 = new ImageIcon("img\\monster.jpg");// 이미지 주소
      Image img6 = icon6.getImage();
      Image updateImg6 = img6.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon6 = new ImageIcon(updateImg6);
      imglabel6.setIcon(updateIcon6);
      panel6.add(imglabel6);

      // 패널 7 -------------------

      JPanel panel7 = new JPanel();
      panel7.setBounds(620, 150, 200, 300);
      JLabel imglabel7 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon7 = new ImageIcon("img\\japan.jpg");// 이미지 주소
      Image img7 = icon7.getImage();
      Image updateImg7 = img7.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon7 = new ImageIcon(updateImg7);
      imglabel7.setIcon(updateIcon7);
      panel7.add(imglabel7);

      // 패널 8 -----------------------

      JPanel panel8 = new JPanel();
      panel8.setBounds(870, 150, 200, 300);
      JLabel imglabel8 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon8 = new ImageIcon("img\\stunt.jpg");// 이미지 주소
      Image img8 = icon8.getImage();
      Image updateImg8 = img8.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon8 = new ImageIcon(updateImg8);
      imglabel8.setIcon(updateIcon8);
      panel8.add(imglabel8);

      // 9~10영화---------------------------------------------------------------------------

      // 패널 9 ----------------------

      JPanel panel9 = new JPanel();
      panel9.setBounds(110, 150, 200, 300);
      JLabel imglabel9 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon9 = new ImageIcon("img\\poketmon.jpg");// 이미지 주소
      Image img9 = icon9.getImage();
      Image updateImg9 = img9.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon9 = new ImageIcon(updateImg9);
      imglabel9.setIcon(updateIcon9);
      panel9.add(imglabel9);

      // 패널 10 ----------------------

      JPanel panel10 = new JPanel();
      panel10.setBounds(370, 150, 200, 300);
      JLabel imglabel10 = new JLabel();// 이미지 담을 라벨
      ImageIcon icon10 = new ImageIcon("img\\traveler.jpg");// 이미지 주소
      Image img10 = icon10.getImage();
      Image updateImg10 = img10.getScaledInstance(200, 300, Image.SCALE_DEFAULT);// 크기조정
      ImageIcon updateIcon10 = new ImageIcon(updateImg10);
      imglabel10.setIcon(updateIcon10);
      panel10.add(imglabel10);

      // ---------마이페이지

      JPanel my_Page_Panel = new JPanel();
      JButton my_Page_button = new JButton("마이페이지");
      my_Page_Panel.setBounds(1020, 10, 200, 100);
      my_Page_Panel.add(my_Page_button);

      // --------예매버튼
      class reserve_Panel extends JPanel {
         public reserve_Panel() {
            setLayout(null);
            JButton reserve = new JButton("예매하기");
            reserve.setBounds(0, 0, 180, 40);// 예매버튼 버튼 설정

            reserve.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                  // 두 번째 프레임 생성
                  frame.setVisible(false);
                  Choice_date frame2 = new Choice_date();
                  
                  
                  
                  

          
               }
            });

            add(reserve);
         }
      }
      reserve_Panel reserve_Panel1 = new reserve_Panel();
      reserve_Panel1.setBounds(120, 460, 180, 40);// 예매버튼 패널 설정

      reserve_Panel reserve_Panel2 = new reserve_Panel();
      reserve_Panel2.setBounds(380, 460, 180, 40);

      reserve_Panel reserve_Panel3 = new reserve_Panel();
      reserve_Panel3.setBounds(630, 460, 180, 40);

      reserve_Panel reserve_Panel4 = new reserve_Panel();
      reserve_Panel4.setBounds(880, 460, 180, 40);

      reserve_Panel reserve_Panel5 = new reserve_Panel();
      reserve_Panel5.setBounds(120, 460, 180, 40);

      reserve_Panel reserve_Panel6 = new reserve_Panel();
      reserve_Panel6.setBounds(380, 460, 180, 40);

      reserve_Panel reserve_Panel7 = new reserve_Panel();
      reserve_Panel7.setBounds(630, 460, 180, 40);

      reserve_Panel reserve_Panel8 = new reserve_Panel();
      reserve_Panel8.setBounds(880, 460, 180, 40);

      reserve_Panel reserve_Panel9 = new reserve_Panel();
      reserve_Panel9.setBounds(120, 460, 180, 40);

      reserve_Panel reserve_Panel10 = new reserve_Panel();
      reserve_Panel10.setBounds(380, 460, 180, 40);

      // 첫 번째 창에 영화 1~4 이미지와 예매버튼 추가

      topPanel.add(panel1);
      topPanel.add(panel2);
      topPanel.add(panel3);
      topPanel.add(panel4);
      topPanel.add(reserve_Panel1);
      topPanel.add(reserve_Panel2);
      topPanel.add(reserve_Panel3);
      topPanel.add(reserve_Panel4);
      topPanel.add(buttonPanel);

      // 두 번째 창에 영화 5~8 이미지와 예매버튼 추가

      middlePanel.add(panel5);
      middlePanel.add(panel6);
      middlePanel.add(panel7);
      middlePanel.add(panel8);
      middlePanel.add(reserve_Panel5);
      middlePanel.add(reserve_Panel6);
      middlePanel.add(reserve_Panel7);
      middlePanel.add(reserve_Panel8);
      middlePanel.add(buttonPanel2);

      // 세 번째 창에 영화 9~10 이미지와 예매버튼 추가

      bottomPanel.add(panel9);
      bottomPanel.add(panel10);
      bottomPanel.add(reserve_Panel9);
      bottomPanel.add(reserve_Panel10);
      bottomPanel.add(buttonPanel3);

      // 카드레이아웃에 1,2,3번째 패널 추가

      card.add(topPanel, "topPanel");
      card.add(middlePanel, "middlePanel");
      card.add(bottomPanel, "bottomPanel");

      // 버튼 동작

      CardLayout cl = (CardLayout) card.getLayout();

      nextButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.next(card);
         }
      });

      nextButton2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.next(card);
         }
      });

      nextButton3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            cl.next(card);
         }
      });

      my_Page_button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            
               // 두 번째 프레임 생성
               frame.setVisible(false);
               
               Mypage frame2 = new Mypage();

               
             
            
            
         }
      });
      
      
      class logo extends JPanel{
    	  public logo() {
    		  setBounds(10, 10, 200, 100);
    		  JLabel megabox = new JLabel();// 이미지 담을 라벨
    	      ImageIcon icon = new ImageIcon("image\\logo.jpg");// 이미지 주소
    	      Image img = icon.getImage();
    	      Image updateImg = img.getScaledInstance(200, 80, Image.SCALE_DEFAULT);// 크기조정
    	      ImageIcon updateIcon = new ImageIcon(updateImg);
    	      megabox.setIcon(updateIcon);
    	      add(megabox);
    	  }
      }

      // 프레임에 마이페이지와 카드레이아웃 패널 추가

      add(my_Page_Panel);
      add(card);
      add(new logo());
      
      
      setBounds(350, 150, 1200, 800);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      new Homedemo();
   }
}