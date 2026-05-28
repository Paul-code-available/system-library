package models;

import javax.swing.ImageIcon;

import utils.RoundedImageLabel;

public class Book {
	
	private int id;
	
	private String title;
	private String author;
	private String category;
	private int pages;
	private int publishYear;

	private String language;
	private int availableBooks;
	private int totalBooks;

	private String isbn;
	private String coverPath;
	
	private String publisher;
	private String description;
	
	public Book() {
		
	}
	
	public Book(String title, String author, String category, int pages, int publishYear, String language,
			int availableBooks, int totalBooks, String isbn, String coverPath, String publisher, String description) {
		
		this.title = title;
		this.author = author;
		this.category = category;
		this.pages = pages;
		this.publishYear = publishYear;
		this.language = language;
		this.availableBooks = availableBooks;
		this.totalBooks = totalBooks;
		this.isbn = isbn;
		this.coverPath = coverPath;
		this.publisher = publisher;
		this.description = description;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getAvailableBooks() {
		return availableBooks;
	}

	public void setAvailableBooks(int availableBooks) {
		this.availableBooks = availableBooks;
	}

	public int getTotalBooks() {
		return totalBooks;
	}

	public void setTotalBooks(int totalBooks) {
		this.totalBooks = totalBooks;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
