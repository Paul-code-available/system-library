package views;

import javax.swing.JFrame;
import java.awt.*;

public class LoginWindow extends JFrame {
	
	private LoginView loginView;
	
	public LoginWindow() {
		
		setSize(350, 290);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);

		setLocationRelativeTo(null);
		
		loginView = new LoginView(this);
		add(loginView);
	
		setVisible(true);
		
	}
	
	public LoginView getLoginView() {
		return loginView;
	}
	

}
