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
		
		FlatDarkLaf.setup();
		
		
		
		//LoginWindow ventanita = new LoginWindow();
		//new LoginController(ventanita.getLoginView());

		/*
		LoginWindow ventanita = new LoginWindow();
		new LoginController(ventanita.getLoginView());
		*/
        // FormBookWindow ventanita = new FormBookWindow();

        //HomeWindow homesito = new HomeWindow();
        //new HomeController(homesito.getHomeView());

		FormUserWindow ventana = new FormUserWindow();
        new RegisterController(ventana.getFormUserView());


	}

}
