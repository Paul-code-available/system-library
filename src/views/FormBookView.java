package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
import utils.AppFont;
import utils.SwingUtils;

public class FormBookView extends JPanel {
	
	public FormBookView() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
		panelSuperior();
		
		panelCentro();
		
		panelInferior();
		
	}
	
	public void panelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
	
		JLabel lblTitulo = new JLabel("Registro");
		lblTitulo.setFont(AppFont.title());
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitulo);
		
		add(panelSuperior, BorderLayout.NORTH);
		
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
		
		add(panelCentro, BorderLayout.CENTER);
	}
	
	public void panelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		JButton btnRegistrarse = new JButton("Registrar");
		panelInferior.add(btnRegistrarse);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		JButton btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		add(panelInferior, BorderLayout.SOUTH);
		
	}
	
	
	
	
	
	
	
	
}