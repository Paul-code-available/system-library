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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import components.TextPrompt;
import utils.SwingUtils;

public class LoginView extends JPanel {
	
	public LoginView() {
		setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(20,20,20,20);
		setBorder(emptyBorder);
		
		crearPanelSuperior();
		
		crearPanelCentro();
		
		crearPanelInferior();
	
	}
	
	public void crearPanelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("Iniciar sesión");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitle);
		
		add(panelSuperior, BorderLayout.NORTH);
	}
	
	
	public void crearPanelCentro() { 
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		
		
		JTextField txtEmail = SwingUtils.crearJtf(0, 30, "Correo electrónico");
		panelCentro.add(txtEmail);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JPasswordField jpfContrasena = new JPasswordField(); 
		jpfContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		TextPrompt promptContrasena = new TextPrompt("Contraseña", jpfContrasena);
		panelCentro.add(jpfContrasena);
		
		add(panelCentro, BorderLayout.CENTER);
	}
	
	public void crearPanelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		panelInferior.add(btnIniciarSesion);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		JButton btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		
		add(panelInferior, BorderLayout.SOUTH);
	}
	



}
