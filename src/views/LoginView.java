package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class LoginView extends JPanel {
	
	JTextField txtEmail;
	JPasswordField jpfContrasena;
	JLabel lblEmailRequerido;
	JLabel lblContrasenaRequerida;
	
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
		lblTitle.setFont(AppFont.title());
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitle);
		
		add(panelSuperior, BorderLayout.NORTH);
	}
	
	
	public void crearPanelCentro() { 
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		txtEmail = SwingUtils.crearJtf(0, 30, "Email");
		panelCentro.add(txtEmail);
		
		lblEmailRequerido = new JLabel("El email es requerido");
		lblEmailRequerido.setForeground(Color.RED);
		lblEmailRequerido.setVisible(false);
		panelCentro.add(lblEmailRequerido);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		jpfContrasena = new JPasswordField(); 
		jpfContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		TextPrompt promptContrasena = new TextPrompt("Contraseña", jpfContrasena);
		panelCentro.add(jpfContrasena);
		
		lblContrasenaRequerida = new JLabel("La contraseña es requerida");
		lblContrasenaRequerida.setForeground(Color.RED);
		lblContrasenaRequerida.setVisible(false);
		panelCentro.add(lblContrasenaRequerida);
		
		add(panelCentro, BorderLayout.CENTER);
	}
	
	public void crearPanelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.addActionListener(e -> {	
			login();
		});
		
		panelInferior.add(btnIniciarSesion);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		JButton btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		
		add(panelInferior, BorderLayout.SOUTH);
	}
	
	private void login() {
		validateLogin(txtEmail.getText(), String.valueOf(jpfContrasena.getPassword()));
	}
	
	private boolean validateLogin(String email, String password) {
			
		if (email.trim().isEmpty()) {
			mostrarErrorCorreo();
			return false;
		}
		
		if (password.trim().isEmpty()) {
			mostrarErrorContrasena();
			return false;
		}
		
		return true;
		
	}
	
	private void mostrarErrorCorreo() {
		lblEmailRequerido.setVisible(true);
	}
	
	private void mostrarErrorContrasena() {
		lblContrasenaRequerida.setVisible(true);
	}
	
	private void resetMensajeError() {
		lblEmailRequerido.setText("");
	}



}
