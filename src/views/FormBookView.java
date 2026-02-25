package views;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelComponentes = new JPanel();
		panelComponentes.setLayout(new BoxLayout(panelComponentes, BoxLayout.Y_AXIS));
		panelComponentes.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		JLabel lblTituloLibro = new JLabel("Nombre del libro: ");
		
		panelComponentes.add(lblTituloLibro);
		
		JTextField txtTituloLibro = new JTextField(60);
		txtTituloLibro.setMaximumSize(txtTituloLibro.getPreferredSize());
		TextPrompt promptLibro = new TextPrompt("Nombre del Libro", txtTituloLibro);
		panelComponentes.add(txtTituloLibro);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JLabel lblAutor = new JLabel("Autor: ");
		panelComponentes.add(lblAutor);
		
		JTextField txtAutor = new JTextField(60);
		txtAutor.setMaximumSize(txtAutor.getPreferredSize());
		panelComponentes.add(txtAutor);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		JLabel lblFechaPublicacion = new JLabel("Fecha de publicación: ");
		panelComponentes.add(lblFechaPublicacion);
		
		JTextField txtFechaPublicacion = new JTextField(60);
		txtFechaPublicacion.setMaximumSize(txtFechaPublicacion.getPreferredSize());
		panelComponentes.add(txtFechaPublicacion);
		
		panelComponentes.add(Box.createRigidArea(new Dimension(10, 10)));
		
		
		
		
		add(panelComponentes);
	}
	
}