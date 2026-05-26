package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import models.Book;
import utils.RoundedImageLabel;
import utils.SwingUtils;

public class BooksView extends JPanel {
	
	JButton createNewBook;
	
	public BooksView() {
		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createEmptyBorder(20,100,20,50));
		mainPanel();
	}
	
	public void mainPanel() {
		GridBagConstraints gbc = new GridBagConstraints();
		
	    gbc.insets = new Insets(10, 10, 10, 60);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    
	    JLabel numberOfBooks = new JLabel("Numero de libros (8)");
	    numberOfBooks.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	    
	    add(numberOfBooks, gbc);
	    
	    gbc.gridx = 3;
		gbc.gridy = 0;
		    
		createNewBook = SwingUtils.crearBtn("Crear nuevo libro");
		createNewBook.setBackground(Color.decode("#3673DF"));
		createNewBook.setForeground(Color.decode("#F7F8FB"));
		    
		add(createNewBook, gbc);

	    gbc.gridx = 0;
	    gbc.gridy = 1;
	   
	    Book book1 = new Book(
	        	"The Hobbit",
	       	    "J.R.R. Tolkien",
	       	    "Fantasía",
	       	    310,
	       	    1937,
	       	    "Español",
	       	    5,
	       	    10,
	       	    "9780547928227",
	       	    "/assets/img/the_hobbit.png",
	       	    "George Allen & Unwin",
	       	    "Una novela de fantasía sobre la aventura de Bilbo Baggins."
	    );

	    add(new BookPanel(book1), gbc);

	    gbc.gridx = 1;
	    gbc.gridy = 1;

	    Book book2 = new Book(
	        	"Harry Potter and...",
	            "J.K. Rowling",
	       	    "Fantasía",
	       	    309,
	       	    1997,
	       	    "Español",
	            7,
	       	    12,
	       	    "9780590353427",
	       	    "/assets/img/harry_potter_1.png",
	       	    "Bloomsbury",
	       	    "La primera historia de Harry Potter descubriendo el mundo mágico."
	    );

	    add(new BookPanel(book2), gbc);

	    gbc.gridx = 2;
	    gbc.gridy = 1;

	    Book book3 = new Book(
	        	"Clean Code",
	            "Robert C. Martin",
	            "Programación",
	            464,
	       	    2008,
	       	    "Español",
	            3,
	       	    5,
	       	    "9780132350884",
	            "/assets/img/clean_code.png",
	       	    "Prentice Hall",
	       	    "Una guía para escribir código limpio, mantenible y profesional."
	    );

	    add(new BookPanel(book3), gbc);

	    gbc.gridx = 3;
	    gbc.gridy = 1;

	    Book book4 = new Book(
	        	"Atomic Habits",
	       	    "James Clear",
	       	    "Autoayuda",
	       	    320,
	       	    2018,
	       	    "Español",
	       	    4,
	       	    8,
	       	    "9780735211292",
	       	    "/assets/img/atomic_habits.png",
	       	    "Avery",
	       	    "Estrategias prácticas para construir buenos hábitos y romper malos hábitos."
	    );

	    add(new BookPanel(book4), gbc);

	    gbc.gridx = 0;
	    gbc.gridy = 2;

	    Book book5 = new Book(
	       	    "The Pragmatic Programmer",
	       	    "Andrew Hunt & David Thomas",
	       	    "Programación",
	       	    352,
	       	    1999,
	       	    "Español",
	       	    2,
	       	    4,
	       	    "9780201616224",
	       	    "/assets/img/pragmatic_programer.png",
	       	    "Addison-Wesley",
	       	    "Un libro clásico sobre el desarrollo de software y buenas prácticas de programación."
	    );

	    add(new BookPanel(book5), gbc);

	    gbc.gridx = 1;
	    gbc.gridy = 2;

	    Book book6 = new Book(
	            "1984",
	            "George Orwell",
	            "Distopía",
	            328,
	            1949,
	            "Español",
	            6,
	            10,
	            "9780451524935",
	            "/assets/img/1984.png",
	            "Secker & Warburg",
	            "Una novela distópica sobre vigilancia y control autoritario."
	    );

	    add(new BookPanel(book6), gbc);

	    gbc.gridx = 2;
	    gbc.gridy = 2;

	    Book book7 = new Book(
	       	    "The Alchemist",
	       	    "Paulo Coelho",
	       	    "Ficción",
	       	    208,
	       	    1988,
	       	    "Español",
	       	    8,
	       	    10,
	       	    "9780061122415",
	       	    "/assets/img/the_alchemist.png",
	       	    "HarperOne",
	       	    "Una historia sobre perseguir sueños y descubrir el propio destino."
	    );

	    add(new BookPanel(book7), gbc);

	    gbc.gridx = 3;
	    gbc.gridy = 2;

	    Book book8 = new Book(
	        	"To Kill a Mockingbird",
	            "Harper Lee",
	       	    "Clásico",
	       	    281,
	       	    1960,
	       	    "Español",
	       	    4,
	       	    7,
	       	    "9780060935467",
	       	    "/assets/img/to_kill_a_mockingbird.png",
	       	    "J.B. Lippincott & Co.",
	       	    "Una novela que explora la justicia, la moralidad y el racismo."
	    );
	    
	    add(new BookPanel(book8), gbc);
		
	}


	
	
	
	
	
	
}
