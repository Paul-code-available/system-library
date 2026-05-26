package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Book;
import utils.RoundedImageLabel;

public class BookPanel extends JPanel {

	private Book book;
	
	public BookPanel(Book book) {
		this.book = book;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
		RoundedImageLabel roundedImage = new RoundedImageLabel(book.getCoverPath());
		roundedImage.setAlignmentX(LEFT_ALIGNMENT);
		add(roundedImage);
		
		JLabel title = new JLabel(book.getTitle());
		title.setAlignmentX(LEFT_ALIGNMENT);
		
		add(title);
		
		JLabel author = new JLabel(book.getAuthor());
		author.setAlignmentX(LEFT_ALIGNMENT);
		
		add(author);
		
		JLabel category = new JLabel(book.getCategory());
		category.setAlignmentX(LEFT_ALIGNMENT);
		
		add(category);
	}
	
	
	
}
