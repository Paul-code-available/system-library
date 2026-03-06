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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

import components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class LoginView extends JPanel {
	
	JTextField txtEmail;
	JPasswordField jpfContrasena;
	JLabel lblErrorEmail;
	JLabel lblErrorPassword;
	
	LoginWindow window;
	
	public LoginView(LoginWindow window) {
		this.window = window;
		
		setLayout(new BorderLayout());
		Border emptyBorder = BorderFactory.createEmptyBorder(20,20,20,20);
		setBorder(emptyBorder);
		
		UIManager.put("TextComponent.arc", 10);
		UIManager.put("Button.arc", 10);
		
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
		txtEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
		panelCentro.add(txtEmail);
		
		lblErrorEmail = new JLabel();
		lblErrorEmail.setFont(AppFont.small());
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblErrorEmail.setVisible(false);
		panelCentro.add(lblErrorEmail);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		jpfContrasena = new JPasswordField(); 
		jpfContrasena.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		jpfContrasena.setAlignmentX(Component.LEFT_ALIGNMENT);
		TextPrompt promptContrasena = new TextPrompt("Contraseña", jpfContrasena);
		panelCentro.add(jpfContrasena);
		
		lblErrorPassword = new JLabel();
		lblErrorPassword.setFont(AppFont.small());
		lblErrorPassword.setForeground(Color.RED);
		lblErrorPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		lblErrorPassword.setVisible(false);
		panelCentro.add(lblErrorPassword);
		
		add(panelCentro, BorderLayout.CENTER);
	}
	
	public void crearPanelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.addActionListener(e -> handleLogin());
		
		panelInferior.add(btnIniciarSesion);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		JButton btnRegister = new JButton("Registrarte");
		btnRegister.addActionListener(e -> handleRegistration());
		panelInferior.add(btnRegister);
		
		
		add(panelInferior, BorderLayout.SOUTH);
	}
	
	public void handleLogin() {
		
		if (validateForm()) {
			new mainWindow();
			window.dispose();
		}
		
	}
	
	public void handleRegistration() {
		new FormularioWindowUsuario();
		window.dispose();
	}
	
	
	private boolean validateForm() {
		
		resetMensajeError();
		
		boolean valid = true;
		
		if (!validateEmail()) {
			mostrarErrorCorreo();
			valid = false;
		}
		
		if (!validatePassword()) {
			mostrarErrorContrasena();
			valid = false;
		}
		
		return valid;
		
	}
	
	private boolean validateEmail() {
		
		if (txtEmail.getText().trim().isEmpty()) {
			lblErrorEmail.setText("El email es requerido");
			return false;
		}
		
		if (!txtEmail.getText().contains("@")) {
			lblErrorEmail.setText("Falta '@' en el email");
			return false;
		}

		return true;
		
	}
	
	private boolean validatePassword() {
		
		if (String.valueOf(jpfContrasena.getPassword()).trim().isEmpty()) {
			lblErrorPassword.setText("La contraseña es requerida");
			return false;
		}
		
		return true;
		
	}
	
	private void mostrarErrorCorreo() {
		lblErrorEmail.setVisible(true);
	}
	
	private void mostrarErrorContrasena() {
		lblErrorPassword.setVisible(true);
	}
	
	private void resetMensajeError() {
		lblErrorEmail.setText("");
		lblErrorPassword.setText("");
	}



}
