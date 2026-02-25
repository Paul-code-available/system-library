package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormBookWindow extends JFrame{
	
	public FormBookWindow() {
		
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(true);

		setLocationRelativeTo(null);
		
		FormBookView formularioLibros = new FormBookView();
		
		setVisible(true);
		add(formularioLibros);
		
	}

}
