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
    public static final String ACCOUNT = "ACCOUNT";

    public JPanel homePanel;
    public UsersView usersView;
    public JPanel books;
    public JPanel borrow;
    public JPanel account;


    public JButton btnHome;
    public JButton btnAllUsers;
    public JButton btnAllBooks;
    public JButton btnBorrowRequests;
    public JButton btnAccountRequests;
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

        btnHome = new JButton("Home");
        btnHome.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnHome);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAllUsers = new JButton("All Users");
        btnAllUsers.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAllUsers);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAllBooks = new JButton("All Books");
        btnAllBooks.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAllBooks);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnBorrowRequests = new JButton("Borrow Requests");
        btnBorrowRequests.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnBorrowRequests);
        panelIzquierdoPrincipal.add(Box.createVerticalStrut(10));

        btnAccountRequests = new JButton("Account Requests");
        btnAccountRequests.setFont(AppFont.large());
        panelIzquierdoPrincipal.add(btnAccountRequests);
    }

    private void crearVistas(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        homePanel = new JPanel();
        usersView = new UsersView();
        books = new JPanel();
        borrow = new JPanel();
        account = new JPanel();

        contenedor.add(homePanel, HOME);
        contenedor.add(usersView, USERS);
        contenedor.add(books, BOOKS);
        contenedor.add(borrow, BORROW);
        contenedor.add(account, ACCOUNT);

        add(contenedor, BorderLayout.CENTER);
    }

    public void mostrarVista(String view){
        cardLayout.show(contenedor, view);
    }


}
