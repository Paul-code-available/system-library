package models;

import java.time.LocalDate;

public class Borrow {
	
	private int id;
	
	private User user;
	private Book book;
	
	private LocalDate loanDate;
	private LocalDate returnDate;
	
	private String status;
	
	public Borrow() {
		
	}

	public Borrow(int id, User user, Book book, LocalDate loanDate, LocalDate returnDate, String status) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.loanDate = loanDate;
		this.returnDate = returnDate;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
