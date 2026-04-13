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
	JButton btnIniciarSesion;
	JButton btnRegister;
	
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
		
		btnIniciarSesion = new JButton("Ingresar");
		
		btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelInferior.add(btnIniciarSesion);
		
		window.getRootPane().setDefaultButton(btnIniciarSesion);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		btnRegister = new JButton("Registrate");
		
		btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelInferior.add(btnRegister);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(jpfContrasena, "DOWN", "aIniciar", btnIniciarSesion);
		SwingUtils.moveFocus(btnIniciarSesion, "UP", "aPassword", jpfContrasena);
		SwingUtils.moveFocus(btnIniciarSesion, "RIGHT", "aRegistrar", btnRegister);
		SwingUtils.moveFocus(btnRegister, "LEFT", "aIniciar", btnIniciarSesion);
		SwingUtils.moveFocus(btnRegister, "UP", "aPassword", jpfContrasena);
		
	}
	
	public void showEmailError(String message) {
		lblErrorEmail.setText(message);
	}
	
	public void showPasswordError(String message) {
		lblErrorPassword.setText(message);
	}
	
	public void resetMessages() {
		lblErrorEmail.setText("");
		lblErrorPassword.setText("");
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getJpfContrasena() {
		return jpfContrasena;
	}

	public void setJpfContrasena(JPasswordField jpfContrasena) {
		this.jpfContrasena = jpfContrasena;
	}

	public JLabel getLblErrorEmail() {
		return lblErrorEmail;
	}

	public void setLblErrorEmail(JLabel lblErrorEmail) {
		this.lblErrorEmail = lblErrorEmail;
	}

	public JLabel getLblErrorPassword() {
		return lblErrorPassword;
	}

	public void setLblErrorPassword(JLabel lblErrorPassword) {
		this.lblErrorPassword = lblErrorPassword;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public LoginWindow getWindow() {
		return window;
	}

	public void setWindow(LoginWindow window) {
		this.window = window;
	}

}
