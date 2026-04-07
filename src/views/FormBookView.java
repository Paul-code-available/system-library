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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class FormBookView extends JPanel {
	
	
	JTextField txtNombre;
	JTextField txtAutor;
	JTextField txtEditorial;
	JTextField txtAnio;
	JTextField txtGenero;
	JTextField txtIdioma;
	JTextField txtNumPaginas;
	JButton btnAgregar;
	JButton btnCancelar;
	
	JLabel lblErrorNombre;
	JLabel lblErrorAutor;
	JLabel lblErrorEditorial;
	JLabel lblErrorAnio;
	JLabel lblErrorNumPaginas;
	
	
	public FormBookView() {
		
		setLayout(new BorderLayout());
		
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		UIManager.put("TextComponent.arc", 15);
		UIManager.put("Button.arc", 10);
	
		panelSuperior();
		
		panelCentro();
		
		panelInferior();
		
		assingListeners();
		
	}
	
	public void panelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
	
		JLabel lblTitulo = new JLabel("Nuevo Libro");
		lblTitulo.setFont(AppFont.title());
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitulo);
		
		add(panelSuperior, BorderLayout.NORTH);
		
	}
	
	public void panelCentro() {
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		txtNombre = SwingUtils.crearJtfText("Nombre");
		panelCentro.add(txtNombre);
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorNombre = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorNombre);
		
		txtAutor = SwingUtils.crearJtfText("Autor");
		panelCentro.add(txtAutor);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorAutor = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorAutor);
		
		txtEditorial = SwingUtils.crearJtfText("Editorial");
		panelCentro.add(txtEditorial);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorEditorial = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorEditorial);
		
		txtAnio = SwingUtils.crearJtfText("Año de publicación");
		panelCentro.add(txtAnio);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorAnio = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorAnio);
		
		txtGenero = SwingUtils.crearJtfText("Género");
		panelCentro.add(txtGenero);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtIdioma = SwingUtils.crearJtfText("Idioma");
		panelCentro.add(txtIdioma);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtNumPaginas = SwingUtils.crearJtfText("Número de páginas");
		panelCentro.add(txtNumPaginas);	
		
		lblErrorNumPaginas = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorNumPaginas);
		
		add(panelCentro, BorderLayout.CENTER);
		
		SwingUtils.moveFocus(txtNombre, "DOWN", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtAutor, "UP", "aNombre", txtNombre);
		SwingUtils.moveFocus(txtAutor, "DOWN", "aEditorial", txtEditorial);
		SwingUtils.moveFocus(txtEditorial, "UP", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtEditorial, "DOWN", "aAño", txtAnio);
		SwingUtils.moveFocus(txtAnio, "UP", "aEditorial", txtEditorial);
		SwingUtils.moveFocus(txtAnio, "DOWN", "aGenero", txtGenero);
		SwingUtils.moveFocus(txtGenero, "UP", "aAño", txtAnio);
		SwingUtils.moveFocus(txtGenero, "DOWN", "aIdioma", txtIdioma);
		SwingUtils.moveFocus(txtIdioma, "UP", "aGenero", txtGenero);
		SwingUtils.moveFocus(txtIdioma, "DOWN", "aNPaginas", txtNumPaginas);
		SwingUtils.moveFocus(txtNumPaginas, "UP", "aIdioma", txtIdioma);
		
	}
	
	public void panelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		btnAgregar = new JButton("Agregar");
		panelInferior.add(btnAgregar);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(txtNumPaginas, "DOWN", "aRegistrar", btnAgregar);
		SwingUtils.moveFocus(btnAgregar, "UP", "aNPaginas", txtNumPaginas);
		SwingUtils.moveFocus(btnAgregar, "RIGHT", "aCancelar", btnCancelar);
		SwingUtils.moveFocus(btnCancelar, "LEFT", "aRegistar", btnAgregar);
		SwingUtils.moveFocus(btnCancelar, "UP", "aNPaginas", txtNumPaginas);
		
	}
	
	public void assingListeners() {
		txtNombre.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validarNombre();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				validarNombre();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				validarNombre();
				
			}
		});
		
			txtAutor.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				validarAutor();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				validarAutor();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				validarAutor();
				
			}
		});
	}
	
	public boolean validateForm() {
		boolean valid = true;
		
		if (!validarNombre()) {
			valid = false;
		}
		
		if (!validarAutor()) {
			valid = false;
		}
		
		return valid;
	}
	
	public boolean validarNombre() {
		if (txtNombre.getText().isBlank()) {
			lblErrorNombre.setText("El nombre es requerido");
			return false;
		}
		
		if (txtNombre.getText().trim().length() < 2) {
			lblErrorNombre.setText("El limite minimo es de 2 caracteres");
			return false;
		}
		
		if (txtNombre.getText().trim().length() > 70) {
			lblErrorNombre.setText("El limite maximo es de 70 caracteres");
			return false;
		}
		
		if (!(txtNombre.getText().matches("^[^!$%#&]*$"))) {
			lblErrorNombre.setText("Caracteres invalidos: ^!$%#");
			return false;
		}
		
		lblErrorNombre.setText("");
		
		return true;
		
	}
	
	public boolean validarAutor() {
		if (txtAutor.getText().isBlank()) {
			lblErrorNombre.setText("El autor es requerido");
			return false;
		}
		
		if (!txtAutor.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
			lblErrorAutor.setText("Solo se permite letras y espacios");
			return false;
		}
		
		if (txtNombre.getText().trim().length() < 2) {
			lblErrorNombre.setText("El limite minimo es de 3 caracteres");
			return false;
		}
		
		if (txtNombre.getText().trim().length() > 70) {
			lblErrorNombre.setText("El limite maximo es de 50 caracteres");
			return false;
		}
		
		lblErrorAutor.setText("");
		
		return true;
	}
	
}