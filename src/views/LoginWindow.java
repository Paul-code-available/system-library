package views;

import javax.swing.JFrame;
import java.awt.*;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		
		setSize(320, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Image icono = tk.getImage("src/img/logoo.png");
        setIconImage(icono);
		
		setResizable(true);

		setLocationRelativeTo(null);
		
		LoginView panelito = new LoginView();
		
		setVisible(true);
		add(panelito);
	}
	

}
