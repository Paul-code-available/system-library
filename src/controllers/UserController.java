package controllers;

import repository.UserRepository;
import tablemodels.UserTableModel;
import views.FormUserWindow;
import views.UserFormDialog;
import views.UsersView;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	
	public UserController(UsersView view) {
		this.view = view;
		repo = new UserRepository();
		
		view.getBtnAdd().addActionListener(e -> {
			/*
			FormUserWindow ventana = new FormUserWindow();
			ventana.setVisible(true);
			*/
	        //new UserFormDialog(ventana.getFormUserView());
			
			FormUserWindow ventana = new FormUserWindow();
			UserFormDialog dialogo = new UserFormDialog(ventana, null);
		
			
	
		});
	}
	
}
