package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import components.TextPrompt;

public class SwingUtils {
	
	public static JTextField crearJtfText(String prompt) {
		
		JTextField jtf = new JTextField();
		jtf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		jtf.setAlignmentX(Component.LEFT_ALIGNMENT);
		TextPrompt promptNombre = new TextPrompt(prompt, jtf);
		
		return jtf;
		
	}
	
	public static JLabel createLblTitle(String nombre) {
		
		JLabel lbl = new JLabel(nombre);
		lbl.setFont(AppFont.title());
		lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return lbl;
	}
	
	public static JLabel createLblMessageError() {
		
		JLabel lbl = new JLabel();
		lbl.setFont(AppFont.small());
		lbl.setForeground(Color.RED);
		lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		return lbl;
	}
	
	public static JPasswordField createJpfPassword(String prompt) {
		
		JPasswordField jpf = new JPasswordField();
		jpf.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		jpf.setAlignmentX(Component.LEFT_ALIGNMENT);
		TextPrompt promptContrasena = new TextPrompt(prompt, jpf);
		
		return jpf;
		
	}
	
	
}
