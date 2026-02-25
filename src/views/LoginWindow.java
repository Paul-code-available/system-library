package views;

import javax.swing.JFrame;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		
		setSize(320, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);

		setLocationRelativeTo(null);
		
		BorderPanel panelito = new BorderPanel();
		
		setVisible(true);
		add(panelito);
	}
	

}
