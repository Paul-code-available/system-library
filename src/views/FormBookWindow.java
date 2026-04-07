package views;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FormBookWindow extends JFrame{
	
	public FormBookWindow() {
		
		setSize(340, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setResizable(false);

		setLocationRelativeTo(null);
		
		FormBookView formularioLibros = new FormBookView();
		
		setVisible(true);
		add(formularioLibros);
		
	}

}
