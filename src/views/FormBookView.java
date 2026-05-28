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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import views.components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class FormBookView extends JDialog {
	
	JTextField txtTitle;
	JTextField txtAutor;
	JTextField txtCategory;
	JTextField txtPages;
	JTextField txtPublishYear;
	JTextField txtLanguage;
	JTextField txtAvailableBooks;
	JTextField txtTotalBooks;
	JTextField txtIsbn;
	JTextField txtCoverPath;
	JTextField txtPublisher;
	JTextArea txtDescription;
	
	JButton btnAgregar;
	JButton btnCancelar;
	
	JLabel lblErrorTitle;
	JLabel lblErrorAutor;
	JLabel lblErrorCategory;
	JLabel lblErrorPages;
	JLabel lblErrorAvailableBooks;
	
	JPanel mainPanel;
	
	public FormBookView(JFrame parent) {
		super(parent);
				
		setSize(360, 740);

		setLocationRelativeTo(parent);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
		mainPanel.setBackground(Color.decode("#0F1524"));

		add(mainPanel);
		
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
		panelSuperior.setBackground(Color.decode("#0F1524"));
	
		JLabel lblTitulo = new JLabel("Nuevo Libro");
		
		lblTitulo.setFont(AppFont.title());
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitulo);
		
		mainPanel.add(panelSuperior, BorderLayout.NORTH);
		
	}
	
	public void panelCentro() {
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		panelCentro.setBackground(Color.decode("#0F1524"));
		
		txtTitle = SwingUtils.crearJtfText("Titulo");

		panelCentro.add(txtTitle);
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorTitle = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorTitle);
		
		txtAutor = SwingUtils.crearJtfText("Autor");
		panelCentro.add(txtAutor);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorAutor = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorAutor);
		
		txtCategory = SwingUtils.crearJtfText("Categoria");
		panelCentro.add(txtCategory);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		lblErrorCategory = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorCategory);
		
		txtPages = SwingUtils.crearJtfText("Número de paginas");
		panelCentro.add(txtPages);
		
		lblErrorPages = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorPages);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtPublishYear = SwingUtils.crearJtfText("Año de publicación");
		panelCentro.add(txtPublishYear);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtLanguage = SwingUtils.crearJtfText("Lenguaje");
		panelCentro.add(txtLanguage);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		
		
		txtAvailableBooks = SwingUtils.crearJtfText("Libros disponibles");
		panelCentro.add(txtAvailableBooks);	
		
		lblErrorAvailableBooks = SwingUtils.createLblMessageError();
		panelCentro.add(lblErrorAvailableBooks);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtTotalBooks = SwingUtils.crearJtfText("Total de libros");
		panelCentro.add(txtTotalBooks);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtIsbn = SwingUtils.crearJtfText("Código isbn");
		panelCentro.add(txtIsbn);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtCoverPath = SwingUtils.crearJtfText("Dirección portada");
		panelCentro.add(txtCoverPath);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtPublisher = SwingUtils.crearJtfText("Publisher");
		panelCentro.add(txtPublisher);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtDescription = new JTextArea();
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setBackground(Color.decode("#141D30"));
		
		TextPrompt promptNombre = new TextPrompt("Descripción", txtDescription);

		JScrollPane scroll = new JScrollPane(txtDescription);
		scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		
		
		panelCentro.add(scroll);
		
		mainPanel.add(panelCentro, BorderLayout.CENTER);
		
		SwingUtils.moveFocus(txtTitle, "DOWN", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtAutor, "UP", "aNombre", txtTitle);
		SwingUtils.moveFocus(txtAutor, "DOWN", "aEditorial", txtCategory);
		SwingUtils.moveFocus(txtCategory, "UP", "aAutor", txtAutor);
		SwingUtils.moveFocus(txtCategory, "DOWN", "aAño", txtPages);
		SwingUtils.moveFocus(txtPages, "UP", "aEditorial", txtCategory);
		SwingUtils.moveFocus(txtPages, "DOWN", "aGenero", txtPublishYear);
		SwingUtils.moveFocus(txtPublishYear, "UP", "aAño", txtPages);
		SwingUtils.moveFocus(txtPublishYear, "DOWN", "aIdioma", txtLanguage);
		SwingUtils.moveFocus(txtLanguage, "UP", "aGenero", txtPublishYear);
		SwingUtils.moveFocus(txtLanguage, "DOWN", "aNPaginas", txtAvailableBooks);
		SwingUtils.moveFocus(txtAvailableBooks, "UP", "aIdioma", txtLanguage);
		
	}
	
	public void panelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelInferior.setBackground(Color.decode("#0F1524"));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		btnAgregar = new JButton("Agregar");
		panelInferior.add(btnAgregar);
		
		panelInferior.add(Box.createHorizontalStrut(10));
		
		btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		mainPanel.add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(txtAvailableBooks, "DOWN", "aRegistrar", btnAgregar);
		SwingUtils.moveFocus(btnAgregar, "UP", "aNPaginas", txtAvailableBooks);
		SwingUtils.moveFocus(btnAgregar, "RIGHT", "aCancelar", btnCancelar);
		SwingUtils.moveFocus(btnCancelar, "LEFT", "aRegistar", btnAgregar);
		SwingUtils.moveFocus(btnCancelar, "UP", "aNPaginas", txtAvailableBooks);
		
	}
	
	public void assingListeners() {
		txtTitle.getDocument().addDocumentListener(new DocumentListener() {
			
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
		if (txtTitle.getText().isBlank()) {
			lblErrorTitle.setText("El nombre es requerido");
			return false;
		}
		
		if (txtTitle.getText().trim().length() < 2) {
			lblErrorTitle.setText("El limite minimo es de 2 caracteres");
			return false;
		}
		
		if (txtTitle.getText().trim().length() > 70) {
			lblErrorTitle.setText("El limite maximo es de 70 caracteres");
			return false;
		}
		
		if (!(txtTitle.getText().matches("^[^!$%#&]*$"))) {
			lblErrorTitle.setText("Caracteres invalidos: ^!$%#");
			return false;
		}
		
		lblErrorTitle.setText("");
		
		return true;
		
	}
	
	public boolean validarAutor() {
		if (txtAutor.getText().isBlank()) {
			lblErrorTitle.setText("El autor es requerido");
			return false;
		}
		
		if (!txtAutor.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
			lblErrorAutor.setText("Solo se permite letras y espacios");
			return false;
		}
		
		if (txtTitle.getText().trim().length() < 2) {
			lblErrorTitle.setText("El limite minimo es de 3 caracteres");
			return false;
		}
		
		if (txtTitle.getText().trim().length() > 70) {
			lblErrorTitle.setText("El limite maximo es de 50 caracteres");
			return false;
		}
		
		lblErrorAutor.setText("");
		
		return true;
	}
	
}