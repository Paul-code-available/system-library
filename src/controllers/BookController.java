package controllers;

import views.BooksView;
import views.FormBookView;

public class BookController {
	
	private BooksView view;
	
	public BookController(BooksView view) {
		this.view = view;
		
		createBook();
	}
	
	public void createBook() {
		
		view.getCreateNewBook().addActionListener(e -> {
			
			FormBookView form = new FormBookView(null);
		   
			
			form.setVisible(true);
			
		});
		
	}

}
