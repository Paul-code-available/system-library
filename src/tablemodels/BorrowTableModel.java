package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Borrow;

public class BorrowTableModel extends AbstractTableModel {
	
	private List<Borrow> borrows;
	
	private final String[] colums = {
		"Usuario",
		"Libro",
		"Fecha",
		"Estado"
	};
	
	public BorrowTableModel(List<Borrow> borrows) {
		this.borrows = borrows;
	}

	@Override
	public int getRowCount() {
		return borrows.size();
	}

	@Override
	public int getColumnCount() {
		return colums.length;
	}
	
	public String getColumnName(int column) {
		return colums[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Borrow borrow = borrows.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return borrow.getUser().getName();
		
		case 1:
			return borrow.getBook().getTitle();
		
		case 2:
			return borrow.getLoanDate();
			
		case 3:
			return borrow.getStatus();
	
		}
		
		return null;
		
	}
	
	public Borrow getBorrowAt(int row) {
		return borrows.get(row);
	}
	
	public void setBorrows(List<Borrow> borrows) {
		this.borrows = borrows;
		fireTableDataChanged();
	}
	
	public void removeRow(int row) {
		borrows.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	public void addRow(Borrow borrow) {
		int row = borrows.size();
		borrows.add(borrow);
		fireTableRowsInserted(row, row);
	}
	
	public void updateRow(int row, Borrow borrow) {
		borrows.set(row, borrow);
		fireTableRowsUpdated(row, row);
	}

}
