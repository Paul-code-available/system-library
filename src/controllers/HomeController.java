package controllers;

import models.User;
import repository.UserRepository;
import tablemodels.UserTableModel;
import views.HomeView;
import views.HomeWindow;

import javax.swing.*;
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
