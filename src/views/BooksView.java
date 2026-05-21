package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import models.Book;
import utils.SwingUtils;

public class BooksView extends JPanel {
	
	public BooksView() {
		setLayout(new GridBagLayout());
		
		mainPanel();
	}
	
	public void mainPanel() {
		GridBagConstraints gbc = new GridBagConstraints();

	    gbc.insets = new Insets(10, 10, 10, 80);
	
	  

	    gbc.gridx = 0;
	    gbc.gridy = 0;

	    JButton b1 = SwingUtils.crearBtn("");
	   
	    Book book1 = new Book(
	    	"The Hobbit",
	   	    "J.R.R. Tolkien",
	   	    "Fantasy",
	   	    310,
	   	    1937,
	   	    "English",
	   	    5,
	   	    10,
	   	    "9780547928227",
	   	    "/assets/img/hobbit.jpg",
	   	    "George Allen & Unwin",
	   	    "A fantasy novel about the adventure of Bilbo Baggins."
	    );

	    add(new BookPanel(book1), gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    
	  
	    
	    add(new BookPanel(book1), gbc);
	    
	    
	    gbc.gridx = 2;
	    gbc.gridy = 0;
	    
	   
	    
	    add(new BookPanel(book1), gbc);
	    
	    
	    gbc.gridx = 3;
	    gbc.gridy = 0;
	    
	    
	    add(new BookPanel(book1), gbc);
	    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    
	    
	    add(new BookPanel(book1), gbc);
	    
	    
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    
	   
	    
	    add(new BookPanel(book1), gbc);
	    
	    
	    gbc.gridx = 2;
	    gbc.gridy = 1;
	    
	   
	    add(new BookPanel(book1), gbc);
	    
	    gbc.gridx = 3;
	    gbc.gridy = 1;
	
	    add(new BookPanel(book1), gbc);
	    
	    
	  
		
		
	}
	
	
	
	
	
}
