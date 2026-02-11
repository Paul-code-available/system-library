package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginView extends JFrame {

	Font fuente;
	
	public LoginView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		
		fuente = new Font("Arial", Font.PLAIN, 14);
		setLayout(null);
		
		inicializarComponentes();

	}
	
	private void inicializarComponentes() {
		crearBotones();
		crearFormulario();
	}
	
	private void crearBotones() {
		
		JButton boton = new JButton("Iniciar sesión");
		boton.setBounds(250, 10, 117, 25);
		boton.setFont(fuente);
		
		add(boton);
	
	}
	
	private void crearFormulario() {
		JLabel lblSaludo = new JLabel("Bienvenido!");
		lblSaludo.setFont(fuente);
		lblSaludo.setBounds(10, 0, 200, 40);
		add(lblSaludo);
		
		int lblX = 10, y = 170, txtX = 100;
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(fuente);
		lblEmail.setBounds(lblX, y, 200, 40);
		add(lblEmail);
		
		JTextField txtEmail = new JTextField();
		txtEmail.setFont(fuente);
		txtEmail.setBounds(txtX, y, 200, 40);
		add(txtEmail);
		
		JLabel lblEmailRequerido = new JLabel("El email es requerido.");
		lblEmailRequerido.setBounds(txtX, y+30, 200, 30);
		lblEmailRequerido.setFont(new Font("Arial", Font.BOLD, 10));
		lblEmailRequerido.setForeground(Color.RED);
		add(lblEmailRequerido);

		y += 70;
		
		JLabel lblContrasena = new JLabel("Contraseña: ");
		lblContrasena.setFont(fuente);
		lblContrasena.setBounds(lblX, y, 200, 40);
		add(lblContrasena);
		
		JPasswordField contrasena = new JPasswordField();
		contrasena.setFont(fuente);
		contrasena.setBounds(txtX, y, 200, 40);
		add(contrasena);
		
		JLabel lblContrasenaRequerida = new JLabel("La contraseña es requerida.");
		lblContrasenaRequerida.setBounds(txtX, y+30, 200, 30);
		lblContrasenaRequerida.setFont(new Font("Arial", Font.BOLD, 10));
		lblContrasenaRequerida.setForeground(Color.RED);
		add(lblContrasenaRequerida);
		
	}
	
	
	
	
	
}
