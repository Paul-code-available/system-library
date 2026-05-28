package controllers;

import repository.UserRepository;
import services.PDFExporter;
import tablemodels.UserTableModel;
import views.InicioView;
import views.UserFormDialog;
import views.UsersView;

import javax.swing.*;

import models.User;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
    private PDFExporter pdfExporter;
    private InicioView inicioView;
	
	public UserController(UsersView view, InicioView inicioView) {
		this.view = view;
        this.inicioView = inicioView;
		repo = new UserRepository();
        pdfExporter = new PDFExporter();
	
		listeners();
        loadUsers();
	}

	public void listeners() {
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

            if (row == -1){
                JOptionPane.showMessageDialog(view, "Selecciona un usuario");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(view,
                    "¿Estás seguro de eliminar este usuario?",
                    "Confirmar", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                boolean deleted = repo.delete(model.getUserAt(row).getId());
                if (deleted) {
                    model.removeRow(row);
                    inicioView.refresh();
                }
            }
		});

        this.view.getBtnPdf().addActionListener(e -> generatePdf());
		
	}

    public void generatePdf(){

        File file = view.selectPdfFile();

        if (file == null){
            return;
        }

        try{
            pdfExporter.exportUsers(repo.getUsers(), file);
            if (Desktop.isDesktopSupported()){
                Desktop.getDesktop().open(file);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error al exportar");
        }
    }
	
	private void openForm(User user) {
	
		UserFormDialog dialog = new UserFormDialog(null, user);
		         
		dialog.setVisible(true);
		
		if (dialog.isSaved()) {
			
			System.out.println(dialog.getUser());
			
			
			User savedUser = dialog.getUser();
			
			try {
				
				if (user == null) {
					repo.save(savedUser);
					model.addRow(savedUser);
                    inicioView.refresh();
				} else {
                    boolean updated = repo.update(savedUser);
					if (updated) {
                        int row = view.getSelectedRow();
						model.updateRow(row, savedUser);
                        inicioView.refresh();
					}
					
				}
				
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
