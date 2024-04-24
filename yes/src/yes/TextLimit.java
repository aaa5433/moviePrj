package yes.src.yes;
import java.awt.*;
import java.awt.event.*;

public class TextLimit extends TextField implements KeyListener {
	private static int maxLength;

	public TextLimit(String initialStr, int col, int maxLength) {
		super(initialStr, col);
		this.maxLength = maxLength;
		addKeyListener(this);
	}

	public TextLimit(int col, int maxLength) {
		this("", col, maxLength);
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		int len = getText().length();
		if (len < maxLength) {
			return;
		} else {
			if ((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_ENTER)
					|| (c == KeyEvent.VK_TAB) || e.isActionKey())
				return;
			else {
				e.consume();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
}