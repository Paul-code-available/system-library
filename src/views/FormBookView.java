package views;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import models.Book;
import models.Categoria;
import repository.CategoriaRepository;
import views.components.TextPrompt;
import utils.AppFont;
import utils.SwingUtils;

public class FormBookView extends JDialog {
	
	JTextField txtTitle;
	JTextField txtAutor;
	JComboBox<Categoria> cmbCategory;
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
	
	Book book;
	private boolean saved = false;
	
	public FormBookView(JFrame parent, Book book) {
		super(parent,true);
		
		this.book = book;
				
		setSize(360, 740);
		
		setTitle(book == null ? "Agregar libro" : "Editar libro");

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
		
		loadCategories();
		loadData();
		
	}
	
	public void panelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		panelSuperior.setBackground(Color.decode("#0F1524"));
		
		JLabel lblTitulo = new JLabel("Formulario");
		
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
		
		cmbCategory = new JComboBox<>(); 
		cmbCategory.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		cmbCategory.setBackground(Color.decode("#141D30"));
		
		panelCentro.add(cmbCategory);
		
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
		
		TextPrompt promptNombre = new TextPrompt("Descripcin", txtDescription);

		JScrollPane scroll = new JScrollPane(txtDescription);
		scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
		
		
		panelCentro.add(scroll);
		
		mainPanel.add(panelCentro, BorderLayout.CENTER);
		/*
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
		*/
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
		
		btnAgregar.addActionListener(e -> handleRegister());
		btnCancelar.addActionListener(e -> dispose());
		
		mainPanel.add(panelInferior, BorderLayout.SOUTH);
		
		SwingUtils.moveFocus(txtAvailableBooks, "DOWN", "aRegistrar", btnAgregar);
		SwingUtils.moveFocus(btnAgregar, "UP", "aNPaginas", txtAvailableBooks);
		SwingUtils.moveFocus(btnAgregar, "RIGHT", "aCancelar", btnCancelar);
		SwingUtils.moveFocus(btnCancelar, "LEFT", "aRegistar", btnAgregar);
		SwingUtils.moveFocus(btnCancelar, "UP", "aNPaginas", txtAvailableBooks);
		
	}
	
	public void handleRegister() {
		    
		   try {
			
			   if (!validateForm()) {
				   return;
			   }
			   
			   save();
			  
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void save() {

	    String title = txtTitle.getText();
	    String author = txtAutor.getText();

	    Categoria category =
	            (Categoria) cmbCategory.getSelectedItem();

	    int pages = Integer.parseInt(txtPages.getText());

	    int publishYear = Integer.parseInt(txtPublishYear.getText());

	    String language = txtLanguage.getText();

	    int availableBooks = Integer.parseInt(txtAvailableBooks.getText());

	    int totalBooks = Integer.parseInt( txtTotalBooks.getText());

	    String isbn = txtIsbn.getText();

	    String coverPath = txtCoverPath.getText();

	    String publisher = txtPublisher.getText();

	    String description = txtDescription.getText();

	    if (book == null) {
	    	  book = new Book(
	  	            title,
	  	            author,
	  	            category,
	  	            pages,
	  	            publishYear,
	  	            language,
	  	            availableBooks,
	  	            totalBooks,
	  	            isbn,
	  	            coverPath,
	  	            publisher,
	  	            description
	  	    );
		} else {

		    book.setTitle(title);
		    book.setAuthor(author);
		    book.setCategory(category);
		    book.setPages(pages);
		    book.setPublishYear(publishYear);
		    book.setLanguage(language);
		    book.setAvailableBooks(availableBooks);
		    book.setTotalBooks(totalBooks);
		    book.setIsbn(isbn);
		    book.setCoverPath(coverPath);
		    book.setPublisher(publisher);
		    book.setDescription(description);
			
		}
	    
	  

	    saved = true;
	    dispose();
	}
	
	public void loadData() {
		if (book != null) {
			   txtTitle.setText(book.getTitle());
		        txtAutor.setText(book.getAuthor());

		        cmbCategory.setSelectedItem(book.getCategory());

		        txtPages.setText(String.valueOf(book.getPages()));
		        txtPublishYear.setText(String.valueOf(book.getPublishYear()));
		        txtLanguage.setText(book.getLanguage());

		        txtAvailableBooks.setText(
		                String.valueOf(book.getAvailableBooks())
		        );

		        txtTotalBooks.setText(
		                String.valueOf(book.getTotalBooks())
		        );

		        txtIsbn.setText(book.getIsbn());
		        txtCoverPath.setText(book.getCoverPath());
		        txtPublisher.setText(book.getPublisher());

		        txtDescription.setText(book.getDescription());
		}
	}
	
	public void loadCategories() {

	    CategoriaRepository repo =
	            new CategoriaRepository();

	    List<Categoria> categorias =
	            repo.getCategorias();

	    for (Categoria categoria : categorias) {
	        cmbCategory.addItem(categoria);
	    }
	}
	
	public boolean isSaved() {
		
		return saved;
		
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
			lblErrorAutor.setText("El autor es requerido");
			return false;
		}
		
		if (!txtAutor.getText().matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
			lblErrorAutor.setText("Solo se permite letras y espacios");
			return false;
		}
		
		if (txtTitle.getText().trim().length() < 2) {
			lblErrorAutor.setText("El limite minimo es de 3 caracteres");
			return false;
		}
		
		if (txtTitle.getText().trim().length() > 70) {
			lblErrorAutor.setText("El limite maximo es de 50 caracteres");
			return false;
		}
		
		lblErrorAutor.setText("");
		
		return true;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}