package controllers;

import java.util.List;

import javax.swing.JOptionPane;

import models.Book;
import repository.LibroRepository;
import views.BooksView;
import views.FormBookView;

public class BookController {
	
	private BooksView view;
	private FormBookView formView;
	private LibroRepository repo;
	
	public BookController(BooksView view) {
		this.view = view;
		
		repo = new LibroRepository();
		
		listeners();
	}
	
	public void listeners() {
		
		view.getCreateNewBook().addActionListener(e -> {
			createBook(null);
		});
		
		
		
		
	}
	
	public void createBook(Book book) {
			
			FormBookView form = new FormBookView(null, book);
		   
			form.setVisible(true);
			
			if (form.isSaved()) {
				
				Book savedBook = form.getBook();

				try {
					
					if (book == null) {
						repo.save(savedBook);
						
					} else {
						repo.update(savedBook);
					}
					
					view.loadBooks();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(view, e2.getMessage());
				}
				
			}
				
	}
	
	public List<Book> loadBooks() {
		
		List<Book> books = null;
		
		try {
			
			books = repo.getLibros();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, e.getMessage());
		}
		
		
		return books;
	}

}
