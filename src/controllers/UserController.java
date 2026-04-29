package controllers;

import repository.UserRepository;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;

import javax.swing.*;

import models.User;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
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
		
		this.view.getBtnDelete().addActionListener(e -> {
			int row = view.getSelectedRow();
			
			if (row == -1) {
				JOptionPane.showMessageDialog(view, "Selecciona un usuario");
				return;
			}
			
			System.out.println("Se ejecuta borrar usuario");
			borrarUsuario(model.getUserAt(row));
			
		});

        //this.view.getBtnPdf().addActionListener(e -> {});
		
	}

    public void generatePdf(){

    }
	
	public void borrarUsuario(User user) {
		
		user.setName("");
		user.setEmail("");
		user.setCelular("");
		
		int row = view.getSelectedRow();
		try {
			
			repo.update(row, user);
			
		} catch (IOException e) {
		
			JOptionPane.showMessageDialog(view, e.getMessage());
			
		}
		
	}
	
	private void openForm(User user) {
	
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
}
