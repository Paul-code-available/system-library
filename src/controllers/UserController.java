package controllers;

import repository.UserRepository;
import tablemodels.UserTableModel;
import views.UserFormDialog;
import views.UsersView;

import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserController {

	private UsersView view;
	private UserRepository repo;
	private UserTableModel model;
	
	public UserController(UsersView view) {
		this.view = view;
		repo = new UserRepository();
		
		view.getBtnAdd().addActionListener(e -> abrirFormulario());
	}

    private void abrirFormulario(){
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(view);

        UserFormDialog dialogo = new UserFormDialog(null, null);
        dialogo.setSize(500, 400);
        dialogo.setTitle("Registro de usuarios");
        dialogo.setLocationRelativeTo(parent);
        dialogo.setResizable(false);
        dialogo.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        dialogo.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controlCerradoVentana(dialogo);
            }
        });

        dialogo.getBtnRegistro().addActionListener(e -> guardarUsuario(dialogo));
        dialogo.getBtnCancelar().addActionListener(e -> dialogo.dispose());

        dialogo.setVisible(true);
    }

    private void guardarUsuario(UserFormDialog dialogo) {

    }

    private void controlCerradoVentana(UserFormDialog dialogo){
        int opcion = JOptionPane.showConfirmDialog(dialogo, "Seguro que deseas cerrar la ventana? Se perderán todos los datos");

        if (opcion == JOptionPane.YES_OPTION){
            dialogo.dispose();
        }
    }
}
