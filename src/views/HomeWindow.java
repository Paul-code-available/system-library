package views;

import models.Prestamo;
import repository.LibroRepository;
import repository.PrestamoRepository;
import repository.UserRepository;

import javax.swing.JFrame;

public class HomeWindow extends JFrame{

    private HomeView homeView;

	public HomeWindow() {

        setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setTitle("Casa Leeré");

        UserRepository userRepository = new UserRepository();
        LibroRepository libroRepository = new LibroRepository();
        PrestamoRepository prestamoRepository = new PrestamoRepository();
        homeView = new HomeView(userRepository, libroRepository, prestamoRepository, this);
        add(homeView);

        setVisible(true);
	}

    public HomeView getHomeView(){
        return homeView;
    }

    public void setWindowSize(int width, int height) {
		setSize(width, height);
	}
	
	public void setWindowLocation(int x, int y) {
		setLocation(x, y);
	}
	
}
