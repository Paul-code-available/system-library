package views;


import models.User;
import utils.AppFont;
import utils.SwingUtils;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

public class HomeView extends JPanel{

    public static final String HOME = "HOME";
    public static final String USERS = "USERS";
    public static final String BOOKS = "BOOKS";
    public static final String BORROW = "BORROW";
    public static final String REPORTS = "REPORTS";
    public static final String ACCOUNT = "ACCOUNT";

    public InicioView inicioView;
    public UsersView usersView;
    public BooksView booksView;
    public BorrowView borrowView;
    public ReportsView reportsView;
    public AccountView accountView;

    public JButton btnHome;
    public JButton btnUsers;
    public JButton btnBooks;
    public JButton btnBorrow;
    public JButton btnReports;
    public JButton btnAccount;

    private CardLayout cardLayout;
    private JPanel contenedor;
    
    private HomeWindow window;

    //public UsersView usersPanel;

    public HomeView(){
    	//this.window = window;
        setLayout(new BorderLayout());
        
        UIManager.put("TextComponent.arc", 15);
		UIManager.put("Button.arc", 10);

        panelIzquierdo();
        crearVistas();
        setVisible(true);
        
    }


    public void panelIzquierdo(){
        JPanel panelIzquierdoPrincipal = new JPanel();
        panelIzquierdoPrincipal.setPreferredSize(new Dimension(180, 0));
        panelIzquierdoPrincipal.setLayout(new BoxLayout(panelIzquierdoPrincipal, BoxLayout.Y_AXIS));
        panelIzquierdoPrincipal.setBackground(Color.decode("#16374E"));
        add(panelIzquierdoPrincipal, BorderLayout.WEST);
     
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));
        
        JLabel titulo = new JLabel("Casa Leeré");
        titulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        titulo.setFont(AppFont.title());
        titulo.setBackground(Color.decode("#16374E"));
        titulo.setForeground(Color.decode("#F7F8FB"));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        //titulo.setIcon(SwingUtils.cargarIcono("/assets/img/libro-abierto.png", 32, 32));
        panelIzquierdoPrincipal.add(titulo);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(20));

        btnHome = SwingUtils.crearBtn("Inicio");
        btnHome.setBackground(Color.decode("#3673DF"));
        btnHome.setForeground(Color.decode("#F7F8FB"));
        //btnHome.setIcon(SwingUtils.cargarIcono("/assets/img/home (1).png", 22, 22));
        panelIzquierdoPrincipal.add(btnHome);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));
        
        btnUsers = SwingUtils.crearBtn("Usuarios");
        //btnUsers.setIcon(SwingUtils.cargarIcono("/assets/img/user.png", 18, 18));
        panelIzquierdoPrincipal.add(btnUsers);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnBooks = SwingUtils.crearBtn("Libros");
        //btnBooks.setIcon(SwingUtils.cargarIcono("/assets/img/book.png", 18, 18));
        panelIzquierdoPrincipal.add(btnBooks);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnBorrow = SwingUtils.crearBtn("Prestamos");
        //btnBorrowRequests.setIcon(SwingUtils.cargarIcono("/assets/img/two-arrows (1).png", 20, 20));
        panelIzquierdoPrincipal.add(btnBorrow);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));
       
        btnReports = SwingUtils.crearBtn("Reportes");
        //btnReports.setIcon(SwingUtils.cargarIcono("/assets/img/bar-chart.png", 22, 22));
        panelIzquierdoPrincipal.add(btnReports);
        
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));
        
        btnAccount = SwingUtils.crearBtn("Cuenta");
        //btnRoles.setIcon(SwingUtils.cargarIcono("/assets/img/settings.png", 22, 22));
        panelIzquierdoPrincipal.add(btnAccount);
    }

    private void crearVistas(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);
        
        inicioView = new InicioView();
        usersView = new UsersView();
        booksView = new BooksView();
        borrowView = new BorrowView();
        reportsView = new ReportsView();
        accountView = new AccountView();

        
        contenedor.add(inicioView, HOME);
        
        contenedor.add(usersView, USERS);
        contenedor.add(booksView, BOOKS);
        contenedor.add(borrowView, BORROW);
        contenedor.add(reportsView, REPORTS);
        contenedor.add(accountView, ACCOUNT);

        add(contenedor, BorderLayout.CENTER);
    }

    public void mostrarVista(String view){
        cardLayout.show(contenedor, view);
    }
    
    public HomeWindow getWindow() {
		return window;
	}
    
    public void setWindow(HomeWindow window) {
		this.window = window;
	}


}
