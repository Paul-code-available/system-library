package tablemodels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Borrow;
import models.Prestamo;

public class BorrowTableModel extends AbstractTableModel {
	
	private List<Prestamo> borrows;
	
	private final String[] colums = {
		"Usuario",
		"Libro",
		"Fecha",
		"Estado"
	};
	
	public BorrowTableModel(List<Prestamo> borrows) {
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
		
		Prestamo borrow = borrows.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return borrow.getUser().getName();
		
		case 1:
			return borrow.getLibro().getTitle();
		
		case 2:
			return borrow.getFechaPrestamo();
			
		case 3:
			return borrow.getEstado();
	
		}
		
		return null;
		
	}
	
	public Prestamo getBorrowAt(int row) {
		return borrows.get(row);
	}
	
	public void setBorrows(List<Prestamo> borrows) {
		this.borrows = borrows;
		fireTableDataChanged();
	}
	
	public void removeRow(int row) {
		borrows.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	public void addRow(Prestamo borrow) {
		int row = borrows.size();
		borrows.add(borrow);
		fireTableRowsInserted(row, row);
	}
	
	public void updateRow(int row, Prestamo borrow) {
		borrows.set(row, borrow);
		fireTableRowsUpdated(row, row);
	}

}
