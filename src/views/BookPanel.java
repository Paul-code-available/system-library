package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.Book;
import utils.AppFont;
import utils.RoundedImageLabel;
import utils.SwingUtils;

public class BookPanel extends JPanel {

	private Book book;

	public BookPanel(Book book) {
		this.book = book;
		
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(170, 300));
		
		setBorder(
				BorderFactory.createEmptyBorder(
						15,15,15,15 
				)
		);
	
		RoundedImageLabel roundedImage = new RoundedImageLabel(book.getCoverPath());
		roundedImage.setAlignmentX(LEFT_ALIGNMENT);
		add(roundedImage);
		
		add(Box.createVerticalStrut(10));
		
		JLabel title = new JLabel(book.getTitle());
		title.setFont(new Font("Segoe UI", Font.BOLD, 14));
		title.setForeground(Color.decode("#FFFFFF"));
		title.setAlignmentX(LEFT_ALIGNMENT);
		
		add(title);
		
		JLabel author = new JLabel(book.getAuthor());
		author.setForeground(Color.decode("#FFFFFF"));
		author.setAlignmentX(LEFT_ALIGNMENT);
		
		add(author);
		
		JLabel category = new JLabel(book.getCategory());
		category.setForeground(Color.decode("#FFFFFF"));
		category.setAlignmentX(LEFT_ALIGNMENT);
		
		add(category);
		
		add(Box.createVerticalStrut(10));
		
		
		JButton watchBook = SwingUtils.crearBtn("Ver libro");
		watchBook.setBackground(Color.decode("#3673DF"));
		watchBook.setForeground(Color.decode("#F7F8FB"));
		watchBook.setFont(AppFont.medium());
		watchBook.setAlignmentX(LEFT_ALIGNMENT);
		watchBook.setHorizontalAlignment(SwingConstants.CENTER);
		watchBook.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		
		add(watchBook);

	}
	
	protected void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2.setColor(Color.decode("#141D30"));
		
		g2.fillRoundRect(
				0,
				0,
				getWidth(),
				getHeight(),
				30,
				30
		);
		
		g2.dispose();
		
		super.paintComponent(g);
		
	}
	
	
	
}
