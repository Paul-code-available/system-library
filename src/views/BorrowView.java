package views;

import java.awt.Color;

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
	
	public BorrowView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.decode("#0F1524"));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		table = new JTable();
		
		add(new JScrollPane(table));
		
		header();
	}
	
	public void header() {
		JButton btnNewLoan = SwingUtils.crearBtn("Nuevo prestamo");
		btnNewLoan.setBackground(Color.decode("#3673DF"));
		btnNewLoan.setAlignmentX(RIGHT_ALIGNMENT);
		btnNewLoan.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		add(btnNewLoan);
		
	}
	
	public void setTableModel(BorrowTableModel model) {
		table.setModel(model);
	}
	
	public JTable getJTable() {
		return table;
	}

}
