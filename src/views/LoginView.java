package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.TextPrompt;
import excepciones.InvalidPasswordException;
import excepciones.InvalidUserException;
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
		
		UIManager.put("TextComponent.arc", 15);
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
		
		panelSuperior.add(Box.createVerticalStrut(15));
		
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

        panelCentro.add(Box.createVerticalStrut(10));
		
		add(panelCentro, BorderLayout.CENTER);
		
		SwingUtils.moveFocus(txtEmail, "DOWN", "aPassword", jpfContrasena);
		SwingUtils.moveFocus(jpfContrasena, "UP", "aEmail", txtEmail);
		
	}
	
	public void crearPanelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.addActionListener(e -> {
			try {
				handleLogin();
			} catch (InvalidUserException e1) {
				lblErrorEmail.setText("Correo no registrado");
			} catch (InvalidPasswordException e2) {
				lblErrorPassword.setText("Contraseña incorrecta");
			}
		});
		btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelInferior.add(btnIniciarSesion);
		
		window.getRootPane().setDefaultButton(btnIniciarSesion);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		JButton btnRegister = new JButton("Registrate");
		btnRegister.addActionListener(e -> handleRegistration());
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelInferior.add(btnRegister);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(jpfContrasena, "DOWN", "aIniciar", btnIniciarSesion);
		SwingUtils.moveFocus(btnIniciarSesion, "UP", "aPassword", jpfContrasena);
		SwingUtils.moveFocus(btnIniciarSesion, "RIGHT", "aRegistrar", btnRegister);
		SwingUtils.moveFocus(btnRegister, "LEFT", "aIniciar", btnIniciarSesion);
		SwingUtils.moveFocus(btnRegister, "UP", "aPassword", jpfContrasena);
		
	}
	
	public void handleLogin() throws InvalidUserException, InvalidPasswordException {
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
				try {
					validateEmail();
				} catch (InvalidUserException e1) {
					
				}				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				 try {
					validateEmail();
				 } catch (InvalidUserException e1) {
					
				 }
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
 				try {
					validateEmail();
				} catch (InvalidUserException e1) {
					
				}
			}
			
		});
		
		jpfContrasena.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					validatePassword();
				} catch (InvalidPasswordException e1) {
				
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					validatePassword();
				} catch (InvalidPasswordException e1) {
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					validatePassword();
				} catch (InvalidPasswordException e1) {
					
				}
			}
			
		});
		
	}
	
	
	
	
	private boolean validateLogin() throws InvalidUserException, InvalidPasswordException {
		
		boolean valid = true;
		
		if (!validateEmail()) {
			valid = false;
		}
		
		if (!validatePassword()) {
			valid = false;
		}
		
		return valid;
		
	}
	
	private boolean validateEmail() throws InvalidUserException {
		
		if (txtEmail.getText().trim().isEmpty()) {
			lblErrorEmail.setText("El email es requerido");
			return false;
		}
		
		if (txtEmail.getText().trim().length() > 30) {
			lblErrorEmail.setText("Longitud maxíma alcanzada");
			return false;
		}
		
		if (!txtEmail.getText().contains("@")) {
			lblErrorEmail.setText("Falta '@' en el email");
			return false;
		}
		
		lblErrorEmail.setText("");
		
		if (!txtEmail.getText().equals("juanitoalcachofa123@gmail.com")) {
			throw new InvalidUserException("Usuario no registrado");
		}

		lblErrorEmail.setText("");
		
		return true;
		
	}
	
	private boolean validatePassword() throws InvalidPasswordException {
		
		String contrasena = String.valueOf(jpfContrasena.getPassword()).trim();
		
		if (contrasena.isEmpty()) {
			lblErrorPassword.setText("La contraseña es requerida");
			return false;
		}
		
		if (contrasena.length() > 20) {
			lblErrorPassword.setText("Longitud maxíma alcanzada");
			return false;
		}
		
		lblErrorPassword.setText("");
		
		if (!contrasena.equals("1234")) {
			throw new InvalidPasswordException("Contraseña incorrecta");
		}
		
		lblErrorPassword.setText("");
		
		return true;
		
	}
	



}
