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

import exceptions.InvalidRegisterEmailException;
import exceptions.InvalidUserException;
import models.User;
import utils.AppFont;
import utils.SwingUtils;

public class UserFormDialog extends JDialog {

		private JLabel jlbTitulo;
	    private JTextField txtNombre;
	    private JTextField txtEmail;
	    private JTextField txtNumero;
        private JTextField txtRol;
        
        private JLabel jlbErrorName;
        private JLabel jlbErrorEmail;
        private JLabel jlbErrorCel;
        private JLabel jlbErrorRol;
	    
	    private JButton btnSave;
	    private JButton btnCancel;

	    private User user;
	    private boolean saved = false;

	    public UserFormDialog(JFrame parent, User user){
	    	super(parent, true);
	    	
	    	this.user = user;
	    	
	    	setTitle(user == null ? "Agregar usuario" : "Editar usuario");

	        setLayout(new BorderLayout());
	
	        setSize(340, 380);                          
			setLocationRelativeTo(parent);

	        crearHeader();
	        createFormPanel();
	        crearBtnPanel();
	        
	        loadData();

	    }

	    public void crearHeader(){
	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

	        jlbTitulo = SwingUtils.createLblTitle("Formulario");
	        panel.add(jlbTitulo);

	        add(panel, BorderLayout.NORTH);
	    }

	    public void createFormPanel(){

	        JPanel panel = new JPanel(); 
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
			
	        txtNombre = SwingUtils.crearJtfText("Nombre");
	        panel.add(txtNombre);
	        
	        jlbErrorName = SwingUtils.createLblMessageError();
	        panel.add(jlbErrorName);

	        panel.add(Box.createVerticalStrut(10));

	        txtEmail = SwingUtils.crearJtfText("Email");
	        panel.add(txtEmail);
	        
	        jlbErrorEmail = SwingUtils.createLblMessageError();
	        panel.add(jlbErrorEmail);
	        
	        panel.add(Box.createVerticalStrut(10));
	        
	        txtNumero = SwingUtils.crearJtfText("Numero");
	        panel.add(txtNumero);
	        
	        jlbErrorCel = SwingUtils.createLblMessageError();
	        panel.add(jlbErrorCel);

            panel.add(Box.createVerticalStrut(10));

            txtRol = SwingUtils.crearJtfText("Rol");
            panel.add(txtRol);

            jlbErrorRol = SwingUtils.createLblMessageError();
            panel.add(jlbErrorRol);
            
            panel.add(Box.createVerticalStrut(10));

	        add(panel, BorderLayout.CENTER);
	    }

	    public void crearBtnPanel(){
	    	
	        JPanel panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
	        add(panel, BorderLayout.SOUTH);

	        btnSave = new JButton("Guardar");
	        panel.add(btnSave);
	        
	        panel.add(Box.createHorizontalStrut(10));
	        
	        btnCancel = new JButton("Cancelar");
	        panel.add(btnCancel);
	    
	        btnSave.addActionListener(e -> handleRegister());
	        btnCancel.addActionListener(e -> dispose());
	        
	        add(panel, BorderLayout.SOUTH);

	    }
	    
	    public void loadData() {
	    	if (user != null) {
				txtNombre.setText(user.getName());
				txtEmail.setText(user.getEmail());
				txtNumero.setText(user.getPhone());
                txtRol.setText(user.getRole());
			}
	    }
	    
	    public void save() {
	    	
	    	String name = txtNombre.getText();
	    	String email = txtEmail.getText();
	    	String celular = txtNumero.getText();
            String rol = txtRol.getText();

	        if(user == null) {
	        	user = new User(name, email, celular, rol);
	        } else {
	        	user.setName(name);
	        	user.setEmail(email);
	        	user.setPhone(celular);
                user.setRole(rol);
	        }
	        
	        saved = true;
	        dispose();
	        
	    }
	    
	    public void handleRegister() {
	    	
	    	User user = new User(
	    			txtNombre.getText(), 
	    			txtEmail.getText(),
	    			txtNumero.getText(),
	    			txtRol.getText()
	    			);
	    	
	    	try {
				
	    		if (validateForm(user)) {
					save();
				}
	    		
			} catch (InvalidRegisterEmailException e1) {
				e1.printStackTrace();
			} catch (InvalidUserException e2) {
				e2.printStackTrace();
			}
	    	
	    }
	    
	    private boolean validateForm(User user) throws InvalidUserException, InvalidRegisterEmailException {
	    	
	    	resetMessages();
	    	
	    	boolean valid = true;
	    	
	    	if (!validateName(user)) {
				valid = false;
			}
	    	
	    	if (!validateEmail(user)) {
				valid = false;
			}
	    	
	    	if (!validateCel(user)) {
				valid = false;
			}
	    	
	    	if (!validateRol(user)) {
				valid = false;
			}
	    	
	    	return valid;
	    	
	    }
	    
	    public boolean validateName(User user) throws InvalidUserException {
	    	
	    	if (user.getName().isBlank()) {
	    		showErrorName("Nombre requerido");
			}
	    	
	    	if (user.getName().trim().length() >= 40) {
				showErrorName("Longitud maxima excedida");
			}
	    	
	    	if (user.getName().trim().length() < 4) {
				showErrorName("Longitud minima es de 4 caracteres");
			}
	    	
	    	return true;
	    	
	    }
	    
	    public boolean validateEmail(User user) throws InvalidRegisterEmailException {
	    	
			if (user.getEmail().trim().isEmpty()) {
				showEmailError("El email es requerido");
				return false;
			}
			
			if (user.getEmail().trim().length() > 30) {
				showEmailError("Longitud maxíma alcanzada");
				return false;
			}
			
			if (!user.getEmail().contains("@")) {
				showEmailError("Falta '@' en el email");
				return false;
			}
			
			// verficar duplicados
			
	    	return true;
	    }
	    
	    public boolean validateCel(User user) {
	    	
	    	if (user.getPhone().trim().isBlank()) {
				showErrorCel("El celular es requerido");
			}
	    	
	    	if (user.getPhone().trim().length() != 10) {
				showErrorCel("El número debe contener 10 digitos");
			}
	    	
	    	for (int i = 0; i < user.getPhone().length(); i++) {
				
	    		char c = user.getPhone().charAt(i);
	    		
	    		if (!Character.isDigit(c)) {
					showErrorCel("Solo puedes ingresar numeros");
				}
			}
	    	
	    	// verificar duplicados
	    	
	    	return true;
	    }
	    
	    public boolean validateRol(User user) {
	    	
	    	// preferiblemente en un ENUM
	    	
	    	if (user.getRole().trim().isBlank()) {
				showErrorRol("El rol es requerido");
			}
	    	
	    	return true;
	    }
	    
	    public void showErrorName(String message) {
	    	jlbErrorName.setText(message);
	    }
	    
	    public void showEmailError(String message) {
	    	jlbErrorEmail.setText(message);
	    }
	    
	    public void showErrorCel(String message) {
	    	jlbErrorCel.setText(message);
	    }
	    
	    public void showErrorRol(String message) {
	    	jlbErrorRol.setText(message);
	    }
	    
	    public void resetMessages() {
	    	jlbErrorName.setText("");
	    	jlbErrorEmail.setText("");
	    	jlbErrorCel.setText("");
	    	jlbErrorRol.setText("");
	    }
	    
	    public boolean isSaved() {
	    	return saved;
	    }
	    
	    public User getUser() {
	    	return user;
	    }

	   



	    
	}


