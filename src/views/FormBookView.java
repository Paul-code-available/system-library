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

public class FormBookView extends JPanel {
	
	public FormBookView() {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		
		JLabel lblTitulo = new JLabel("Registro");

		add(lblTitulo, BorderLayout.NORTH);
		
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		
		JTextField txtNombre = new JTextField();
		txtNombre.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		TextPrompt promptLibro = new TextPrompt("Nombre del libro", txtNombre);
		
		panelComponentes.add(txtNombre);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtAutor = new JTextField(60);
		txtAutor.setMaximumSize(txtAutor.getPreferredSize());
		TextPrompt promptAutor = new TextPrompt("Autor", txtAutor);
		panelComponentes.add(txtAutor);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtEditorial = new JTextField(60);
		txtEditorial.setMaximumSize(txtEditorial.getPreferredSize());
		TextPrompt promptEditorial = new TextPrompt("Editorial", txtEditorial);
		panelComponentes.add(txtEditorial);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtAnioPublicacion = new JTextField(60);
		txtAnioPublicacion.setMaximumSize(txtAnioPublicacion.getPreferredSize());
		TextPrompt promptAnioPublicacion = new TextPrompt("Año de publicación", txtAnioPublicacion);
		panelComponentes.add(txtAnioPublicacion);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtGenero = new JTextField(60);
		txtGenero.setMaximumSize(txtGenero.getPreferredSize());
		TextPrompt promptGenero = new TextPrompt("Género", txtGenero);
		panelComponentes.add(txtGenero);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtIdioma = new JTextField(60);
		txtIdioma.setMaximumSize(txtIdioma.getPreferredSize());
		TextPrompt promptIdioma = new TextPrompt("Idioma", txtIdioma);
		panelComponentes.add(txtIdioma);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JTextField txtNumPaginas = new JTextField(60);
		txtNumPaginas.setMaximumSize(txtNumPaginas.getPreferredSize());
		TextPrompt promptNumPaginas = new TextPrompt("Número de páginas", txtNumPaginas);
		panelComponentes.add(txtNumPaginas);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelComponentes.add(btnRegistrarse);
		
		
		add(panelComponentes);
	}
	
}