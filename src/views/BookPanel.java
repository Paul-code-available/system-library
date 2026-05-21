package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Book;

public class BookPanel extends JPanel {

	private Book book;
	
	public BookPanel(Book book) {
		this.book = book;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ImageIcon icon = new ImageIcon(
				getClass().getResource(book.getCoverPath())
		);
		
		Image scaled = icon.getImage().getScaledInstance(
			    160,
			    210,
			    Image.SCALE_SMOOTH
		);
		
		JLabel cover = new JLabel(new ImageIcon(scaled));
		cover.setAlignmentX(CENTER_ALIGNMENT);
		
		add(cover);
		
		JLabel title = new JLabel(book.getTitle());
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		add(title);
		
		JLabel author = new JLabel(book.getAuthor());
		author.setAlignmentX(CENTER_ALIGNMENT);
		
		add(author);
		
		JLabel category = new JLabel(book.getCategory());
		category.setAlignmentX(CENTER_ALIGNMENT);
		
		add(category);
	}
	
	
	
}
