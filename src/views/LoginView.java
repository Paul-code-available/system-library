package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
	}
	
	private void crearBotones() {
		
		JButton boton = new JButton("Iniciar sesión");
		boton.setBounds(140, 200, 120, 25);
		boton.setFont(fuente);
		
		add(boton);
	
	}
	
	
	
	
	
}
