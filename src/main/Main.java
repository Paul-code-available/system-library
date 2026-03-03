package main;

import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import trash.LoginView;
import views.FormBookWindow;
import views.FormularioWindowUsuario;
import views.LoginWindow;

public class Main {

	public static void main(String[] args) {
		
		FlatDarkLaf.setup();
		
		LoginWindow ventanita = new LoginWindow();
		
		// FormBookWindow ventanita = new FormBookWindow();

        // FormularioWindowUsuario ventana = new FormularioWindowUsuario();

		
	}

}
