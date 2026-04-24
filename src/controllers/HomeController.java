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
        homeView.btnUsers.addActionListener(e -> mostrarUsuarios());

        homeView.btnHome.addActionListener(e -> homeView.mostrarVista(HomeView.HOME));
        
        homeView.btnHome.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnHome.setBackground(Color.decode("#3673DF"));
        		homeView.btnHome.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnHome.setBackground(Color.decode("#16374E"));
        		homeView.btnHome.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        homeView.btnUsers.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnUsers.setBackground(Color.decode("#3673DF"));
        		homeView.btnUsers.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnUsers.setBackground(Color.decode("#16374E"));
        		homeView.btnUsers.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        homeView.btnBooks.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnBooks.setBackground(Color.decode("#3673DF"));
        		homeView.btnBooks.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnBooks.setBackground(Color.decode("#16374E"));
        		homeView.btnBooks.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        homeView.btnBorrowRequests.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnBorrowRequests.setBackground(Color.decode("#3673DF"));
        		homeView.btnBorrowRequests.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnBorrowRequests.setBackground(Color.decode("#16374E"));
        		homeView.btnBorrowRequests.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        homeView.btnReports.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnReports.setBackground(Color.decode("#3673DF"));
        		homeView.btnReports.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnReports.setBackground(Color.decode("#16374E"));
        		homeView.btnReports.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        homeView.btnRoles.addMouseListener(new MouseAdapter() {
        	public void mouseEntered(MouseEvent e) {
        		homeView.btnRoles.setBackground(Color.decode("#3673DF"));
        		homeView.btnRoles.setForeground(Color.decode("#F7F8FB"));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		homeView.btnRoles.setBackground(Color.decode("#16374E"));
        		homeView.btnRoles.setForeground(Color.decode("#DFE1E0"));
        	}
		});
        
        
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
