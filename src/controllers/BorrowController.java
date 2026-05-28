package controllers;


import java.util.List;

import javax.swing.JOptionPane;

import models.Borrow;
import repository.BorrowRepository;
import tablemodels.BorrowTableModel;
import views.BorrowView;

public class BorrowController {
	
	private BorrowView view;
	private BorrowRepository repo;
	private BorrowTableModel model;
	
	public BorrowController(BorrowView view) {
		this.view = view;
		repo = new BorrowRepository();
		
		
	}
	
	public void loadBorrows() {
		
		try {
			
			List<Borrow> borrows = repo.getBorrows();
			
			if (model == null) {
				model = new BorrowTableModel(borrows);
			} else {
				model.setBorrows(borrows);
			}
			
			view.setTableModel(model);
			
		} catch (Exception e) {
			System.out.println("aqui");
			JOptionPane.showMessageDialog(view, e.getMessage());
		}
		
	}

}
