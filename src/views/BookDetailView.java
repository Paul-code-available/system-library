package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Book;
import repository.LibroRepository;
import utils.RoundedImageLabel;

public class BookDetailView extends JDialog {
	
	private Book book;
	
	JButton edit;
	JButton delete;
	
	BooksView view;

	public BookDetailView(JFrame parent, Book book, BooksView view) {
	    super(parent, true);

	    this.book = book;
	    this.view = view;
	    
	    setSize(300, 540);
	    setLocationRelativeTo(parent);
	    setLayout(new BorderLayout());
	    
	    mainPanel();
	    
	}
	
	public void mainPanel() {
		
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    panel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    panel.setBackground(Color.decode("#141D30"));

	    Font font = new Font("Segoe UI", Font.PLAIN, 14);

	    JLabel t1 = new JLabel("Título: " + book.getTitle());
	    JLabel t2 = new JLabel("Autor: " + book.getAuthor());
	    JLabel t3 = new JLabel("Categoría: " + book.getCategory().getNombre());
	    JLabel t4 = new JLabel("Páginas: " + book.getPages());
	    JLabel t5 = new JLabel("Año: " + book.getPublishYear());
	    JLabel t6 = new JLabel("<html>Descripción:<br>" + book.getDescription() + "</html>");

	    JLabel[] labels = {t1, t2, t3, t4, t5, t6};

	    for (JLabel l : labels) {
	        l.setFont(font);
	        l.setForeground(Color.WHITE);
	        Box.createVerticalStrut(5);
	        panel.add(l);
	    }

	    add(panel, BorderLayout.CENTER);

	    JPanel paneTop = new JPanel();
	    paneTop.setPreferredSize(new Dimension(420, 240));
	    paneTop.setBorder(new EmptyBorder(10, 10, 10, 10));
	    paneTop.setBackground(Color.decode("#141D30")); 
	    paneTop.setLayout(new GridBagLayout()); 

	    RoundedImageLabel img = new RoundedImageLabel(book.getCoverPath());

	    img.setPreferredSize(new Dimension(200, 220));

	    paneTop.add(img);

	    add(paneTop, BorderLayout.NORTH);


	    JPanel buttons = new JPanel();
	    buttons.setBackground(Color.decode("#141D30"));
	    buttons.setBorder(new EmptyBorder(20, 20, 20, 20));

	    edit = new JButton("Editar");
	    delete = new JButton("Eliminar");

	    edit.setBackground(Color.decode("#3673DF"));
	    edit.setForeground(Color.WHITE);
	    edit.setFocusPainted(false);

	    delete.setBackground(Color.decode("#3673DF"));
	    delete.setForeground(Color.WHITE);
	    delete.setFocusPainted(false);

	    buttons.add(edit);
	    buttons.add(delete);

	    add(buttons, BorderLayout.SOUTH);

	  
	    edit.addActionListener(e -> {

	        FormBookView form = new FormBookView((JFrame) getParent(), book);

	        form.setVisible(true);

	        if (form.isSaved()) {
	            Book updated = form.getBook();
	            new LibroRepository().update(updated);
	            view.loadBooks();
	            dispose();
	        }
	    });

	    delete.addActionListener(e -> {

	        int opt = JOptionPane.showConfirmDialog(
	                this,
	                "¿Eliminar este libro?",
	                "Confirmar",
	                JOptionPane.YES_NO_OPTION
	        );

	        if (opt == JOptionPane.YES_OPTION) {
	            new LibroRepository().delete(book.getIdLibro());
	            
	            view.loadBooks();
	            
	            dispose();
	        }
	    });
	}

	public JButton getEdit() {
		return edit;
	}

	public void setEdit(JButton edit) {
		this.edit = edit;
	}

	public JButton getDelete() {
		return delete;
	}

	public void setDelete(JButton delete) {
		this.delete = delete;
	}
	
	

}
