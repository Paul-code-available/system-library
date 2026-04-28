package controllers;

import repository.UserRepository;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;

import javax.swing.*;

import models.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	
	public UserController(UsersView view) {
		this.view = view;
		repo = new UserRepository();
	
		this.view.getBtnAdd().addActionListener(e -> {
			openForm(null);
			
		});
		
		this.view.getBtnEdit().addActionListener(e -> {
			int row = view.getSelectedRow();
			
			if (row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			
			openForm(model.getUserAt(row));
			
		});
	}
	
	public void loadUsers() {
		
		try {
			
			List<User> users = repo.getUsers();
			
			if (model == null) {
				model = new UserTableModel(users);
			} else {
				model.setUsers(users);
			}
			
			view.setTableModel(model);
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(view, ex.getMessage());
		}
	}
	
	private void openForm(User user) {
		System.out.println("se abrio el formulario");
		Thread.currentThread().getStackTrace(); 
		UserFormDialog dialog = new UserFormDialog(null, user);
		         
		dialog.setVisible(true);
		
		if (dialog.isSaved()) {
			
			User savedUser = dialog.getUser();
			
			try {
				
				if (user == null) {
					
					repo.save(savedUser);
					
				} else {
					
					int row = view.getSelectedRow();
					repo.update(row, savedUser);
				
				}
				
				loadUsers();
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view, e.getMessage());
			}
		}
	}
}
