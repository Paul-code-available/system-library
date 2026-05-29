package controllers;


import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import models.Borrow;
import models.Prestamo;
import repository.BorrowRepository;
import repository.PrestamoRepository;
import tablemodels.BorrowTableModel;
import views.BorrowView;
import views.FormNewBorrowView;

public class BorrowController {

    private BorrowView view;
    private PrestamoRepository repo;
    private BorrowTableModel model;

    public BorrowController(BorrowView view) {
        this.view = view;
        this.repo = new PrestamoRepository();

        listeners();
        loadBorrows(); 
    }

    public void listeners() {

        view.getBtnNewLoan().addActionListener(e -> {
            try {
				openForm(null);
			} catch (IOException e1) {
		
				e1.printStackTrace();
			}
        });

        view.getBtnEditLoan().addActionListener(e -> {

            int row = view.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Selecciona un préstamo");
                return;
            }

            Prestamo selected = model.getBorrowAt(row);
            try {
				openForm(selected);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        });

        view.getBtnDeleteLoan().addActionListener(e -> {

            int row = view.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Selecciona un préstamo");
                return;
            }

            Prestamo selected = model.getBorrowAt(row);

            int confirm = JOptionPane.showConfirmDialog(
                    view,
                    "¿Estás seguro de eliminar este préstamo?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                boolean deleted = repo.delete(selected.getIdPrestamo());

                if (deleted) {
                    model.removeRow(row);
                }
            }
        });
    }

    private void openForm(Prestamo prestamo) throws IOException {

        FormNewBorrowView dialog = new FormNewBorrowView(null, prestamo);
        dialog.setVisible(true);

        if (!dialog.isSaved()) return;

        Prestamo loanSave = dialog.getPrestamo();

        try {

            if (prestamo == null) {

                repo.save(loanSave);
                model.addRow(loanSave);

            } else {


                loanSave.setIdPrestamo(prestamo.getIdPrestamo());

                boolean updated = repo.update(loanSave);

                if (updated) {
                    loadBorrows();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(dialog, e.getMessage());
        }
    }

    public void loadBorrows() {

        try {
            List<Prestamo> borrows = repo.getPrestamos();

            if (model == null) {
                model = new BorrowTableModel(borrows);
            } else {
                model.setBorrows(borrows);
            }

            view.setTableModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }
}


