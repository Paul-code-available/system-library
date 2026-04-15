package controllers;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import excepciones.InvalidPasswordException;
import excepciones.InvalidUserException;
import models.User;
import views.FormUserWindow;
import views.LoginView;
import views.mainWindow;

public class LoginController {

	private LoginView view;
	User user;
	
	public LoginController(LoginView view) {
		this.view = view;
		this.user = new User();
		
		loginListeners();

		// assignListeners(user);
	}
	
	private void loginListeners() {
		
		view.getBtnIniciarSesion().addActionListener(e -> handleLogin());
		
		view.getBtnRegister().addActionListener(e -> handleRegistration());
	
	}
	
	public void handleLogin() {
		
		user.setEmail(view.getTxtEmail().getText());
		user.setPassword(new String(view.getJpfContrasena().getPassword()));
		
		try {
			
			if (validateLogin(user)) {
				new mainWindow();
				view.getWindow().dispose();
			}
			
		} catch (InvalidUserException e2) {
			view.showEmailError("Verifica el correo");
		} catch (InvalidPasswordException e1) {
			view.showPasswordError("Verifica la contraseña");
		}
		
	}
	
	public void handleRegistration() {
		new RegisterController(new FormUserWindow().getFormUserView());
		view.getWindow().dispose();
	}
	
	/*
	private void assignListeners(User user) {
		
		view.getTxtEmail().getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					validateEmail(user);
				} catch (InvalidUserException e1) {
					
				}				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				 try {
					validateEmail(user);
				 } catch (InvalidUserException e1) {
					
				 }
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
 				try {
					validateEmail(user);
				} catch (InvalidUserException e1) {
					
				}
			}
			
		});
		
		view.getJpfContrasena().getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					validatePassword(user);
				} catch (InvalidPasswordException e1) {
				
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					validatePassword(user);
				} catch (InvalidPasswordException e1) {
					
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					validatePassword(user);
				} catch (InvalidPasswordException e1) {
					
				}
			}
			
		});
		
	}
	*/
	
	
	private boolean validateLogin(User user) throws InvalidUserException, InvalidPasswordException {
		
		view.resetMessages();
		
		boolean valid = true;
		
		if (!validateEmail(user)) {
			valid = false;
		}
		
		if (!validatePassword(user)) {
			valid = false;
		}
		
		return valid;
		
	}
	
	private boolean validateEmail(User user) throws InvalidUserException {
		
		if (user.getEmail().trim().isEmpty()) {
			view.showEmailError("El email es requerido");
			return false;
		}
		
		if (user.getEmail().trim().length() > 30) {
			view.showEmailError("Longitud maxíma alcanzada");
			return false;
		}
		
		if (!user.getEmail().contains("@")) {
			view.showEmailError("Falta '@' en el email");
			return false;
		}
		
		
		if (!user.getEmail().trim().isEmpty() && !user.getEmail().equals("juanitoalcachofa123@gmail.com")) {
			throw new InvalidUserException("Usuario no registrado");
		}
		
		return true;
		
	}
	
	private boolean validatePassword(User user) throws InvalidPasswordException {
		
		if (user.getPassword().trim().isEmpty()) {
			view.showPasswordError("La contraseña es requerida");
			return false;
		}
		
		if (user.getPassword().trim().length() > 20) {
			view.showPasswordError("Longitud maxíma alcanzada");
			return false;
		}

		
	if (!user.getPassword().trim().isEmpty() && !user.getPassword().trim().equals("1234")) {
			throw new InvalidPasswordException("Contraseña incorrecta");
		}
		
		return true;
		
	}
	
}
