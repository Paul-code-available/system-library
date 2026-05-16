package controllers;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import exceptions.InvalidPasswordException;
import exceptions.InvalidUserException;
import models.User;
import repository.LoginRepository;
import utils.Session;
import views.FormUserWindow;
import views.HomeView;
import views.LoginView;
import views.HomeWindow;

public class LoginController {

	private LoginView view;
	private LoginRepository repository;
	
	public LoginController(LoginView view) {
		repository = new LoginRepository();
		this.view = view;
		
		loginListeners();
		
	}
	
	private void loginListeners() {
		
		view.getBtnIniciarSesion().addActionListener(e -> handleLogin());
		
		view.getBtnRegister().addActionListener(e -> handleRegistration());
	
	}
	
	public void handleLogin() {
		
		if (!validateLogin(new User(view.getEmail(), view.getPassword()))) {
			return;
		}
		
		
		System.out.println(view.getPassword());
		User user = repository.login(view.getEmail(), view.getPassword());
		
		if (user == null) {
			view.showPasswordError("Verifica los datos ingresados");
			return;
		}
		
		
		Session.login(user);
		
		if (Session.getRole().equalsIgnoreCase("admin")) {
			JOptionPane.showMessageDialog(view.getWindow(), "Se inició sesión");
			new HomeController(new HomeWindow().getHomeView());
		} else {
			JOptionPane.showMessageDialog(view.getWindow(), "No eres admin");
		}
		
		view.getWindow().dispose();
		
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
	
	
	private boolean validateLogin(User user) {
		
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
	
	private boolean validateEmail(User user) {
		
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
		
		return true;
		
	}
	
	private boolean validatePassword(User user) {

		if (user.getPassword().trim().isEmpty()) {
			view.showPasswordError("La contraseña es requerida");
			return false;
		}
		
		return true;
		
	}
	
}
