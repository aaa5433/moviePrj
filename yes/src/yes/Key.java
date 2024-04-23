//package yes;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import javax.swing.JFrame;
//import javax.swing.JTextArea;
//
//class Key extends JFrame implements KeyListener{
//	JTextArea area;//창에 텍스트 영역을 만들기위한 변수 선언.
//	
//	public void MyKeyEvent() {
//		initData();
//		setInitLayout();
//		addEventListener();
//	}
//	
//	private void initData() {
//		setTitle("keyBoard Event!");
//		setSize(500, 500);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
//	
//	private void setInitLayout() {
//		setVisible(true);
//		this.add(area);  //창에 텍스트 입력을 추가
//	}
//	
//	private void addEventListener() {
//		area.addKeyListener(this);  //텍스트 입력 부분에 키보드의 입력을 감지하도록 함
//	}
//
//	//////////////////////////////////////////////////
//	@Override
//	public void keyTyped(KeyEvent e) {
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		int keycode = e.getKeyCode();  //각 키의 키코드를 변수에 대입
//		char keychar = e.getKeyChar();  //각 키의 문자 혹은 숫자를 변수에 대입
//		System.out.print("keycode : " + keycode + " => " + keychar);
//		System.out.println();
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		
//	}
//}