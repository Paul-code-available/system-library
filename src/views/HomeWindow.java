package views;

import javax.swing.JFrame;

public class HomeWindow extends JFrame{

    private HomeView homeView;

	public HomeWindow() {

        setSize(900, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setTitle("Casa Leeré");

        homeView = new HomeView();
        add(homeView);

        setVisible(true);
	}

    public HomeView getHomeView(){
        return homeView;
    }

	public void setWindowSize(int width, int height) {
		setWindowSize(width, height);
		
	}
	
}
