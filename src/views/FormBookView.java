package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import components.TextPrompt;
import utils.SwingUtils;

public class FormBookView extends JPanel {
	
	public FormBookView() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
		panelSuperior();
		
		panelCentro();
		
	}
	
	public void panelSuperior() {
		JLabel lblTitulo = new JLabel("Registro");
		add(lblTitulo, BorderLayout.NORTH);
	}
	
	public void panelCentro() {
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JTextField txtNombre = SwingUtils.crearJtf(0, 30, "Nombre del libro");
		panelCentro.add(txtNombre);
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtAutor = SwingUtils.crearJtf(0, 30, "Autor");
		panelCentro.add(txtAutor);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtEditorial = SwingUtils.crearJtf(0, 30, "Editorial");
		panelCentro.add(txtEditorial);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtAnioPublicacion = SwingUtils.crearJtf(0, 30, "Año de publicación");
		panelCentro.add(txtAnioPublicacion);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtGenero = SwingUtils.crearJtf(0, 30, "Género");
		panelCentro.add(txtGenero);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtIdioma = SwingUtils.crearJtf(0, 30, "Idioma");
		panelCentro.add(txtIdioma);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtNumPaginas = SwingUtils.crearJtf(0, 30, "Número de páginas");
		panelCentro.add(txtNumPaginas);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelCentro.add(btnRegistrarse);
		
		
		add(panelCentro);
	}
	
}