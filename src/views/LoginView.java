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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		UIManager.put("TextComponent.arc", 10);
		UIManager.put("Button.arc", 10);
		
		crearPanelSuperior();
		
		crearPanelCentro();
		
		crearPanelInferior();
	
		assignListeners();
		
	}
	
	public void crearPanelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = SwingUtils.createLblTitle("Iniciar Sesión");
		panelSuperior.add(lblTitle);
		
		panelSuperior.add(Box.createVerticalStrut(10));
		
		add(panelSuperior, BorderLayout.NORTH);
	}
	
	
	public void crearPanelCentro() { 
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		txtEmail = SwingUtils.crearJtfText("Email");
		panelCentro.add(txtEmail);
		
		lblErrorEmail = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorEmail);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		jpfContrasena = SwingUtils.createJpfPassword("Contraseña"); 
		panelCentro.add(jpfContrasena);
		
		lblErrorPassword = SwingUtils.createLblMessageError();
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
		if (validateLogin()) {
			new mainWindow();
			window.dispose();
		}
		
	}
	
	public void handleRegistration() {
		new FormUserWindow();
		window.dispose();
	}
	
	private void assignListeners() {
		
		txtEmail.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validateEmail();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				 validateEmail();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
 				validateEmail();
			}
			
		});
		
		jpfContrasena.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validatePassword();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				validatePassword();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				validatePassword();
			}
			
		});
		
	}
	
	
	private boolean validateLogin() {
		
		boolean valid = true;
		
		if (!validateEmail()) {
			valid = false;
		}
		
		if (!validatePassword()) {
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

		lblErrorEmail.setText("");
		
		return true;
		
	}
	
	private boolean validatePassword() {
		
		String contrasena = String.valueOf(jpfContrasena.getPassword()).trim();
		
		if (contrasena.isEmpty()) {
			lblErrorPassword.setText("La contraseña es requerida");
			return false;
		}
		
		// metodo que valida si la contraseña coicide
		
		lblErrorPassword.setText("");
		
		return true;
		
	}
	



}
