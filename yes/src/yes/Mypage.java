package yes.src.yes;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import java.awt.event.*;
import java.awt.*;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class Mypage extends JFrame {
   JFrame frame1 = this;

   public Mypage() {
      

      setTitle("마이 페이지");
      setBounds(350,150,1200, 800);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new FlowLayout());
      getContentPane().setLayout(null);

      // Back button
      JPanel Your_Book_Panel = new JPanel();
      Your_Book_Panel.setBounds(0, 0, 1200, 150);
      Your_Book_Panel.setLayout(null);
      Your_Book_Panel.setBackground(Color.white);
      
      JLabel Your_Book = new JLabel("예매 현황");
      Your_Book.setBounds(500, 0, 300, 150);
      Font font = new Font("Malgun Gothic",Font.BOLD,30);
      Your_Book.setFont(font);
      Your_Book_Panel.add(Your_Book);
      
      JButton backButton = new JButton("홈");
      backButton.setBounds(1, 580, 100, 30);
      
      
      
      backButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            Homedemo frame2 = new Homedemo();
            frame1.dispose();
            frame2.setVisible(true);
            
            
         }
      });
      
      getContentPane().add(backButton, BorderLayout.CENTER);
      add(Your_Book_Panel);
      setVisible(true);
   }
   
  
}