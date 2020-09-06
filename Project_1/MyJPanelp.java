package Project_1;


import java.awt.Insets;

import javax.swing.JPanel;

public class MyJPanelp extends JPanel {

	int a, b, c, d;
	public MyJPanelp() {
		this(30, 30, 30, 30);
	}
	
	public MyJPanelp(int a, int b, int c , int d) {
		this.a = a; this.b = b; this.c = c; this.d = d;
	}
	
	@Override
	public Insets getInsets() {
		return new Insets(a, b, c, d);
	}

}