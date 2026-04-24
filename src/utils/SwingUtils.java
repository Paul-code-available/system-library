package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import views.components.TextPrompt;

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
	
    public static JTextField crearJtf(int largo, int ancho, String prompt) {

        JTextField jtf = new JTextField();
        jtf.setMaximumSize(new Dimension(Integer.MAX_VALUE, ancho));
        TextPrompt promptNombre = new TextPrompt(prompt, jtf);

        return jtf;

    }
    
    public static void moveFocus(JComponent origen, String tecla, String nombre, JComponent destino) {
		origen.getInputMap().put(KeyStroke.getKeyStroke(tecla), nombre);
		origen.getActionMap().put(nombre, new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				destino.requestFocus();
				
			}
		});
	}

    public static void configurarComponente(int largo, int ancho, String prompt, JTextComponent tipoComponente){
        tipoComponente.setMaximumSize(new Dimension(Integer.MAX_VALUE, ancho));
        new TextPrompt(prompt, tipoComponente);
    }
    
    public static JButton crearBtn(String nombre) {
    	
    	JButton btn = new JButton(nombre);
    	
    	btn.setFont(AppFont.large());
        btn.setBackground(Color.decode("#16374E"));
        btn.setBorderPainted(false);
        btn.setForeground(Color.decode("#F4F4FF"));
        btn.setMaximumSize(new Dimension(200, 40));
        btn.setPreferredSize(new Dimension(200, 40));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        
        btn.setIconTextGap(10);
        
   
        btn.setHorizontalTextPosition(SwingConstants.RIGHT);
          
        return btn;
    	
    }
    
    public static ImageIcon cargarIcono(String ruta, int ancho, int largo) {
    	
    	 ImageIcon icon = new ImageIcon(SwingUtils.class.getResource(ruta));
		 
         Image img = icon.getImage();
         Image scaled = img.getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
         
         return new ImageIcon(scaled);
    }


}

