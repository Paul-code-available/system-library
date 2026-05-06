package controllers;

import models.User;
import repository.UserRepository;
import tablemodels.UserTableModel;
import utils.Config;
import views.HomeView;
import views.HomeWindow;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

public class HomeController {

    private HomeView homeView;
    private UserController userController;

	public HomeController(HomeView homeView) {
		this.homeView = homeView;
		
		//loadWindowPreferences();
        registerListeners();

	}

    public void registerListeners() {
    	/*
    	homeView.getWindow().addWindowListener(new WindowAdapter() {
    			
    		public void windowClosing(WindowEvent e) {
    			//saveWindowPreferences();
    		}
    		
    	});
    	*/
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
        
        homeView.btnBorrow.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.BORROW);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnBorrow.setBackground(Color.decode("#3673DF"));
        	homeView.btnBorrow.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnReports.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.REPORTS);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnReports.setBackground(Color.decode("#3673DF"));
        	homeView.btnReports.setForeground(Color.decode("#F7F8FB"));
        });
        
        homeView.btnAccount.addActionListener(e -> {
        	homeView.mostrarVista(HomeView.ACCOUNT);

        	resetearBotones();
        	resetearTexto();
        	
        	homeView.btnAccount.setBackground(Color.decode("#3673DF"));
        	homeView.btnAccount.setForeground(Color.decode("#F7F8FB"));
        });
        
    }
    
    public void resetearBotones() {
    	
    	homeView.btnHome.setBackground(Color.decode("#16374E"));
    	homeView.btnUsers.setBackground(Color.decode("#16374E"));
		homeView.btnBooks.setBackground(Color.decode("#16374E"));
		homeView.btnBorrow.setBackground(Color.decode("#16374E"));
		homeView.btnReports.setBackground(Color.decode("#16374E"));
		homeView.btnAccount.setBackground(Color.decode("#16374E"));
		
    }
    
    public void resetearTexto() {
    	
    	homeView.btnHome.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnUsers.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnBooks.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnBorrow.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnReports.setForeground(Color.decode("#DFE1E0"));
    	homeView.btnAccount.setForeground(Color.decode("#DFE1E0"));
  
    }

    public void mostrarUsuarios(){
    	
    	if (userController == null) {
			userController = new UserController(homeView.usersView);
		}
    	
    	userController.loadUsers();
    	
    	homeView.mostrarVista(homeView.USERS);

    }
    
    /*
    
    private void saveWindowPreferences() {
    	Dimension size = homeView.getSize();
    	Point point = homeView.getLocation();
    	
    	Config.set("registration.window.width", String.valueOf(size.width));
    	Config.set("registration.window.height", String.valueOf(size.height));
		Config.set("registration.window.x", String.valueOf(point.x));
		Config.set("registration.window.y", String.valueOf(point.y));
    }
    
    private void loadWindowPreferences() {
    	int width = Integer.parseInt(Config.get("registration.window.width", "500"));
		
		int height = Integer.parseInt(Config.get("registration.window.height", "500"));
		
		String xValue = Config.get("registration.window.x", "");
		
		String yValue = Config.get("registration.window.y", "");
		
		if(!xValue.isBlank() && !yValue.isBlank()) {
			//homeView.getWindow().setWindowLocation(Integer.parseInt(xValue), Integer.parseInt(yValue));
		}else {
			homeView.getWindow().setLocationRelativeTo(null);
		}
		
		homeView.getWindow().setWindowSize(width, height);
	}
	
	*/
    
   

}
