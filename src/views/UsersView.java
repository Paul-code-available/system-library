package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tablemodels.UserTableModel;

public class UsersView extends JPanel{
	
	private JTable table;
	private JButton btnEdit;
	private JButton btnAdd;
	private JButton btnDelete;

	
	public UsersView() {
		setLayout(new BorderLayout());
		table = new JTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
        
        editarUsuarios();
	}
	
	public void editarUsuarios() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnEdit = new JButton("Editar");
		btnAdd = new JButton("Añadir");
		btnDelete = new JButton("Borrar");
		
		panel.add(btnEdit);
		panel.add(btnAdd);
		panel.add(btnDelete);
		
		add(panel, BorderLayout.NORTH);
	}
	
	public void setTableModel(UserTableModel model) {
		table.setModel(model);
	}
	
	public JTable getTable() {
		return table;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}
	
	public int getSelectedRow() {
    	return table.getSelectedRow();
    }

}
