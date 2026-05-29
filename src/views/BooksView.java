package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import models.Book;
import repository.LibroRepository;
import utils.RoundedImageLabel;
import utils.SwingUtils;

public class BooksView extends JPanel {
	
	private JPanel panelBooks;
    private JScrollPane scroll;
	private JButton createNewBook;
	
	
	public BooksView() {
		setLayout(new GridBagLayout());
		setBackground(Color.decode("#0F1524"));
		
		mainPanel();
		loadBooks();
	}
	
	public void mainPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		
	    gbc.insets = new Insets(10, 10, 10, 20);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    JLabel numberOfBooks = new JLabel("Libros registrados 8");
	    numberOfBooks.setForeground(Color.decode("#FFFFFF"));
	    numberOfBooks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	   
	    
	    add(numberOfBooks, gbc);
	    
	    gbc.gridx = 1;
	    gbc.anchor = GridBagConstraints.EAST;
		    
		createNewBook = SwingUtils.crearBtn("Crear libro");
	
		createNewBook.setBackground(Color.decode("#3673DF"));
		createNewBook.setForeground(Color.decode("#F7F8FB"));
		    
		add(createNewBook, gbc);
		
		panelBooks = new JPanel(new GridBagLayout());
		panelBooks.setOpaque(false);
		
		scroll = new JScrollPane(panelBooks);
	    scroll.setBorder(null);
	    scroll.getViewport().setOpaque(false);
	    scroll.setOpaque(false);

	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.gridwidth = 2;
	    gbc.weightx = 1;
	    gbc.weighty = 1;
	    gbc.fill = GridBagConstraints.BOTH;

	    add(scroll, gbc);

	}
	
	
	public void loadBooks() {
		LibroRepository repo = new LibroRepository();
	    List<Book> libros = repo.getLibros();

	    panelBooks.removeAll();

	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(15, 15, 15, 15);
	    gbc.anchor = GridBagConstraints.NORTHWEST;

	    int col = 0;
	    int row = 0;
	    int maxCols = 4;

	    for (Book b : libros) {

	        BookPanel card = new BookPanel(b, this);

	        gbc.gridx = col;
	        gbc.gridy = row;

	        panelBooks.add(card, gbc);

	        col++;
	        if (col == maxCols) {
	            col = 0;
	            row++;
	        }
	    }

	    panelBooks.revalidate();
	    panelBooks.repaint();
	}

	public JButton getCreateNewBook() {
		return createNewBook;
	}

	public void setCreateNewBook(JButton createNewBook) {
		this.createNewBook = createNewBook;
	}

	

	
	
	
	
	
	
}
