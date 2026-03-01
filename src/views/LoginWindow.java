package views;

import javax.swing.JFrame;
import java.awt.*;

public class LoginWindow extends JFrame {
	
	public LoginWindow() {
		
		setSize(350, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit tk = Toolkit.getDefaultToolkit();
        Image icono = tk.getImage("src/img/logoo.png");
        setIconImage(icono);
		
		setResizable(false);

		setLocationRelativeTo(null);
		
		LoginView panelito = new LoginView();
		
		setVisible(true);
		add(panelito);
	}
	

}
