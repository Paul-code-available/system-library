package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BorderPanel extends JPanel {
	
	public BorderPanel() {
		setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);
		setBorder(emptyBorder);
		
		crearPanelSuperior();
		
		crearPanelIzquierdo();
		
		crearPanelCentro();
	
	}
	
	public void crearPanelSuperior() {
		JPanel panelSuperior = new JPanel();
		//panelSuperior.setBackground(Color.GREEN);
		add(panelSuperior, BorderLayout.NORTH);
		
		JLabel lbltitle = new JLabel("User Login");
		panelSuperior.add(lbltitle);
	}
	
	public void crearPanelIzquierdo() { 
		JPanel panelIzquierda = new JPanel();
		panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
		add(panelIzquierda, BorderLayout.WEST);
		
		JLabel lblEmail = new JLabel("Email:");
		panelIzquierda.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña:"); 
		panelIzquierda.add(lblContrasena);
		
	}
	
	
	public void crearPanelCentro() { 
		JPanel panelCentro = new JPanel();
		//panelCentro.setBackground(Color.BLUE);
		
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		add(panelCentro, BorderLayout.CENTER);
		
		JTextField txtEmail = new JTextField();
		panelCentro.add(txtEmail);
		
		JPasswordField contrasena = new JPasswordField(); 
		panelCentro.add(contrasena);
	}
	
	



}
