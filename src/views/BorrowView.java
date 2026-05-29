package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import tablemodels.BorrowTableModel;
import utils.SwingUtils;

public class BorrowView extends JPanel {
	
	private JTable table;
	JButton btnNewLoan;
	JButton btnEditLoan;
	JButton btnDeleteLoan;
	
	public BorrowView() {
		setLayout(new BorderLayout());
		setBackground(Color.decode("#0F1524"));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		table = new JTable();
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		header();
	}
	
	public void header() {
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnNewLoan = new JButton("Nuevo prestamo");
		btnNewLoan.setBackground(Color.decode("#3673DF"));
		btnNewLoan.setAlignmentX(RIGHT_ALIGNMENT);
		btnNewLoan.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(btnNewLoan);
		
		btnEditLoan = new JButton("Editar");
		btnEditLoan.setBackground(Color.decode("#3673DF"));
		btnEditLoan.setAlignmentX(RIGHT_ALIGNMENT);
		btnEditLoan.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(btnEditLoan);
		
		btnDeleteLoan = new JButton("Eliminar");
		btnDeleteLoan.setBackground(Color.decode("#3673DF"));
		btnDeleteLoan.setAlignmentX(RIGHT_ALIGNMENT);
		btnDeleteLoan.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel.add(btnDeleteLoan);
		
		add(panel, BorderLayout.NORTH);
		
		
		
		
		
		
		
	}
	
	
	
	public JButton getBtnNewLoan() {
		return btnNewLoan;
	}

	public void setBtnNewLoan(JButton btnNewLoan) {
		this.btnNewLoan = btnNewLoan;
	}

	public JButton getBtnEditLoan() {
		return btnEditLoan;
	}

	public void setBtnEditLoan(JButton btnEditLoan) {
		this.btnEditLoan = btnEditLoan;
	}

	public JButton getBtnDeleteLoan() {
		return btnDeleteLoan;
	}

	public void setBtnDeleteLoan(JButton btnDeleteLoan) {
		this.btnDeleteLoan = btnDeleteLoan;
	}

	public void setTableModel(BorrowTableModel model) {
		table.setModel(model);
	}
	
	public JTable getJTable() {
		return table;
	}
	
	public int getSelectedRow() {
    	return table.getSelectedRow();
    }

}
