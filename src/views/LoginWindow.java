package views;

import javax.swing.JFrame;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);

		setLocationRelativeTo(null);
		
		BorderPanel panelito = new BorderPanel();
		
		setVisible(true);
		add(panelito);
	}
	

}
