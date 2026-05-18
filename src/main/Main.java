package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


import controllers.HomeController;
import controllers.RegisterController;
import utils.ThemeManager;
import controllers.LoginController;
import views.*;

public class Main {

	public static void main(String[] args) {
		
		//FlatLightLaf.setup();
		
		UIManager.put("Text.Component.arc", 10);
        UIManager.put("Button.arc", 10);
		
		ThemeManager.applySavedTheme();

		/*
		LoginWindow ventanita = new LoginWindow();
		new LoginController(ventanita.getLoginView());
		*/
		
        HomeWindow homesito = new HomeWindow();
        new HomeController(homesito.getHomeView());
		
		/*
		FormUserWindow ventana = new FormUserWindow();
        new RegisterController(ventana.getFormUserView());
		*/

	}

}
