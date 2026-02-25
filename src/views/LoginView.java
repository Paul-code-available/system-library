package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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

public class LoginView extends JPanel {
	
	public LoginView() {
		setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(20,10,20,10);
		setBorder(emptyBorder);
		
		crearPanelSuperior();
		
		crearPanelIzquierdo();
		
		crearPanelCentro();
		
		crearPanelInferior();
	
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
		
		panelIzquierda.add(Box.createRigidArea(new Dimension(50, 50)));
		
		JLabel lblEmail = new JLabel("Email:");
		panelIzquierda.add(lblEmail);
		
		panelIzquierda.add(Box.createRigidArea(new Dimension(50, 50)));
		
		JLabel lblContrasena = new JLabel("Contraseña:"); 
		panelIzquierda.add(lblContrasena);
		
	}
	
	
	public void crearPanelCentro() { 
		JPanel panelCentro = new JPanel();
		//panelCentro.setBackground(Color.BLUE);
		
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		add(panelCentro, BorderLayout.CENTER);
		
		panelCentro.add(Box.createRigidArea(new Dimension(50, 50)));
		
		JTextField txtEmail = new JTextField(15);
	
		txtEmail.setMaximumSize(txtEmail.getPreferredSize());
		panelCentro.add(txtEmail);

		panelCentro.add(Box.createRigidArea(new Dimension(50, 45)));
		
		JPasswordField contrasena = new JPasswordField(15); 
		contrasena.setMaximumSize(contrasena.getPreferredSize());
		panelCentro.add(contrasena);
	}
	
	public void crearPanelInferior() {
		JPanel panelInferior = new JPanel();
		
		add(panelInferior, BorderLayout.SOUTH);
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		panelInferior.add(btnIniciarSesion);
		
	}
	



}
