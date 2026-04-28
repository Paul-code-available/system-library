package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

import models.User;
import utils.AppFont;
import utils.SwingUtils;

public class UserFormDialog extends JDialog {

		private JLabel jlbTitulo;
	    private JTextField txtNombre;
	    private JTextField txtEmail;
	    private JTextField txtNumero;
	    
	    private JButton btnSave;
	    private JButton btnCancel;

	    private User user;
	    private boolean saved = false;

	    public UserFormDialog(JFrame parent, User user){
	    	super(parent, true);
	    	
	    	this.user = user;
	    	
	    	setTitle(user == null ? "Agregar usuario" : "Editar usuario");

	        setLayout(new BorderLayout());
	        // setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	
	        setSize(340, 340);                          
			setLocationRelativeTo(parent);

	        UIManager.put("Text.Component.arc", 10);
	        UIManager.put("Button.arc", 10);

	        crearHeader();
	        createFormPanel();
	        crearBtnPanel();
	        
	        loadData();

	    }

	    public void crearHeader(){
	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	        jlbTitulo = SwingUtils.createLblTitle("Formulario");
	        panel.add(jlbTitulo);
	        
	        panel.add(Box.createVerticalStrut(10));

	        add(panel, BorderLayout.NORTH);
	    }

	    public void createFormPanel(){

	        JPanel panel = new JPanel(); 
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			
	        txtNombre = SwingUtils.crearJtfText("Nombre");
	        panel.add(txtNombre);

	        panel.add(Box.createVerticalStrut(10));

	        txtEmail = SwingUtils.crearJtfText("Email");
	        panel.add(txtEmail);
	        
	        panel.add(Box.createVerticalStrut(10));
	        
	        txtNumero = SwingUtils.crearJtfText("Numero");
	        panel.add(txtNumero);
	        
	        panel.add(Box.createVerticalStrut(10));

	        add(panel, BorderLayout.CENTER);
	    }

	    public void crearBtnPanel(){
	    	
	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	        add(panel, BorderLayout.SOUTH);

	        btnSave = new JButton("Guardar");
	        panel.add(btnSave);
	        
	        panel.add(Box.createHorizontalStrut(10));
	        
	        btnCancel = new JButton("Cancelar");
	        panel.add(btnCancel);
	        
	        btnSave.addActionListener(e -> save());
	        btnCancel.addActionListener(e -> dispose());
	        
	        add(panel, BorderLayout.SOUTH);

	    }
	    
	    public void loadData() {
	    	
	    	if (user != null) {
				txtNombre.setText(user.getName());
				txtEmail.setText(user.getEmail());
				txtNumero.setText(user.getCelular());
			}
	    }
	    
	    public void save() {
	    	
	    	String name = txtNombre.getText();
	    	String email = txtEmail.getText();
	    	String celular = txtNumero.getText();

	        if(user == null) {
	        	user = new User(name, email, celular);
	        } else {
	        	user.setName(name);
	        	user.setEmail(email);
	        	user.setCelular(celular);
	        }
	        
	        saved = true;
	        dispose();
	        
	    }
	    
	    public boolean isSaved() {
	    	return saved;
	    }
	    
	    public User getUser() {
	    	return user;
	    }

	   



	    
	}


