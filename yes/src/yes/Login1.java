//package yes;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTable;
//import javax.swing.border.EmptyBorder;
//import javax.swing.table.TableModel;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.GraphicsDevice;
//import java.awt.GraphicsEnvironment;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.JLabel;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.JDesktopPane;
//import javax.swing.JInternalFrame;
//
//public class Login1 extends JFrame implements KeyListener  {
//    private Container contentPane = getContentPane(); //프레임에서 컨텐트팬 받아오기
//    private GraphicsDevice scrSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    private int width = scrSize.getDisplayMode().getWidth();
//    private int height = scrSize.getDisplayMode().getHeight();
//    /**
//     * @wbp.nonvisual location=222,339
//     */
//    ImageIcon appleIcon = new ImageIcon("images/apple.jpg");
//    
//    public Login() {
//    	//화면 해상도
//        setTitle("MegaBox Login"); // 프레임 제목 설정
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
//        setSize(500, 300); // 프레임 크기 설정
//        setLocation(width/4,height/4);
//
//        contentPane.setLayout(null);
//
//        JLabel idText = new JLabel("ID");
//        idText.setBounds(60, 50, 56, 30);
//        contentPane.add(idText);
//        
//        
//        JLabel passText = new JLabel("비밀번호");
//        passText.setBounds(60, 100, 56, 30);
//        contentPane.add(passText);
//        
//        //ID pass 텍스트 박스
//        JTextField idInputTextBox = new JTextField();
//        idInputTextBox.setBounds(130, 50, 180, 30);
//        contentPane.add(idInputTextBox);
//        idInputTextBox.setColumns(10); // 텍스트 필드 기본 입력문자 갯수
//        
//        JPasswordField passInputTextBox = new JPasswordField();
//        passInputTextBox.setBounds(130, 100, 180, 30);
//        contentPane.add(passInputTextBox);
//        
//        JButton LoginBtn = new JButton("Login");  
//        LoginBtn.setBounds(330,50,100,80);  
//        contentPane.add(LoginBtn);
//        
//        JLabel join = new JLabel("회원가입");
//        join.setBounds(80,215,100,38);
//        join.setForeground(Color.BLUE.darker());
////        join.addMouseListener((MouseListener) this);
//        contentPane.add(join);
//        
//        
//        //회원가입 클릭
//        join.addMouseListener(new MouseListener() {
//			public void mouseReleased(MouseEvent e) {}
//			public void mousePressed(MouseEvent e) {}
//			public void mouseExited(MouseEvent e) {}
//			public void mouseEntered(MouseEvent e) {}
//			public void mouseClicked(MouseEvent e) {
//		        setVisible(false);
//				new Join();
//			}
//		});
//        
//        setVisible(true); //화면에 프레임 출력
//        passInputTextBox.addKeyListener(this);
//    }
//    
//	@Override
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyCode()==10) {
//        	System.out.println("enter");
//        }
//    }
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void keyReleased(KeyEvent e) {
//		
//	}
//    
//    /**
//    void MouseAndKeyboardPanel(){
//		JLabel text = new JLabel("Mouse Test");
//		add(text);
//        text.setBounds(150,200,100,80);
//		this.addMouseListener(new MouseListener() {
//			public void mouseClicked(MouseEvent e) {
//				System.out.println("click!");
//			}
//			public void mousePressed(MouseEvent e) {
//				System.out.println("press!");
//			}
//			public void mouseReleased(MouseEvent e) {
//				System.out.println("release!");
//			}
//			public void mouseEntered(MouseEvent e) {
//				setBackground(Color.DARK_GRAY);
//			}
//			public void mouseExited(MouseEvent e) {
//				setBackground(Color.RED);
//			}
//		});
//		add(text);
//	}
//	**/
//}