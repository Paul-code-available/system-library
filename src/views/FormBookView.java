package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class FormBookView extends JPanel {
	
	
	JTextField txtNombre;
	JTextField txtAutor;
	JTextField txtEditorial;
	JTextField txtAnioPublicacion;
	JTextField txtGenero;
	JTextField txtIdioma;
	JTextField txtNumPaginas;
	JButton btnRegistrarse;
	JButton btnCancelar;
	
	public FormBookView() {
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("Button.arc", 10);
	
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
		
		txtNombre = SwingUtils.crearJtfText("Nombre del libro");
		panelCentro.add(txtNombre);
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtAutor = SwingUtils.crearJtfText("Autor");
		panelCentro.add(txtAutor);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtEditorial = SwingUtils.crearJtfText("Editorial");
		panelCentro.add(txtEditorial);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtAnioPublicacion = SwingUtils.crearJtfText("Año de publicación");
		panelCentro.add(txtAnioPublicacion);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtGenero = SwingUtils.crearJtfText("Género");
		panelCentro.add(txtGenero);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtIdioma = SwingUtils.crearJtfText("Idioma");
		panelCentro.add(txtIdioma);
		
		panelCentro.add(Box.createRigidArea(new Dimension(10, 10)));
		
		txtNumPaginas = SwingUtils.crearJtfText("Número de páginas");
		panelCentro.add(txtNumPaginas);	
		
		add(panelCentro, BorderLayout.CENTER);
		
		SwingUtils.moveFocus(txtNombre, "DOWN", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtAutor, "UP", "aNombre", txtNombre);
		SwingUtils.moveFocus(txtAutor, "DOWN", "aEditorial", txtEditorial);
		SwingUtils.moveFocus(txtEditorial, "UP", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtEditorial, "DOWN", "aAño", txtAnioPublicacion);
		SwingUtils.moveFocus(txtAnioPublicacion, "UP", "aEditorial", txtEditorial);
		SwingUtils.moveFocus(txtAnioPublicacion, "DOWN", "aGenero", txtGenero);
		SwingUtils.moveFocus(txtGenero, "UP", "aAño", txtAnioPublicacion);
		SwingUtils.moveFocus(txtGenero, "DOWN", "aIdioma", txtIdioma);
		SwingUtils.moveFocus(txtIdioma, "UP", "aGenero", txtGenero);
		SwingUtils.moveFocus(txtIdioma, "DOWN", "aNPaginas", txtNumPaginas);
		SwingUtils.moveFocus(txtNumPaginas, "UP", "aIdioma", txtIdioma);
		
	}
	
	public void panelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		btnRegistrarse = new JButton("Registrar");
		panelInferior.add(btnRegistrarse);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(txtNumPaginas, "DOWN", "aRegistrar", btnRegistrarse);
		SwingUtils.moveFocus(btnRegistrarse, "UP", "aNPaginas", txtNumPaginas);
		SwingUtils.moveFocus(btnRegistrarse, "RIGHT", "aCancelar", btnCancelar);
		SwingUtils.moveFocus(btnCancelar, "LEFT", "aRegistar", btnRegistrarse);
		SwingUtils.moveFocus(btnCancelar, "UP", "aNPaginas", txtNumPaginas);
		
		
	}
	
	
	
	
	
	
	
	
}