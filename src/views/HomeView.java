package views;

import models.Prestamo;
import repository.LibroRepository;
import repository.PrestamoRepository;
import utils.AppFont;
import utils.SwingUtils;
import javax.swing.*;

import controllers.BookController;

import java.awt.*;
import repository.UserRepository;

public class HomeView extends JPanel{

    public static final String HOME = "HOME";
    public static final String USERS = "USERS";
    public static final String BOOKS = "BOOKS";
    public static final String BORROW = "BORROW";
    public static final String ACCOUNT = "ACCOUNT";
    private final UserRepository userRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    public InicioView inicioView;
    public UsersView usersView;
    public BooksView booksView;
    public BorrowView borrowView;
    public AccountView accountView;

    public JButton btnHome;
    public JButton btnUsers;
    public JButton btnBooks;
    public JButton btnBorrow;
    public JButton btnAccount;

    private CardLayout cardLayout;
    private JPanel contenedor;
    
    private HomeWindow window;

    //public UsersView usersPanel;

    public HomeView(UserRepository userRepository, LibroRepository libroRepository, PrestamoRepository prestamoRepository, HomeWindow window){
        this.userRepository = userRepository;
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;
        this.window = window;
        setLayout(new BorderLayout());
        
        UIManager.put("TextComponent.arc", 15);
		UIManager.put("Button.arc", 10);

        panelIzquierdo();
        crearVistas();
        setVisible(true);
    }


    public void panelIzquierdo(){
        JPanel panelIzquierdoPrincipal = new JPanel();
        panelIzquierdoPrincipal.setPreferredSize(new Dimension(200, 0));
        panelIzquierdoPrincipal.setLayout(new BoxLayout(panelIzquierdoPrincipal, BoxLayout.Y_AXIS));
        panelIzquierdoPrincipal.setBackground(Color.decode("#090C18"));
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
        
        btnAccount = SwingUtils.crearBtn("Cuenta");
        //btnRoles.setIcon(SwingUtils.cargarIcono("/assets/img/settings.png", 22, 22));
        panelIzquierdoPrincipal.add(btnAccount);
    }

    private void crearVistas(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);
        
        inicioView = new InicioView(userRepository, libroRepository, prestamoRepository);
        usersView = new UsersView();
        booksView = new BooksView();
        borrowView = new BorrowView();
        accountView = null;

        contenedor.add(inicioView, HOME);
        contenedor.add(usersView, USERS);
        contenedor.add(booksView, BOOKS);
        contenedor.add(borrowView, BORROW);
        contenedor.add(new JPanel(), ACCOUNT);
        //contenedor.add(accountView, ACCOUNT);

        add(contenedor, BorderLayout.CENTER);
    }

    public void mostrarAccount() {
        accountView = new AccountView();
        contenedor.add(accountView, ACCOUNT);
        cardLayout.show(contenedor, ACCOUNT);
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
