package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


import controllers.HomeController;
import controllers.RegisterController;
import controllers.LoginController;
import views.*;

public class Main {

	public static void main(String[] args) {
		
		FlatLightLaf.setup();
	
		//LoginWindow ventanita = new LoginWindow();
		//new LoginController(ventanita.getLoginView());

		/*
		LoginWindow ventanita = new LoginWindow();
		new LoginController(ventanita.getLoginView());
		*/
		
        HomeWindow homesito = new HomeWindow();
        new HomeController(homesito.getHomeView());
		
		//FormUserWindow ventana = new FormUserWindow();
        //new RegisterController(ventana.getFormUserView());


	}

}
