package controllers;

import models.User;
import repository.UserRepository;
import tablemodels.UserTableModel;
import views.HomeView;
import views.HomeWindow;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class HomeController {

    private HomeView homeView;

	public HomeController(HomeView homeView) {
		this.homeView = homeView;
        registerListeners();

	}

    public void registerListeners(){
    	
    	homeView.btnHome.addActionListener(e -> {
    		homeView.mostrarVista(HomeView.HOME);
    		
    		resetearBotones();
    		resetearTexto();
    	
    		homeView.btnHome.setBackground(Color.decode("#3673DF"));
    		homeView.btnHome.setForeground(Color.decode("#F7F8FB"));
    	
    		
    	});
    	
        homeView.btnUsers.addActionListener(e -> {
        	mostrarUsuarios();

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnUsers.setBackground(Color.decode("#3673DF"));
        	homeView.btnUsers.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnBooks.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.BOOKS);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnBooks.setBackground(Color.decode("#3673DF"));
        	homeView.btnBooks.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnBorrowRequests.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.BORROW);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnBorrowRequests.setBackground(Color.decode("#3673DF"));
        	homeView.btnBorrowRequests.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnReports.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.REPORTS);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnReports.setBackground(Color.decode("#3673DF"));
        	homeView.btnReports.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnRoles.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.ADMINISTRATION);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnRoles.setBackground(Color.decode("#3673DF"));
        	homeView.btnRoles.setForeground(Color.decode("#F7F8FB"));
        });
        
    }
    
    public void resetearBotones() {
    	
    	homeView.btnHome.setBackground(Color.decode("#16374E"));
    	homeView.btnUsers.setBackground(Color.decode("#16374E"));
		homeView.btnBooks.setBackground(Color.decode("#16374E"));
		homeView.btnBorrowRequests.setBackground(Color.decode("#16374E"));
		homeView.btnReports.setBackground(Color.decode("#16374E"));
		homeView.btnRoles.setBackground(Color.decode("#16374E"));
		
    }
    
    public void resetearTexto() {
    	
    	homeView.btnHome.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnUsers.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnBooks.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnBorrowRequests.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnReports.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnRoles.setForeground(Color.decode("#DFE1E0"));
  
    }

    public void mostrarUsuarios(){
    	
    	UserController controller = new UserController(homeView.usersView);
    	
        UserRepository repository = new UserRepository();

        try{
            List<User> users = repository.getUsers();

            UserTableModel model = new UserTableModel(users);

            homeView.usersView.setTableModel(model);

            homeView.mostrarVista(HomeView.USERS);

        }catch (IOException ex){
            JOptionPane.showMessageDialog(homeView, ex.getMessage());
        }
    }
	
}
