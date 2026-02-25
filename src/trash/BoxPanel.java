package trash;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BoxPanel extends JPanel{
	
	public BoxPanel() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);
		setBorder(emptyBorder);
		
		
		JPanel panel = new JPanel();
		//
		panel.add(Box.createVerticalGlue());
		
		
		// etiqueta de iniciar sesión, se alinea y se añade
		JLabel lbltitle = new JLabel("Iniciar sesión");
		lbltitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lbltitle);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setAlignmentX(Component.RIGHT_ALIGNMENT);
		add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(txtEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(lblContrasena);
		
		JTextField txtContrasena = new JTextField();
		txtContrasena.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(txtContrasena);
		
		
		
	}

}
