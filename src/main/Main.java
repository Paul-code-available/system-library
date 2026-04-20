package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


import controllers.RegisterController;
import controllers.LoginController;
import views.FormBookWindow;
import views.FormUserWindow;
import views.LoginWindow;
import views.HomeWindow;

public class Main {

	public static void main(String[] args) {
		
		FlatDarkLaf.setup();
		
		
		
		//LoginWindow ventanita = new LoginWindow();
		//new LoginController(ventanita.getLoginView());

        // FormBookWindow ventanita = new FormBookWindow();

        // mainWindow ventana = new mainWindow();
		//FormUserWindow ventana = new FormUserWindow();
        //new RegisterController(ventana.getFormUserView());

        HomeWindow ventana = new HomeWindow();
	}

}
