package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;


import controllers.RegisterController;
import trash.LoginView;
import views.FormBookWindow;
import views.FormUserWindow;
import views.LoginWindow;
import views.mainWindow;

public class Main {

	public static void main(String[] args) {
		
		FlatDarkLaf.setup();
		
		//LoginWindow ventanita = new LoginWindow();

        // FormBookWindow ventanita = new FormBookWindow();

        FormUserWindow ventana = new FormUserWindow();

        // mainWindow ventana = new mainWindow();

        new RegisterController(ventana.getFormUserView());
	}

}
