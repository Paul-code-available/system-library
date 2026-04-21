package views;


import models.User;
import utils.AppFont;

import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

public class HomeView extends JPanel{

    public static final String HOME = "HOME";
    public static final String USERS = "USERS";
    public static final String BOOKS = "BOOKS";
    public static final String BORROW = "BORROW";
    public static final String REPORTS = "REPORTS";
    public static final String ADMINISTRATION = "ADMINISTRATION";

    public JPanel homePanel;
    public UsersView usersView;
    public JPanel books;
    public JPanel borrow;
    public JPanel reports;
    public JPanel administration;


    public JButton btnHome;
    public JButton btnAllUsers;
    public JButton btnAllBooks;
    public JButton btnBorrowRequests;
    public JButton btnAccountRequests;
    public JButton btnRole;
    public JButton btnAccount;

    private CardLayout cardLayout;
    private JPanel contenedor;

    //public UsersView usersPanel;

    public HomeView(){
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10,10,10));

        panelIzquierdo();
        crearVistas();
        setVisible(true);
    }


    public void panelIzquierdo(){
        JPanel panelIzquierdoPrincipal = new JPanel();
        panelIzquierdoPrincipal.setLayout(new BoxLayout(panelIzquierdoPrincipal, BoxLayout.Y_AXIS));
        add(panelIzquierdoPrincipal, BorderLayout.WEST);

        btnHome = new JButton("Inicio");
        btnHome.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnHome);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAllUsers = new JButton("Usuarios");
        btnAllUsers.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAllUsers);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAllBooks = new JButton("Libros");
        btnAllBooks.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAllBooks);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnBorrowRequests = new JButton("Préstamos");
        btnBorrowRequests.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnBorrowRequests);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAccountRequests = new JButton("Reportes");
        btnAccountRequests.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAccountRequests);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));
        
        btnRole = new JButton("Administración");
        btnRole.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnRole);
    }

    private void crearVistas(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        homePanel = new JPanel();
        usersView = new UsersView();
        books = new JPanel();
        borrow = new JPanel();
        reports = new JPanel();
        administration = new JPanel();

        contenedor.add(homePanel, HOME);
        contenedor.add(usersView, USERS);
        contenedor.add(books, BOOKS);
        contenedor.add(borrow, BORROW);
        contenedor.add(reports, REPORTS);
        contenedor.add(administration, ADMINISTRATION);

        add(contenedor, BorderLayout.CENTER);
    }

    public void mostrarVista(String view){
        cardLayout.show(contenedor, view);
    }


}
